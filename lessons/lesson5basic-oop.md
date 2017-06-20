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
