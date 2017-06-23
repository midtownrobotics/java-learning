## Lesson 6 - Arrays

In our Car Garage assignment, we said that the user could have a fixed number of cars, represented something like this:

```java
Car firstCar;
Car secondCar;
Car thirdCar;
```

What if we wanted the user to be able to have any number of cars they want? An arbitrarily large number. They could have twenty cars. They could have twenty thousand cars (though it might take a while to type all that information in). We want our program to be able to adjust to that. An **array** allows us to do that.

You can think of an **array** as a group of things (elements) that share a type. The things in the array are tracked by their **index**. Let's look at some examples.

Arrays use `[]`, brackets both to access elements and to declare the type. Java doesn't use [] anywhere else, so when you see brackets you should instantly think "array". Copy this code and run it.

```java
int[] primeNumbers = {2, 3, 5, 7, 11}; //Declaring and initializing the array
System.out.println("The second prime number is " + primeNumbers[1]);
System.out.println("The first prime plus the 2nd is: " + (primeNumbers[0] + primeNumbers[1]));
```

Array indices (plural of index) start at 0 (zero), so the first element of the array is at index 0, the second element is at index 1, the third at index 2, and so on, up to the last index, equal to the size of the array minus one (in an array with 5 elements for example, the Fifth Element would have index 4).

Arrays in Java have a fixed size when created (discussed further below), and if you try to index into an array with a number equal to or greater than the size (or a negative number) you will get an error (specifically an `IndexOutOfBoundsException`). This is generally a very avoidable error since Java provides us easy ways to know the size of an array.

We use the [] brackets to **index into** the array, to tell Java what element we want. Note that this changes the type of what we're working with from an array to what the array contains.
```java
primeNumbers; // <- This is an array. Its type is int[]
primeNumbers[2]; // <- This is NOT an array. This is the third element in primeNumbers
//Its type is int
```

### Array Initialization

We saw one method above for declaring a new array. We used `{}` to define a block of comma separated values (`{2, 3, 5, 7, 11}`). Let's look at an alternate method and compare them.

```java
int[] primeNumbers = new int[5];
primeNumbers[0] = 2;
primeNumbers[1] = 3;
primeNumbers[2] = 5;
primeNumbers[3] = 7;
primeNumbers[4] = 11;
```

The second method, shown above, uses the `new` keyword to declare the array with default values. This time, because we're not giving it the elements, we need to tell it the size of the array (as we said before, arrays in Java have a fixed size). Then, on the subsequent lines, we manually set the values at each index.

Which method is better? The only real difference here is syntax. If you are initializing an array of simple types whose values you already know, the first method ({csv}) is less wordy. If you need to do some calculations and "fill in the array as you go" then it's easier to use the 2nd method.

#### Arrays.fill()

The Arrays class (`java.util.Arrays`) has static methods which can make our lives easier. One simple example is the `Arrays.fill()` method. When you create an array with the `new` keyword, Java automatically fills in default values (0 for integers, false for booleans, null for objects, etc.). But what if you want an int[] of size 100, with a starting value of 5?
```java
int[] myFives = new int[100];
myFives[0] = 5;
myFives[1] = 5;
...
myFives[99] = 5;
```
That's 100 lines of code! Surely there must be a better solution. Yes - `Arrays.fill()`:

```java
int[] myFives = new int[100];
Arrays.fill(myFives, 5);
```

Presto manifesto, our array is full of fives. The Arrays class contains other useful methods - check it out!

### Final Thoughts

Remember: [] always means array. Sometimes it might not seem like there's an array there, for example if I have a `String myString`, and I call `myString.split("=")[1]`, the `[1]` at the end is indexing into the array which is returned by the `split()` function.
