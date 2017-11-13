## Lesson 4 - Boolean Logic and Flow Control

We discussed `boolean` values in Lesson 2. We can have boolean (TRUE or FALSE) variables.

```java
boolean fiveMoreThanThree = 5 > 3;
boolean hasPants = true;
```

We can use these boolean variables to control the "flow" of our code and make decisions. The simplest example of flow control is an `if` statement.

### If/Else If/Else

```java
boolean userLoggedIn;

if (userLoggedIn) {
  System.out.println("The user is logged in");
  //Take an action with the user
}
System.out.println("Next statement");
```

The `println()` statement will only be run IF the user is logged in (specifically, if the `userLoggedIn` variable is TRUE). If not, the program will jump over the `if` block and go straight to the next statement. Note that "Next statement" will be printed regardless.

We can extend our use of `if` with `else`, which allows us to define what will happen if the original statement isn't true.

```java
if (userLoggedIn) {
  System.out.println("The user is logged in");
  //Take an action with the user
} else {
  System.out.println("I'm sorry but you must be logged in to use the app");
  //Exit
}
```

Only one of these statements will be reached; either the user is logged in, or they aren't. We can also combine else with if. Let's say we have two int values representing a secret number, and a user's guess of that secret number.

```java
public static boolean checkGuess (int secretNum, int userGuess) {
  if (secretNum == userGuess) {
    System.out.println("You got it right!");
  } else if (secretNum < userGuess) {
    System.out.println("Sorry, your guess was too high");
  } else { //If not needed here; if it's not equal or less than, it must be greater
    System.out.println("Sorry, your guess was too low");
  }
}
```

### Loops

#### While Loop

Our "number guessing game" above is not very interesting. We're telling the user their guess is too low/too high, but we're not giving them a chance to guess again. We could include multiple blocks like the one above to give them multiple chances. However, in programming we like to stay DRY - Don't Repeat Yourself. Instead of having multiple if/else blocks, we will use a `while` loop to give the user 3 guesses.

```java
int secretNum = 4; //Sh! It's secret.
int userGuess;
int numGuesses = 0;

while (numGuesses < 3) {
  userGuess = getNewGuess();
  numGuesses++;
  //How many guesses does this ACTUALLY give?
}
```

This is called a loop - it will continue to execute WHILE the condition is true. Follow the code through and see what would happen.

#### For Loop

Another type of loop is a `for` loop. They work basically the same way as `while` loops, but allow you to define an initial action and an action that happens at the end of the loop. Let's take a look at an example:

```java
//Print out numbers 1-10
int x = 1;
while (x <= 10) {
  System.out.println(x);
  x++;
}
```

```java
//Print out numbers 1-20, using a for loop
for (int x = 1; x <= 20; x++) {
  System.out.println(x);
}
```

The basic syntax of a for loop is:

```
for (<initial action>;<condition>;<loop action>) {
  //Code
}
```

The `initial action` is the thing you do at the start (often initializing your "counter" variable). The `condition` is the decision of how to exit the loop, and the `loop action` is what we want to do at the end of the loop.
