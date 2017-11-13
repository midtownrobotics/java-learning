## Lesson 1 - Introduction to Computer Programming with Java

### Class Expectations

1. Show up consistently and on time.
2. Catch up on any material you've missed
3. Be respectful of other students
4. Ask questions

### Class Goals

At the start of the build season we want you to:

1. Have basic competency in Java
2. Feel comfortable with basic uses of Git to store code
======(If we have time - see schedule)=====
3. Understand how the Java FRC code works, and be able to write code for the robot
4. Feel comfortable with the process of loading code onto the robot

Some additional goals:

1. Streamline autonomous testing
2. Develop competency with sensors
3. Improve the coding process; use good code conventions

### Class Format & Schedule

The format of the class may change substantially. We will be meeting Monday and Wednesdays from the start to the end of the build session (~4:45-6:30). We'll take a short break, but expect this class to occupy the whole session.

Week 1: 11/13 and 11/15
Monday - Lessons 1-4. Assignment 1, due 11/15. Read Lesson 4.2 at home.
Wednesday - Review Lessons 2-4, Lesson 5. Assignment 2, due 11/29

11/20 and 11/22 Closed for Thanksgiving Break

Week 2: 11/27 and 11/29
Monday - Review Assignment 2 & Lesson 5, Lesson 6. Assignment 2.1, due 11/29
Wednesday - Lesson 7. Assignment 3, due 12/4.

Week 3: 12/4 and 12/6
Monday - Lesson 8 (Collections). No new HW (catch up on any previous)
Wednesday - Lesson 9 (Unit Testing). Assignment 4, due 12/13.

Week 4: 12/11 and 12/13
Monday - Maze Hackathon?
Wednesday - ""

Week 5: 12/18 and 12/20
Monday - Robot Sensors, PID Loops
Wedsnesday - Code Deployment

(After this, Winter Break, then build season starts)

### What is programming?

Computers can do amazing things, but they aren't magic. Computer programming is how we tell the computer what we want it to do. Computers are great at certain types of tasks, and pretty terrible at others. Let's imagine a task of re-shelving books at a library. A human given this task would be able to deal with unexpected circumstances, such as an object blocking their path. A computer doesn't know how to deal with anything it hasn't been programmed to deal with.

Computers:
1. Don't make mistakes (well, only the ones they're programmed to make)
2. Don't get bored
3. Handle unexpected circumstances poorly
4. Can handle millions of calculations per second

### Programming Principles

We'll discuss more principles of good programming as we go. For now, here are three I'd like to emphasize:

1. It is **very** rare to write code in a vacuum, just for yourself. Coding is a collaborative/team process, and learning to work well with others is key to real success. This means that you always have to be thinking about the people reading or using your code. All languages provide ways to document your code. This is very important.

2. In problem solving in general there are often many ways to solve a given problem - there is no one "right" way. But in programming, there are a lot of conventions we try to follow. Following these conventions (descriptive variable names, case conventions), and doing things the right way will make your code more readable and professional-looking.

3. There is a faster way - in general, if you're attempting to perform a tedious task (such as replacing all instances of one word/variable name with another), there's a faster/easier way to do that. We'll get into all the tools later, but IDEs (Integrated Development Environments, i.e. Eclipse) provide you with a lot of tools to speed up your workflow. If you're thinking to yourself, "There must be a faster way", there probably is.

### First Program - "Hello World"

Going forward, it's OK to copy-paste any code snippets (like the one below) in the lecture. Just for today, we're not going to do that. Open up IntelliJ and create a new class called "Greeting". Add the following `main()` method and run the code.

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
3. `System.out.println("Hello World!")` - here we are calling a function that has been defined by Java: `System.out.println`. `"Hello World!"` is the **argument** we are passing to the function. We'll discuss functions a lot more in the future.
4. `{}` - the braces are used to define code blocks in Java.

### Java Keywords/Highlighting

You have probably noticed that certain words (like `public`, `static`) appear differently in your IDE (bolded, in a different color). These are **reserved keywords** in Java. Every language has certain words that it reserves to only have very specific meanings. For example, the `class` keyword is only used to define a new class.
