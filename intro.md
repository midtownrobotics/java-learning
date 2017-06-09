## Introduction to Computer Programming with Java

### Class Expectations

1. Show up on time.
2. Catch up on any material you've missed
3. Be respectful of other students
4. Ask questions

### What is programming?

Computers can do amazing things, but they aren't magic. Computer programming is how we tell the computer what we want it to do.

### Programming Principles

We'll discuss more principles of good programming as we go. For now, here are three I'd like to emphasize:

1. It is **very** rare to write code in a vacuum, just for yourself. Coding is a collaborative/team process, and learning to work well with others is key to real success. This means that you always have to be thinking about the people reading or using your code. All languages provide ways to document your code. This is very important.

2. In problem solving in general there are often many ways to solve a given problem - there is no one "right" way. But in programming, there are a lot of conventions we try to follow. Following these conventions (descriptive variable names, case conventions), and doing things the right way will make your code more readable and professional-looking.

3. There is a faster way - in general, if you're attempting to perform a tedious task (such as replacing all instances of one word/variable name with another), there's a faster/easier way to do that. We'll get into all the tools later, but IDEs (Integrated Development Environments, i.e. Eclipse) provide you with a lot of tools to speed up your workflow. If you're thinking to yourself, "There must be a faster way", there probably is.

### First Program - "Hello World"

Going forward, it's OK to copy-paste any code snippets (like the one below) in the lecture. Just for today, we're not going to do that. Open up Eclipse and create a new class called "Greeting". Add the following `main()` method and run the code.

```java
public class Greeting {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

Congratulations! You've written your first Java program. This might look incomprehensible to you now - that's OK. In a few weeks, you will understand all the elements of this code. Here are the basics:

1. `public class Greeting` - we'll get more into what classes are and how they're used later. For now, any time you want to write code, it has to be part of a "class".
2. `public static void main` - here we are defining a method called "main". Methods are groups of actions that we can take. 
