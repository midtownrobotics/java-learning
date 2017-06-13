## Lesson 2 - Basic Java: Syntax, Variables, Operators, Functions, and Expressions

### Basic Java Syntax

In general, syntax means "the arrangement of words and phrases to create well-formed sentences in a language". In programming, it's basically the same. "Syntax" is basically the rules and structure of the language. As you work more with Java, you will become increasingly familiar with its syntax, to the point where you won't even have to think about it. For now, here are some basic points:

#### {} and Code blocks

Java uses C-style syntax, which originated with the C programming language. In particular, this means that we use braces `{}` to define **code blocks**. A code block is a group of statements. Code blocks can contain other code block, like so:

```java
if (x == 5) {
    System.out.println("X is five");

    if (y == 2) {
        System.out.println("And y is two");
    }
}
```

#### Dynamic Whitespace

Java supports a programming concept known as Dynamic Whitespace. This sounds very fancy, but it boils down to one simple thing: Java doesn't care how much "white space" you insert into your code (where whitespace is allowed).

```java
int x = 5;
int     y=        2;
int z
=3;
```

#### Semi-Colons

In Java, a semi-colon `;` is generally needed at the end of every statement. Essentially, if a line of code doesn't start a new code block, it needs a semi-colon.

#### Comments

All programming languages allow for "comments" in your code that are ignored by the language. In Java there are two ways to make a comment.

```java
//This is a comment
/* This is a block comment */
/* This is a bigger block comment
that has multiple lines */
```

The `//` will cause Java to ignore the rest of the line. The `/*` will ignore everything until it finds a closing `*/`.

Comments are **extremely important** (italics, large font, underlined, red letters). As we discussed, you are not writing code just for yourself, and even if you were, when you look back at your code in 6 months and have no idea what it does, you'll be wishing you had inserted some comments. In general, you should use comments whenever:

1. If you have any non-trivial method, you should include a line documenting what the method does.
2. Any line of code where you're doing something complex, weird, or tricky
3. Each class file should have documentation that briefly describes its purpose and context within the project
4. Any time you feel the need to write a note to remind yourself something `//This variable could be null!`

### Variables

A variable is a place for us to store data. This data could be anything from a number representing the current motor speed (255) to some text describing the current firmware version ("v0.12.29"). Java is a **strongly-typed language**. This means that each of our variables has to have a specific type, and that type cannot change. What are variable types?

* `int` - This represents an integer, or whole number value. Valid: 2, 1000285, -16. Not valid: 0.6, 42949672960 (too big).
* `double` - This represents a decimal number, like 0.6. Decimal numbers are known as "floating point" numbers; `double` stands for a double precision floating point number. Valid: 0.00001, 1284125927.27, -18257126.2.
* `boolean` - Boolean values can only be `TRUE` or `FALSE`.
* `char` - represents a single character, like `A`.
* `String` - represents a string of characters, like `"My name is Paul Dennis"`.
* `short`, `long`, `byte`, `float` - these variable types are less common. Don't worry about them for now.

Variables must be **declared** before they can be used. Let's say we want to declare a variable to keep track of a number.

```java
int myNumber;
```

That's it! Our variable has been declared. This means that later in our program we can refer to `myNumber` and Java will know what we're talking about. All we need to do to declare a variable is determine its type and a name. But it hasn't been **initialized**. To initialize a variable, we have to give it a starting value.

```java
myNumber = 5;
```

It's possible (and often a good idea) to declare and initialize variables in one line, as you will see below. ALl variables have default values (for example, 0 for ints), but it is not good practice to rely on that.

Here are some examples of variable declaration and initialization.
```java
int myNumber = 67;
double bankBalance = 4560.50;
char myFavoritLetter = 'z';
String myName = "Paul Dennis";
boolean javaIsFun = true;
```
