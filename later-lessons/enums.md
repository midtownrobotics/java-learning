## Enumerations

Let's say we are writing an Event class. Each Event occurs on a given day of the week, and we want to track that. What data type should we use? All of our existing data types have problems.

If we use a String, someone using our class can put whatever value they want in. We have to be concerned that they might use different capitalization or abbreviation ("Thurs" or "thursday" instead of the "Thursday" that we expect).

If we use an integer value, every time we want to actually "know" the day we'll need to use a cumbersome `switch/case` statement.

```java
int dayOfWeek;
switch (dayOfWeek) {
  case 0:
    return "Sunday";
  case 1:
    return "Monday";
  //Etc etc
}
```

And again, there is nothing to prevent someone from entering a value out of the expected range. There are only seven days of the week. Introducing...

### Enums!

Java provides a great way for us to keep track of a variable that should only have a limited set of possibilities - like days of the week. It's called an **enum** short for "enumeration". Enums are great to use anytime you can list ALL of the possibilities for a value that your program cares about. Let's define an enum for days of the week. It's very simple!

```java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

Reminder: by convention Java uses "UPPER_SNAKE_CASE" to represent constant values, and everything in an enum is constant (TUESDAY is always TUESDAY and always will be).

Now we can define our Event class:

```java
public class Event {
  Day dayOfWeek; //<- Our enum!
  String address;
  String eventManagerName;
  List<Person> eventAttendees;

}
```

Here is how we'd use that variable:

```java
dayOfWeek = Day.MONDAY; //Assignment
if (dayOfWeek == Day.TUESDAY) {
  System.out.println("It's Tuesday!");
}
```

If you want to be able to quickly refer to your enum you can use a static import:

```java
import static Day.*;
dayOfWeek = MONDAY; //Assignment
if (dayOfWeek == TUESDAY) {
  System.out.println("It's Tuesday!");
}
```

### Enum Class

Even though we are treating enums like simple types (no using "new" to assign a value) they are actually Objects. All enums extend the `Enum` class, which extends Object. So in addition to the standard `toString()` and `equals()` methods, we also have `compareTo()` (because Enum implements Comparable) and `ordinal()`, which tells us the number associated with the particular value. For the Day Enum that would look like this:

* SUNDAY - 0
* MONDAY - 1
* TUESDAY - 2
* Etc Etc

Because enums have these constant values, Java lets us use them in a switch/case statement.

### Properties, Constructors, and Methods (Oh my!)

Java Enums allow us to define properties, much like we can have variables in classes. Let's improve our Day enum to have a `String status`, which will have some comment about the day, and a `boolean isWeekday`.

```java
public enum Day {

    //These values are defined using the constructor (see below)
    SUNDAY (false, "Some people go to church"),
    MONDAY (true, "Most don't like this day"),
    TUESDAY (true, "Better than Monday"),
    WEDNESDAY (true, "Hump day"),
    THURSDAY (true, "Almost Friday!"),
    FRIDAY (true, "Yay!"),
    SATURDAY (false, "The best day, and some go to temple");

    private boolean isWeekday; //These fields should be private
    private String status; //Just like a regular class's fields

    //Here we are declaring a constructor
    Day (boolean isWeekday, String status) {
        this.isWeekday = isWeekday;
        this.status = status;
    }

    //Accessor methods for properties
    public boolean isWeekday() {
        return isWeekday;
    }

    public String getStatus() {
        return status;
    }

    public boolean daysAdjacent (Day otherDay) {
        int difference = Math.abs(this.ordinal() - otherDay.ordinal());
        if (difference <= 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day.toString() + " (" + day.isWeekday + ") - " + day.status);
        }
    }
}
```

Notes:
* Since we've defined a constructor we are now forced to define our enum constants with that constructor.
* We want to make the variables private and use accessor methods for the same reason we would do that with a class (protected access)
* We aren't limited to accessor methods. We've defined a `daysAdjacent()` method that will tell us if two days are adjacent (next to each other, like Tuesday and Wednesday).

### Closing

This example shows some very simple things that can be done with enums. But just like classes, you can make these as complicated as you need - the sky's the limit.

The Java tutorial contains another example of this with some interesting functions, and provides more formal definitions. I highly encourage you to read it [here](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
