## Lesson 3 - Operators, Functions, and Expressions

### Operators

Java has defined a set of **operators**. You've already encountered several operators, including the assignment operator, `=`. Operators are things that do stuff. Operators have "operands" - the ingredients they are working with. These can be referred to as the "Left Hand Operand" (LHO) and "Right Hand Operand". Basically, the thing to the left of the operator and the thing to the right.

The assignment operator attempts to assign the value of the RHO to the LHO.

```java
int x = 0;
x = 5; // Assigns the value 5 to the variable x
```

#### Arithmetic Operators

The arithmetic operators work mostly as you'd expect. `+` adds the two values, `-` finds the difference, `*` is used for multiplication and `/` for divide. Note that "integer math" works a little bit differently than you might expect. While `8.0/5.0` will be the 1.6 you would expect, but `8/5` is 1 (the 0.6 is chopped off). Lastly, there is an additional arithmetic operator, `%`, the modulus operator, which tells you the **remainder** after division. So `8%5` is 3 (the remainder when dividing 8 by 5 is 3).

```java
int x = 2 + 3;
double y = 2718.2/10.6;
int remainder = 12958 % 3;
```

Arithmetic operators return (result in) a number.

#### Assignment/Increment Operators

We already discussed `=` above. There are some additional assignment operators that effectively provide shortcuts. For example, the `+=` operator.

```java
int x = 0;
x = x + 5;
x += 5; //These two are equivalent
```

The `*=`, `-=`, `/=` work the same way. There is an additional shortcut; because incrementing (increasing by one) and decrementing (decreasing by one) are such common operations, we have the `++` and `--` operators.

```java
int x = 0;
x = x + 1;
x += 1;
x++; //All three are (for most purposes) equivalent
```

Wait, most purposes? Operators follow an order of operations, like PEMDAS. When the computer is evaluating a statement like `x = 5 * 4 + 2` it has to know what to do first. Does it assign 5 to x and then multiply it by 4? (No). For arithmetic, Java will follow PEMDAS rules. If you are concerned about order of operations you can use parentheses to make it explicit: `x = 5 * (4 + 2)`.

This page lists the order of operations, as well as some other operators we won't cover: https://www.javatpoint.com/operators-in-java.

#### Comparison Operators

We often want to check to see if two numbers are equal. In Java, the `=` is already used for the assignment operator, so we use `==` to check equality.

```java
if (x == 5) {
  System.out.println("X is five!");
}
```

We also want to compare two numbers to see which is bigger. In this case, we can use the `<`, `>`, `>=`, and `<=` operators (less than, greater than, greater than or equal to, less than or equal to). They work as you would expect.

```java
if (x > 0) {
  System.out.println("X is positive");
}
```

Comparison operators return (result in) a `boolean` value (TRUE or FALSE).

#### Logical Operators

We will discuss the AND (`&&`) and OR (`||`) in the next lesson.

### Functions

When problem-solving it's important to break the problem down into smaller pieces. If I asked you to bake a cake, you might have no idea where to start. Let's break down that problem.

In order to bake a cake, we know that we will need some ingredients. You might not know what the ingredients are, but you can probably make some guesses (eggs, flour, butter, sugar, etc.). If need be, we could look up a recipe that would tell us the ingredients.

We also know something about our desired end result (cake). We've all seen cakes, and know more or less what they look like. If we had a particular cake in mind, that provides further definition for the problem.

A function (or method - in Java these terms are interchangeable) is a defined group of statements. Functions accept **arguments** also known as **parameters**, and have return values. Going back to our cake metaphor, the arguments would be the ingredients, and the return value would be the end result - cake! Here is some "pseudo code" for making a cake.

```java
public Cake bakeCake (flour, sugar, eggs, butter) {
  wet_mix = eggs + butter;
  dry_mix = flour + sugar;
  cake = wet_mix + dry_mix;
  //bake the cake!
  return cake;
}
```

"Pseudo code" (pronounced "sudo") is a way of brainstorming and laying out ideas. Basically, pseudo code lets us forget worrying about the syntax of the language. In this case, we have defined (in pseudo code only! this is not working Java code) a function that accepts arguments (flour, sugar, eggs, butter) and returns a cake. Let's look at a real example:

```java
public static int addTwoNumbers (int x, int y) {
  return x + y;
}

//Somewhere else, we call the function:

int n = addTwoNumbers(5, 3);
```

Here is the general pattern for how to declare a function:

```
<modifiers> <return type> <function name> (<function arguments>) {
  <function body>
}
```

(Don't worry about modifiers (public, static) for now)

The function above accepts two arguments (`int x, int y`). It has a *return type* of `int`, which means we are required to return an int (Java won't accept the function otherwise).

This function is a little bit silly, since instead of calling it, we could just use the `+` operator to add the numbers ourselves. But functions can be much more complex and interesting than just adding two numbers.

It is also possible for functions to have no return type and/or not accept arguments. Let's look at an example of that:

```java
public static void printInfo () {
  System.out.println("I am printing some info");
  System.out.println("Boy this is fun! SO much info");
}
```

Here, the return type is `void`, which means we don't return anything. Also, as you can see this function calls another function (`println()`). Functions can even call themselves - this is called recursion, and we'll discuss it later.

### Expressions

An expression is a combination of variables/constants, operators, and function calls that produce a value. Let's look at an example: `5 - 3` is an expression. It combines two constant values (5 and 3) and the `-` operator. When the expression is **evaluated**, the value it returns is 2. Expressions can be much more complex than that, and can contain other expressions.

```java
int y = 4;
int x = 2 + squareNumber(y - 1); //<- Let's evaluate this expression
public static int squareNumber (int num) {
  return num * num;
}
```

We want to evaluate the selected expression to find out what the value of x will be. Parentheses first!

* `y - 1` We know y is equal to 4, so we can substitute in that value, which gives us
* `4 - 1` 4 minus 1 is 3, so this gives us 3. Now we have
* `2 + squareNumber(3)` The `squareNumber()` function will return 9 (3 * 3), so we have
* `2 + 9` which is 11. This value is then assigned to the variable known only as `x`.

This might seem like a very complex way to look at a simple math problem, but being able to read and evaluate expressions is *key* to understanding what's going on with code.
