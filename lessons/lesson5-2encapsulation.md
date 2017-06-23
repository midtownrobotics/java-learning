## More Object Oriented Basics - Encapsulation

As a continuation of our discussion on basic Object Oriented programming we discussed **access modifiers** (`private`, `public`, `protected`) and **encapsulation**. This supplemental lesson will review and expand on those concepts.

### Business Rules

We discussed an example of **business rules** which are rules that define how we want our class to operate. For example, we had a `Bedroom` class that had an `int numPeople` and a `boolean occupied`. These variables should "agree" - if the number of people in the room is zero, `occupied` should be false; if the number of people in the room is positive, `occupied` should be true.

This is an example of a business rule. Business rules help you define how your variables should behave, which will help you write functions. Another possible business rule for the class above could be that the number of people in the room *cannot* be negative. In order to accommodate all those rules, we could write a function like this:

```java
//This function will return true if it was able to successfully
//Set the number of people in the room; otherwise false
//(numPeople Cannot be negative)
public boolean setNumPeople (int newNumPeople) {
    if (newNumPeople > 0) {
        occupied = true;
        this.numPeople = newNumPeople; //this keyword is not needed
        //But can be used for clarity
        return true;
    } else if (newNumPeople == 0) {
        occupied = false;
        numPeople = newNumPeople;
        return true;
    }
    return false;
}
```

### Access Modifiers

In order to enforce our business rules, we need to be able to restrict access to our variables (or methods). The keywords `private`, `public`, and `protected` change who can "see" our variables.

* `private` - Can only be accessed from within the class
* `public` - Can be accessed by anyone. Don't use public variables unless you have a specific reason to do so (laziness doesn't count)
* `protected` - Can only be accessed from within the class or classes that extend/inherit from this class (we haven't discussed inheritance yet - soon!)
* `(default)` - There's no "default" keyword, but if you don't use one of the above keywords to specify an access level, variables can be accessed by any files in the same package (again, we haven't discussed packages yet, but essentially, files that exist in the same folder). Avoid having class variables with default access.

These modifiers can also be used on methods. Up until now we've made all of our methods public, but it's possible to have `private` or `protected` methods as well. A private method can only be called from within the class, so these are often referred to as "helper methods".

For example, let's say I am writing a PacMan game. I will have a Graphics class with a public `paint()` method that will be responsible for rendering all of my content. In order to organize my code, I'll add in private helper methods to the Graphics class that will each take a piece of the larger task.

```java
public void paint () {
    paintDots();
    paintGhosts();
    paintPacMan();
}

private void paintDots () {
    //Method body
}
private void paintGhosts () {
    //Method body
}
private void paintPacMan () {
    //Method body
}
```

I don't need to "expose" `paintDots()`, `paintGhosts()`, or `paintPacMan()` because those are internal helper functions. In fact, it might even cause rendering issues if someone were to access those functions without calling them through `paint()`.

### Encapsulation

All of this together defines **encapsulation**: the ability to hide or expose different parts of your class as you see fit. In general, best programming practice is to keep all variables private (or protected), and only allow access to those variables through methods that you define. This allows you to be sure any business rules are followed. 
