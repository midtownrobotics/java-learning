## Lesson 7 - Inheritance, Abstract Classes, and Interfaces

In the week 2 assignment we created a Car Garage. Your `Car` class looked something like this:

```java
public class Car  {

    String make;
    String model;
    int speed;
    //Other variables

    public void printInfo () {
        //Method body
    }

    public void accelerate () {
        //Method body
    }

    //Other methods
}
```

### Inheritance

Inheritance is a concept in Object Oriented Programming that allows new classes to take on the properties and behaviors of existing classes. The new class is referred to as a "subclass". We are "extending" the existing Car class. Our "specialty cars" will now have a set of shared properties and behaviors. All we need to do is add in what's unique about each of those special cars. One of the extras for the assignment was to create three classes that "extend" the `Car` class: `OldCar`, `SportsCar`, and `Minivan`.

Here is an example of extending Car. Our new class SportsCar is everything a Car is and then some. It still has all the fields and methods that Car has, plus the ones we define for it.

 ```java
 public class SportsCar extends Car {
    //Fields specific to the SportsCar class
    boolean isConvertible; //(Not needed for the assignment, just an example)

    //We're overriding the accelerate function from Car
    public void accelerate () {
        speed += 10;
    }

    //We could add additional methods here (not needed for assignment)
    public void woo () {
        if (isConvertible) {
            System.out.println("Woooo!!");
        } else {
            System.out.println("Woo");
        }
    }
}
```

#### Polymorphism

* Morph means "form"/"shape"
* Poly means "multiple"

Polymorphism in Object Oriented Programming then is the ability for an object to take multiple forms. If we have an `Animal` class that's extended by `Dog`, the following code will work because Dog IS an Animal (and more):

```java
   Car strangePolymorphicCar = new SportsCar();
// ^--- defined as a Car             ^
// instantiated as a SportsCar ------|
```

How can we make use of this in our code? A very simple example would be keeping track of all of our different types of cars. Instead of having three lists like so:

```java
List<SportsCar> sportsCars;
List<OldCar> oldCars;
List<Minivan> minivans;
```

We can have one list for our cars:

```java
List<Car> cars;
cars.add(new SportsCar());
cars.add(new Minivan()); //These work just fine
```

### Interfaces

We know that a class is a data structure that holds data (i.e. variables) and behavior (i.e. methods)

We've now also seen that, generally speaking, we want to lean towards making a class' variables `private` so that the class alone can be responsible for keeping track of its own data and it exposes its functionality through its methods.

In other words, the class' methods are how the class interacts with the world outside of its own boundaries. They (the methods) constitute the "contract" between it and the rest of the world. They are the class' "interface".

Consider our Car example: what the Car's methods say is that if you want to start a car so that it can be driven, you should call  the `start()` method with no parameter, and that will return nothing, but switch the state of the car in such a way that it will be ready to accelerate.
Similarly, if you want to increase the car's speed (i.e. accelerate), you need to call the `accelerate()` method.

#### Defining an Interface

Java allows us to define another type of contract called an **interface**. In this contract, we provide a list of methods. Any class that **implements** this interface will have to implement these methods. The following is an interface to represent anything that can be "driven". You will often see interfaces with the -able suffix. For example, Comparable. You can read it this way: anything that implements Comparable is able to be compared. Anything that implements Driveable can be driven.

```java
public interface Driveable {

    public int accelerate();

    public int brake();

    public void start();

    public void stop();

    public void turnRight();

    public void turnLeft();

    public void reverse();
}
```

Notice how each method is defined with just its signature, and without an actual implementation.

That's what an Interface is in Java - it defines the interface for a class (i.e. how its functionality can be accessed), but does not define its implementation.

You can guess what comes next: we need a way to define the actual implementation of this functionality:

```java
public class GasPoweredCar implements Car {
}
```

When you copy the code for the `GasPoweredCar`, it won't compile. That's because the "implementation" of an "interface" *must* implement all the methods dictated by the interface, or it must be declared to be "abstract" - more on abstract classes below.

For now, let's go ahead and add implementation methods for our `GasPoweredCar`:

```java
public class GasPoweredCar implements Driveable {
    private int speed = 0;
    private boolean isStarted = false;

    public int accelerate() {
        speed += 5;
        return speed;
    }

    public int brake() {
        speed -= 1;
        return speed;
    }

    public void start() {
        isStarted = true;
    }

    public void stop() {
        isStarted = false;
    }

    public void turnLeft() {
        // implement turn left here ...
    }

    public void turnRight() {
        // implement turn right here ...

    }

    public void reverse() {
        // implement reverse here ...
    }
}
```

This looks a little bit like a subclass, and sure enough we can take advantage of polymorphism here as well:

```java
    Driveable myCar = new GasPoweredCar();
    myCar.start();
    myCar.accelerate();
```

So what's the difference here? A couple of things:

* An interface cannot be instantiated, so the following code won't compile:

```java
    Driveable myVehicle = new Driveable();
```

Even though a class can only extend a single class, a class can actually implement multiple interfaces

Let's consider a simple AudioPlayer interface:

```java
package com.tiy.practice;

public interface AudioPlayer {
    public void playAudio();
}
```

Our Car class can now implement that interface as well:

```java
package com.tiy.practice;

public class GasPoweredCar implements Driveable, AudioPlayer {
    private int speed = 0;
    private boolean isStarted = false;

    public int accelerate() {
        speed += 5;
        return speed;
    }

    public int brake() {
        speed -= 1;
        return speed;
    }

    public void start() {
        isStarted = true;
    }

    public void stop() {
        isStarted = false;
    }

    public void turnLeft() {
        // implement turn left here ...
    }

    public void turnRight() {
        // implement turn right here ...

    }

    public void reverse() {
        // implement reverse here ...
    }

    public void playAudio() {
        // implement playing audio here ...
    }
}
```

So now if I had an object of type `GasPoweredCar`, I could play audio:

```java
	GasPoweredCar myCar = new GasPoweredCar();
	myCar.playAudio();
```

Note that I cannot `playAudio()` on an object that's only been defined as a "Driveable" thing - this won't compile:

```java
	Driveable myCar = new GasPoweredCar();
	myCar.playAudio(); // <---- this line won't compile
```

That's because just because something is "driveable" doesn't mean that it also has "audio capabilities". Take the following class for example:

```java
package com.tiy.practice;

public class Bicycle implements Driveable {
    private int effortSpent = 0;
    private int speed;

    public int accelerate() {
        effortSpent += 5;
        speed += 1;
        return speed;
    }

    public int brake() {
        effortSpent += 1;
        speed -= 1;
        return speed;
    }

    public void start() {
        // a bike doesn't need to be stopped/started
    }

    public void stop() {
        // a bike doesn't need to be stopped/started
    }

    public void turnLeft() {
        // implement turn left here ...
    }

    public void turnRight() {
        // implement turn right here ...

    }

    public void reverse() {
        // a bike cannot reverse
    }
}
```

A bicycle is driveable (it provides all that functionality), but it does not provide audio capabilities.

#### Where Interfaces Shine

In the previous example, using a set of interfaces was useful, but didn't *really* allow us to do anything we couldn't do with regular inheritance. Consider this set of classes:

```java
// base class that both Bicycle and Car extend
public class Vehicle() { // base turnLeft() ...  functionality here }

// Override applicable functionality, such as start() and accelerate() here
public class Bicycle() extends Vehicle { ... }

// Add audio playing capabilities to this base class
public class Car extends Vehicle { ... }

// Here is our GasPoweredCar implementation
public class GasPoweredCar extends Car { ... }
```

That's another way to do what we did with our set of interfaces, and there are pros and cons to doing it either way. However, there are cases where interfaces give us a significant advantage.

Interfaces shine when we want to a set of capabilities that can be shared across classes that are otherwise unrelated. For example, consider all the interfaces that a SmartPhone class should implement, including the `AudioPlayer` interface:

```java
public class SmartPhone implements AudioPlayer, Phone, GPSDevice, Calendar, Camera {

    ...

}
```

### Abstract Classes

We know this about classic inheritance:

* A base class has some behavior and variables which can be inherited or overridden by a subclass
* A subclass can only extend one base class
* Both the base class and the subclass can be used and instantiated directly
* A variable of type the base class can be initialized as an instance of type the subclass (polymorphism)

We know this about interfaces:

* An interface defines a set of expected behavior, but does not define how that behavior is implemented (it does not have any actual functionality)
* An interface cannot be instantiated directly
* A class can implement as many interfaces as it wants
* A variable of type the interface must be instantiated as an instance of type the implementation

Well, abstract classes allow you to have a bit of both:

* An abstract class can have actual implementation code in it
* But an abstract class cannot be instantiated
* And an abstract class can only be extended through classic inheritance (meaning a subclass can only extend one abstract class)

Consider the following base class `Animal`.

```java
public class Animal {
    String name;

    public void makeNoise () {
        System.out.println("???");
    }
}
```

It didn't really make sense to say that an animal has a "default" noise. Instead we'll make the `Animal` class abstract, therefore making sure that no-one can ever create an instance of it, and that all classes that extend it will provide their own implementation of what makeNoise() is supposed to do:

```java
public abstract class Animal {
    public String name;
    public String type = "Generic Animal";

    public Animal() {
        System.out.println("Building an Animal object ...");
    }

    public abstract void makeNoise();
}
```

Now we can extend the animal class:

```java
public class Cat extends Animal {

    public void makeNoise () {
        System.out.println("Meow");
    }
}
```
