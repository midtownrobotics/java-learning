## Exceptions and Control Flow

What is Exception Handling? Essentially, it is a form of control flow (like `if` statements, loops, etc.) that allows us to decide how our program should react to various circumstances. For example, let's say we need the user to enter a number. But what if they don't enter a number? Copy and run the code below and try inputing something other than a number. "Yellow" for example.

```java
public class Main {
  public static void main (String [] args) {
    System.out.println("Please enter a number.");
    String input = System.console().readLine();
    int userNumber = Integer.parseInt(input);
    System.out.println("You entered " + userNumber);
  }
}
```

You should see that a `NumberFormatException` is thrown (assuming you did not enter a number). Exception handling allows us to decide what in this unexpected circumstance.

In the example below, you will see that (if you do not enter a number) the line `System.out.println("You entered " + userNumber)` does not run. This is because as soon as the exception is thrown (in this case from the `Integer.parseInt(String)` call) the JVM will skip to the appropriate `catch` block (if one exists).

```java
public class Main {
  public static void main (String [] args) {
    System.out.println("Please enter a number.");
    String input = System.console().readLine();
    try {
      int userNumber = Integer.parseInt(input);
      System.out.println("You entered " + userNumber);
    } catch (NumberFormatException ex) {
      System.out.println("You did not enter a number. Goodbye.");
    }
  }
}
```

### The Syntax

Let's lay out the basic syntax of exception handling. We will go into more details and examples later in the lesson.

```java
try {
    //Code to attempt that might throw an exception
    //This block could contain nested try/catch blocks
} catch (<type of exception you want to catch>) {
    //Code to execute if <type> exception is thrown
    //Often includes exception.printStackTrace()
} //Potentially more catch blocks
finally {
    //Code to execute at the end of the block
    //Usually used to clean up resources
}
```

### Using Multiple Catch Blocks

It's possible to have `try/catch` blocks with multiple `catch` statements. We'll see an example of that next.

"FizzBuzz" is a common early programming challenge that you may have encountered before. The challenge is as follows: write a program that prints out the numbers 1-100, but if the number is divisible by three, print "Fizz" instead. If it's divisible by five, print "Buzz", and if it's divisible by both three and five print "FizzBuzz". Here is a standard solution for this problem for comparison.

```java
public class FizzBuzzNoEx {
    public static void main(String[] args) {
        for (int index = 1; index <= 100; index++) {
            if (index % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (index % 3 == 0) {
                System.out.println("Fizz");
            } else if (index % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(index);
            }
        }
    }
}
```

Now let's solve this challenge using Java's Exception handling. We will start out by defining three new types of exceptions for use in our project; `DivBy15`, `DivBy3`, and `DivBy5`. To define our own custom exceptions all we have to do is extend the `Exception` class. If we needed to, we could add constructors or additional functionality to these special exceptions.

```java
class DivBy3 extends Exception{
}
class DivBy5 extends Exception {
}
class DivBy15 extends Exception {
}
```

```java

public class FizzBuzzExceptions {

    public static void main(String[] args) {
        for (int index = 1; index <= 100; index++) {
            try {
                if (index % 15 == 0) {
                    //The "throw" keyword allows us to throw our own exceptions
                    throw new DivBy15();
                }
                if (index % 3 == 0) {
                    throw new DivBy3();
                }
                if (index % 5 == 0) {
                    throw new DivBy5();
                }
                //We will only get here if the number is not a multiple of 3 or 5
                System.out.println(index);
            } catch (DivBy15 ex) {
                System.out.println("FizzBuzz");
            } catch (DivBy3 ex) {
                System.out.println("Fizz");
            } catch (DivBy5 ex) {
                System.out.println("Buzz");
            } catch (Exception ex) {
                System.out.println("Some other kind of exception occurred.");
                //This should never be called
            }
        }
    }
}
class DivBy3 extends Exception{
}
class DivBy5 extends Exception {
}
class DivBy15 extends Exception {
}
```

Note: the specific order we chose for our custom exceptions does not matter because none of them inherit from each other (they all extend Exception). However, if you move the last `catch` block to the top and try to run the code, you will see a compiler error. Because all of our custom exceptions extend `Exception`, this means they ARE Exceptions, and would be caught by the "generic" Exception block if it were first.

### Just When You Thought It Was FINALLY Over...

There's one last piece of the puzzle. try/catch blocks can have a third section, `finally`. This defines a block of code that will always run after the try/catch block. Let's look at the syntax and basic control flow first.

```java runnable
public class FinalTime {
  public static void main (String[] args) {
    try {
      System.out.println("We're in the try block.");
      String s = null;
      //s.toUpperCase();
    } catch (NullPointerException ex) {
      System.out.println("Uh oh, null pointers are bad.");
    } finally {
      System.out.println("Finally, we're done!");
    }
  }
}
```

Experiment with the above code by uncommenting line 6 (`s.toUpperCase()`). This will cause a `NullPointerException` to be thrown (remember, this happens any time we attempt to use dot notation on a null object). You can see that the `finally` block executes regardless of whether an exception is thrown or not.

Now that we've covered the basic syntax and flow, let's look at an example where we would actually want to use `finally`.

```java
PrintWriter printWriter = null;
try {
    printWriter = new PrintWriter("stuff.txt");
} catch (IOException ex) {
    ex.printStackTrace();
} finally {
    if (printWriter != null) {
        printWriter.close();
    }
}
```

The main use for a `finally` block is to clean up resources. We always want to clean up after ourselves by closing resources we're not using. The finally block guarantees that the `PrintWriter` will be closed at the end of our block.
