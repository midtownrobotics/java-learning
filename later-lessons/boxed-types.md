## Boxed Types

By now you should be familiar with the basic primitive data types (`int`, `boolean`, `double`, and so on). Each of these primitive types has a related "boxed type" class. For example:

* `int` => `Integer`
* `double` => `Double`
* `char` => `Character`
* `boolean` => `Boolean`

There are two main reasons you will want to be familiar with these classes:

1. The provide static libraries that are very useful
2. Primitive types can't be added to collections

We'll discuss both of these points in more depth, but first let's examine how these classes work in more detail.

### Autoboxing

Java will allow you to work with these classes as if they are primitive types. So for example, while we certainly can say:

`Integer x = new Integer(7);`

we are not required to, and can use the simpler syntax of primitives:

`Integer x = 7;`

We can also use arithmetic operators (+, - for example, or combined assignment operators like +=):

`x += 5;`

Essentially what's happening behind the scenes is that Java is automatically converting (boxing and unboxing) these types for us.

Here is an example of Java automatically boxing things for us. How nice!

```java
List<Integer> numbers = new ArrayList<>();
int x = 5;
numbers.add(x); //This works even though x is an int and `numbers` expects Integers
```

### Static Methods

Each of these boxed type classes also has a several static methods associated with it. The most common of these are the "parse" methods: `Integer.parseInt()`, `Double.parseDouble()` etc. These methods are very useful in converting Strings (for example, from user input) into their "actual" types. Try running the example below.

```java
import java.util.Scanner;
public class BoxedExample {
  public static void main (String[] args) {
    System.out.println("Do you want to ride the merry go round?");
    System.out.println("Please enter true or false.");
    String input = new Scanner(System.in).nextLine();

    //** The Boolean.parseBoolean() method
    boolean flag = Boolean.parseBoolean(input);
    if (flag) {
      System.out.println("Wheeeeee!!!");
    } else {
      System.out.println("Aw... Ok.");
    }
  }
}
```

User input comes in as a String. Here we used the `Boolean.parseBoolean()` method to convert the user input String into what we wanted; a `true` or `false` value we could use in an `if` statement.

### When To Use Boxed types

As a general rule, only use boxed types when you have a reason to do so. For example, if you needed a list of numbers in your code, a `List<int>` is not possible - primitive types can't be used in collections. If you don't have a specific reason to declare something as an `Integer`, just declare it as an `int`.

### Further Examples

```java
//Here are some examples of how the compiler will effectively convert from primitive to box types for us
List<Integer> numbers = new ArrayList<>();
int x = 5;
numbers.add(x); //This works even though x is an int not an Integer.
//It will be automatically "boxed" into an Integer
Integer y = x;
Integer z = new Integer(7);
numbers.add(z);
int w = numbers.get(0);
Double d = 2.9;
Float f = 2.129f;
d += 1.0; //We can use arithmetic operators (+, -, *, /) as normal
f /= 9293;
```

Here is an example of a static method from the Integer class, `Integer.parseInt()`. It allows us to take a String (for example "4572") and attempt to parse it as an Integer. If the String can't be successfully parsed as an Integer (for example, if the input was not a number, like "hello") a `NumberFormatException` will be thrown. Exceptions are covered in a separate lesson; for now just experiment with the code below and see how it works, and look at the use of the `Integer.parseInt(String)` function.

```java
import java.util.Scanner;
public class BoxTypes {

    public static void main(String[] args) {
        //Integer.parseInt example
        while (true) {
            System.out.println("Please input a number.");

            String input = new Scanner(System.in).nextLine();

            try {
                // **Here is the Integer.parseInt(String s) call**
                int value = Integer.parseInt(input);
                System.out.println("You typed in the number " + value + ". Multiplied by 5 that's " + value * 5 + ".");
            } catch (NumberFormatException ex) {
                System.out.println("That wasn't a number. Goodbye.");
                break;
            }
        }
    }
}
```
