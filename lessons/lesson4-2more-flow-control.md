## More Flow Control

There are a few other elements of boolean logic and flow control that we didn't get to in class. This lesson will go over those.

### ! and !=

Sometimes when working with boolean variables we want to use the "opposite" value. Java uses `!` (exclamation mark) as the `NOT` operator.

```java
boolean hasPants;
boolean hasShirt;

//Later:
if (!hasPants) { //This can be read as if NOT hasPants, or if hasPants is false
  System.out.println("Dude you need to put on some pants!");
}

if (!(hasPants || hasShirt)) {
  System.out.println("Wearing neither pants nor shirt. Tisk tisk");
}
```

You can also use the `!=` operator to check if something is NOT equal.

```java
int x;
if (x != 5) {
  System.out.println("X isn't five. I'm not sure what it is.");
  System.out.println("But definitely not five.");
}
```

### Break and Continue

Java has two additional keywords that help us control the flow of our program: `break` and `continue`. These keywords stand alone (much like the cheese) as their own statement. Both statements can only be used inside loops or switch/case statements (covered later in the lesson).

* `break` - attempts to "break out" of the loop entirely, stopping the loop.
* `continue` - goes to the end of the loop but does not break it

Here we have a number guessing game. The main loop of the game won't finish until the user correctly guesses the number. Using a `while (true) ... break` loop gives you very fine control over the loop - just make sure that it will break eventually!

```java
int userGuess;
int secretNum;

while (true) {
  System.out.println("I'm in a loop");
  if (userGuess == secretNum) {
    break; //This loop will only exit when the user correctly guesses the number
  }
  System.out.println("You did not guess correctly this round");
  //Get next guess
}
```

Let's say we want to print out numbers, but skip numbers that are divisible by 3.

```java
for (int i = 0; i < 10; i++) {
  if (i % 3 == 0) {
    continue;
  }
  System.out.println(i); //If "continue" gets called this line won't execute
}
```

### Do-While

Do-while loops are not very commonly used, but it's still helpful to understand them. The difference between a `while` and a `do-while` loop is that a `while` loop checks the condition at the beginning and a `do-while` checks at the end. In practice, this means that the code in a `do-while` loop will always run at least once.

```java
int x;
do {
  System.out.prinln("We're in a do-while loop!"); //Always runs at least once
  x++;
} while (x < 3);
```

### Switch/Case Statement

A switch/case statement functions similarly to an if/else if/else structure. A switch statement starts with a variable, and defines the behavior based on that variable. Let's look at an example.

```java
String dayOfWeek;

switch (dayOfWeek) {
  case "Monday":
    System.out.println("I've got a serious case of the Mondays");
    break;
  case "Friday":
    System.out.println("Most everyone likes Fridays");
    break;
  case "Saturday":
    System.out.println("Weekend! Wooo!");
    break;
  default: {
    System.out.println("The day was not a Monday, Friday, or Saturday");
  }
}
```

This switch/case statement is based on the `dayOfWeek` variable. It will attempt to match this variable to one of the "cases" that we've defined. This is equivalent to:

```java
if (dayOfWeek.equals("Monday")) { //.equals is how we compare Strings
  System.out.println("I've got a serious case of the Mondays");
} else if (dayOfWeek.equals("Friday")) {
  System.out.println("Most everyone likes Fridays");
} else if (dayOfWeek.equals("Saturday")) {
  System.out.println("Weekend! Wooo!");
} else {
  System.out.println("The day was not a Monday, Friday, or Saturday");
}
```

One difference between switch/case and if/else if structures is that multiple case statements can be executed. Think of the colons `:` as a fence. Once a switch/case statement makes a "match", it will "jump the fence" and start executing statements until it hits a `break` statement. This could potentially run through multiple other cases.

In general, switch/case is a more organized way to structure something you previously would have use if/else if/else for - just don't forget the `break` statements (unless that's your intention).
