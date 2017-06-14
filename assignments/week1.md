## Week 1 Assignments

There are two assignments for Week 1:

* Go through (some of) the 2017 G3 Robotics repository and find one line of code that you now know something about. It's OK if you don't understand everything going on, but be prepared to explain what you do understand. You do not need to read all of the code.

* Put your coding skills to work by creating an Ascii Animation. You will find some sample shapes below, which you can use if you want to. Your program should include:
  * Functions other than `main()` and the utility functions
  * Some documentation (comments) that describe what's going on
  * Flow control elements (`while`, `if`, `for`)

Reminder: the `\` (backslash character) has special meaning inside Strings - it's the "escape character". You can use it to make a "newline character" with `\n` (adds a new line). If you actually want a "real backslash" you will need to use *two* backslashes (`"\\"`). You can see this in the example below (the "X" shape).

Extra Info: The `System.out.println()` method always prints a new line. You may find this undesirable. You can use `System.out.print()` instead, which does NOT print a new line. Try them both and see!

I've posted an example in the solutions-examples folder.

```java
public class AsciiDrawing {
    public static void main(String args[]) throws Exception {
        System.out.println("Hello ...");

        System.out.println("Here is a line:");
        System.out.println("------------------------------------------");
        System.out.println();

        System.out.println("Here is a vertical line:");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println();

        System.out.println("Here is a slanted line:");
        System.out.println("\\");
        System.out.println(" \\");
        System.out.println("  \\");
        System.out.println("   \\");
        System.out.println("    \\");
        System.out.println("     \\");
        System.out.println("      \\");
        System.out.println("       \\");
        System.out.println("        \\");
        System.out.println();

        System.out.println("Here is a circle:");
        System.out.println("   ooo   ");
        System.out.println(" oo   oo");
        System.out.println("o       o");
        System.out.println(" oo   oo");
        System.out.println("   ooo");
        System.out.println();

        System.out.println("Here is an X:");
        System.out.println("\\       /");
        System.out.println(" \\     /");
        System.out.println("  \\   /");
        System.out.println("   \\ /");
        System.out.println("    \\");
        System.out.println("   / \\");
        System.out.println("  /   \\");
        System.out.println(" /     \\");
        System.out.println("/       \\");
        System.out.println();

    }
}
```
