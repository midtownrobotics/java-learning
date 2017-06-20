## Lesson 5 - Intro to Object Oriented Programming

Java is an "Object Oriented" Programming language (OOP). This means that most of the core concepts are expressed through using **objects**. A **class** is a blueprint that describes a type of object.

### Blueprint/Class

A class is a collection of **data** (AKA variables) and **behaviors** (AKA methods). For example, here is a class to represent a dog.

```java
public class Dog {

    //Member variables 1
    String name;
    int age;
    double weight;

    //Constructor 3
    public Dog (String n, int a, double w) {
        name = n;
        age = a;
        weight = w;
    }

    //Member methods 2
    public void bark () {
        System.out.println("WOOF!");
    }
}
```

1. Member variables: This class has three member variables: a `String name`, a `int age`, and a `double weight`. For example: "Charlie", 9, 38.2 . These fields represent all of the data we want to keep track of for this class. If we needed more information, we could add additional fields like `boolean isMale`, or `boolean isPurebred`. What other fields could you add?
2. Member methods: So far, we've only defined one behavior for our Dog class: `bark()`, which just prints to the console.
3. Constructor: constructors are a special type of member method that allow us to define how our class is **instantiated**. Instantiation means creating an **instance** (or "example") of the class. Remember that the class is just the blueprint. The constructor is what turns that blueprint into a House, or a Dog, or an InvalidStateException. The constructor turns the blueprint into an object.

### Instance/Object

Let's create two instances of our Dog class.

```java
public static void main (String[] args) {
    Dog myDog = new Dog("Charlie", 9, 38.2);
    Dog lassie = new Dog("Lassie", 5, 45.0);
}
```

This should look a little familiar and a little different. At the most basic level, we are declaring a new variable (`Dog myDog = <value>` just like `int x = <value>`). The value we are assigning here is more complex. The variables we've worked with in the past have been **simple types** (with the exception of String, which can behave like one).

To create a new *instance* of our Dog class, we use the `new` keyword. This keyword tells Java to allocate memory for this complex object and calls the *constructor* that we defined above (`public Dog (String n, int a, double w)`).

Now that we have these objects what can we do with them?

### Dot Notation

We can use "dot notation" to access their data and behaviors.

```java
//Charlie has gained weight:
myDog.weight += 5.0;
//Charlie has a last name
myDog.name = "Charlie Dennis";
myDog.bark(); //Prints "WOOF!"
```

The dot operator, `.` allows us to access any public methods and data of an object. It might help to think of the object as a folder that contains these values. The dot operator allows us to go into that "folder" similarly to how `/` allows us to go into real folders.

#### IDE Usage

All Java IDEs including Eclipse provide a lot of useful information. For example, anytime you have and object like `myDog` above, you can type `myDog.` and wait. The IDE will show you a list of all the public variables and methods that you have access to at that point. You can also use this feature to speed up your coding by allowing the IDE to do the typing for you. Some methods have really long names (like `getUndoPresentationName()`), and you might not want to have to type that out a lot.

### `this` Keyword

Another keyword in Java is `this`, which refers to the current object. It is often used (sometimes optionally) to **disambiguate**, which means effectively to make it clear what we're talking about. For example, if someone says "George Bush", they could be talking about George H.W. Bush, President 41, or George W. Bush, President 43.

What does that look like in Java? Well, a common pattern in Java is to use the same variable names in the constructor as in the class. So instead of the constructor we used before:

```java
public Dog (String n, int a, double w) {
    name = n;
    age = a;
    weight = w;
}
```

The more common pattern is:

```java
public Dog (String name, int age, double weight) {
    name = name;
    age = age;
    weight = weight;
}
```

(Why is this better? Well, for one thing we know what "name", "age", and "weight" represent, but "n", "a", and "w" aren't as clear)

But weight! I mean, wait! There's a problem. There are two variables floating around called "name". One of which is the parameter being passed to the constructor, and the other is the member variable "name". If we left our constructor as is, what would happen?** (See bottom for answer).

We can use the `this` keyword to **disambiguate**, and make it clear that we want Java to set the class variable to the value that's being passed in.

```java
public Dog (String name, int age, double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
}
```

** Answer: the code would compile but not have the intended effect. Java always looks for the "closest" variable it can find, so it will take the variable that's being passed in, "name", and assign it the value of the variable passed it.

### `static` Keyword

Now that we have 
