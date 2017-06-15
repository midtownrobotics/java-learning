## Mini-Lesson: Getting User Input, Imports

When writing early programs it's nice to be able to get input from the user. This way we can make our programs interactive and responsive. We'll get into how all of this works soon, but for now, here is a quick way to get input from the user.


```java
import java.util.Scanner;

public static String getStringFromUser () {
    return (new Scanner(System.in).nextLine());
}

public static int getNumberFromUser () {
    return Integer.parseInt(getStringFromUser());
}
```

In order for these functions to work, you will need the `import java.util.Scanner` line at the TOP of your class file (above the `public class <class-name>` line). You can use these functions to get a String (such as a name, favorite food, color, or really any text the user wants to type in) or a number (their guess for the secret number).
