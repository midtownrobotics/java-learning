## Recursion

Imagine that you are a sous-chef in a restaurant. The chef has asked you to cut up a large piece of meat into small cubes. You only have a regular knife, so there is no way you'll be able to make one cut and be done. Instead, the obvious approach should be to slice the problem (the meat) up into smaller pieces. Then, depending on how big of a piece of meat you started with and how small the cubes are supposed to be, you would take those smaller pieces and cut them up again, into even smaller pieces. You'd repeat this process until you have cubes of the desired size.

This is an example of recursion. Recursion is a problem-solving technique to break up a problem into smaller instances of itself and solve those smaller instances (or break them up further as needed). In Java and many other programming languages, this is often accomplished by having a function call itself. The factorial function is a good example of this.

### Factorial

The function factorial (x) is defined as the product of all positive integers less than or equal to x. This might sound intimidating but it's fairly simple. For example,

`factorial(5) = 5 * 4 * 3 * 2 * 1`

`factorial(5) = 120`

`factorial(6) = 6 * 5 * 4 * 3 * 2 * 1`

`factorial(6) = 720`

Outside of computer science, you will see the factorial function expressed with an exclamation mark (`!`). (For example 5! = 120) Because we already use the exclamation mark in Java (the `NOT` operator), it's generally just referred to as factorial.

Here is a non-recursive implementation of factorial:

```java
public class SimpleRecursionExample {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) { //Change the i < 10
            System.out.println(noRecursionFactorial(i));
        }
    }

    public static int noRecursionFactorial (int n) {
        int response = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            response *= i;
        }
        return response;
    }
}
```
Note: factorial grows very fast as you can see! Try playing around to see how large of a factorial we can calculate before overflowing our little integer.

Now let's take a look at solving the same problem with recursion:

```java runnable
public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(factorial(i));
        }
    }

    public static long factorial (int n) {
        if (n == 0) {
            return 1; //Exit
        } else {
            return (n * (factorial(n-1))); //Function calling itself
        }
    }
}
```

That's great and all, but clearly we don't need recursion to calculate factorials. So why do we need recursion?

### Tree Search

Let's say we have a Tree structure that is modeled by the following class:

```java
public class MessageTree {

    private String message;
    private List<MessageTree> children;

    public MessageTree (String message, List<MessageTree> children) {
        this.message = message;
        this.children = children;
    }

    public String getMessage() {
        return message;
    }

    public List<MessageTree> getChildren() {
        return children;
    }
}
```

This forms a "Tree" because each MessageTree can have "children" that it owns. Each MessageTree object is a "Node" on the tree. We will define a specific instance as follows:

```java
List<MessageTree> firstGroup = new ArrayList<>();
firstGroup.add(new MessageTree("1c of 1c", null));
firstGroup.add(new MessageTree("2c of 1c", null));
firstGroup.add(new MessageTree("3c of 1c", null));

List<MessageTree> secondGroup = new ArrayList<>();
secondGroup.add(new MessageTree("1c of 2c", null));
secondGroup.add(new MessageTree("2c of 2c", null));

List<MessageTree> thirdGroup = new ArrayList<>();
thirdGroup.add(new MessageTree("1c of 3c", null));
thirdGroup.add(new MessageTree("2c of 3c", null));
thirdGroup.add(new MessageTree("3c of 3c", null));

List<MessageTree> mainGroup = new ArrayList<>();
mainGroup.add(new MessageTree("1c", firstGroup));
mainGroup.add(new MessageTree("2c", secondGroup));
mainGroup.add(new MessageTree("3c", thirdGroup));

return new MessageTree("Root", mainGroup);
```

Now let's suppose we want to search through this data structure to see if it contains a node with a particular message (note: we will make this problem a little bit easier by not worrying about *where* the message is. We just want to know if it's in the Tree). If we know what the data structure looks like (i.e. the number of "levels", in this case 3), we could write a function like this:

```java
public static boolean containsMessage (String message, MessageTree root) {
  //First check the root
  if (root.getMessage().equals(message)) {
    return true;
  } else {
    //If it's not in the root, check root's children
    for (MessageTree child : root.getChildren()) {
      if (child.getMessage().equals(message)) {
        return true;
      }
    }
    //If it's not in root's children check grandchildren
    for (MessageTree child : root.getChildren()) {
      for (MessageTree grandchild : child.getChildren()) {
        if (child.getMessage().equals(message)) {
          return true;
        }
      }
    }
    return false;
  }
}
```

This is already looking a little bit messy, and this only covers the situation of the tree being exactly three levels deep. We want a solution that works on any size tree. This means we will need to write a recursive search algorithm. This is an example of a problem that can only be solved with recursion. Why? Think about the data structure. It can be arbitrarily deep - imagine a tree with ten levels. Recursion will allow us to break this problem up and solve it.

```java runnable
import java.util.ArrayList;
import java.util.List;

public class RecursionExample {

    public static void main(String[] args) {
        MessageTree root = buildTree();
        System.out.println(searchTree("3c of 3c", root));
        System.out.println(searchTree("1c", root));
        System.out.println(searchTree("Foo", root));
    }

    public static boolean searchTree (String message, MessageTree root) {
        if (root.getMessage().equals(message)) {
            return true;
        }
        if (root.getChildren() != null) {
            for (MessageTree child : root.getChildren()) {
                if (child.getMessage().equals(message)) {
                    return true;
                }
            }
            for (MessageTree child : root.getChildren()) {
                if (searchTree(message, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static MessageTree buildTree () {
        List<MessageTree> firstGroup = new ArrayList<>();
        firstGroup.add(new MessageTree("1c of 1c", null));
        firstGroup.add(new MessageTree("2c of 1c", null));
        firstGroup.add(new MessageTree("3c of 1c", null));

        List<MessageTree> secondGroup = new ArrayList<>();
        secondGroup.add(new MessageTree("1c of 2c", null));
        secondGroup.add(new MessageTree("2c of 2c", null));

        List<MessageTree> thirdGroup = new ArrayList<>();
        thirdGroup.add(new MessageTree("1c of 3c", null));
        thirdGroup.add(new MessageTree("2c of 3c", null));
        thirdGroup.add(new MessageTree("3c of 3c", null));

        List<MessageTree> mainGroup = new ArrayList<>();
        mainGroup.add(new MessageTree("1c", firstGroup));
        mainGroup.add(new MessageTree("2c", secondGroup));
        mainGroup.add(new MessageTree("3c", thirdGroup));

        return new MessageTree("Root", mainGroup);
    }
}

class MessageTree {

    private String message;
    private List<MessageTree> children;

    public MessageTree (String message, List<MessageTree> children) {
        this.message = message;
        this.children = children;
    }

    public String getMessage() {
        return message;
    }

    public List<MessageTree> getChildren() {
        return children;
    }
}
```

Note: if we are lucky enough to  have access to the MessageTree class, we could use the following (slightly more elegant) solution:

```java
public class MessageTree {
    //...
    public boolean contains (String message) {
        if (this.message.equals(message)) {
            return true;
        }
        if (children != null) {
            for (MessageTree child : children) {
                if (child.contains(message)) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

This solution shows a method we have written for the MessageTree class that will recursively search its own Tree! Pretty nifty.

Extra Exercise: Re-write the MessageTree class using Generics.

### Exiting and Stack Overflow

When writing recursive functions it's important to make sure that they will exit. If your recursive function calls itself infinitely you will encounter a `StackOverflowError` before too long.

```java runnable
public class Overflow {
  public static void main (String[] args) {
    myFunction();
  }

  public static void myFunction () {
    myFunction();
    //There is no condition under which this function *won't* recursively call itself
  }
}
```
