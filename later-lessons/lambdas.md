## Lambda Expressions

Let's say that we have a `List<Employee>` that we want to sort.
```java
List<Employee> employeeList = new ArrayList<>();
//new Employee(int salary, String name, int age)
employeeList.add(new Employee(40000, "Sam", 24));
employeeList.add(new Employee(50000, "Bob", 5));
//Etc...
```

There are many different ways to accomplish this. If there is only one criteria under which we ever want to sort Employees, the simplest approach would be to have Employee implement the `Comparable` interface and use the `Collections.sort()` method.

```java
class Employee implements Comparable<Employee> {
public int compareTo (Employee otherEmployee) {
        //Our comparison
}
}
```

This is great if we only ever want to sort employees one way - alphabetically by first name, for example. But what if we want to be able to sort employees by multiple different criteria or even combinations of criteria? Today I want to sort employees by the ratio of their salary to their age; tomorrow maybe in reverse alphabetical order. The next day I'll want to sort them by the number of letters in their full name.

It's not very practical to write classes for all these different "sorts" that we might want, but let's look at an example:

```java
import java.util.*;

public class NoAnonClasses {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(40000, "Sam", 24));
        employeeList.add(new Employee(50000, "Bob", 5));
        employeeList.add(new Employee(80000, "Carol", 35));
        employeeList.add(new Employee(20000, "Alex", 20));

        //Sort by salary
        employeeList.sort(new SortBySalary());
        System.out.println(employeeList);

        //Sort by name
        employeeList.sort(new SortByName());
        System.out.println(employeeList);
    }
}

class SortBySalary implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        if (e1.getSalary() > e2.getSalary()) {
            return 1;
        } else if (e2.getSalary() > e1.getSalary()) {
            return -1;
        }
        return 0;
    }
}

class SortByName implements Comparator<Employee> {
    public int compare (Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class Employee {
    private int salary;
    private String name;
    private int age;

    public Employee(int salary, String name, int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString () {
        return name + ", Salary: " + salary;
    }
    //We override toString() so that we can easily view info about Employees
}
```

Now imagine that we might want 5 or even 10 different ways of sorting. This could get very cluttered, very quickly. Introducing...

### Anonymous Classes

Anonymous classes allow us to declare and instantiate a class at the same time. Anonymous is quite literal here - it has no name. This means we can only use it once; after all, you can't reference something with no name. Let's look at a new version of the above code that uses anonymous classes.

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonClassExample {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(40000, "Sam", 24));
        employeeList.add(new Employee(50000, "Bob", 5));
        employeeList.add(new Employee(80000, "Carol", 35));
        employeeList.add(new Employee(20000, "Alex", 20));

        //Sort by salary
        employeeList.sort(new Comparator<Employee>() {
            //Inside this block we will need to implement all the methods of the interface
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getSalary() > e2.getSalary()) {
                    return 1;
                } else if (e2.getSalary() > e1.getSalary()) {
                    return -1;
                }
                return 0;
            }
        }); //The close paren here matches up to the .sort(
        System.out.println(employeeList);
        //ArrayList has a reasonable toString() method

        //Sort by name
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
        System.out.println(employeeList);
    }
}

class Employee {
    private int salary;
    private String name;
    private int age;

    public Employee(int salary, String name, int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString () {
        return name + ", Salary: " + salary;
    }
}
```

Overall this is a more succinct way of accomplishing our goal. It avoids cluttering our project with a bunch of classes that we will only use once (note: when we say "only use once" that refers to the number of occurrences in the code. These sort functions could easily be in methods that get called many times).

But wait, there's more! Introducing...

### Lambda Expressions

Just like anonymous classes, Java (as of Java 1.8) provides support for anonymous functions. And just like anonymous classes, anonymous functions are more concise. We can use anonymous functions in any case where we have a Functional Interface - an Interface that only has one method. The Comparator interface we've been using is a perfect example. It only has `int compare(T, T)`. Anonymous functions in Java are known as "Lambda Expressions".

Here is the same example, but this time with Lambdas.

```java
import java.util.ArrayList;
import java.util.List;

public class LambdaSortExample {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(40000, "Sam", 24));
        employeeList.add(new Employee(50000, "Bob", 5));
        employeeList.add(new Employee(80000, "Carol", 35));
        employeeList.add(new Employee(20000, "Alex", 20));

        //Sort by name
        employeeList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println(employeeList);

        //Sort by salary
        employeeList.sort((e1, e2) -> {
            if (e1.getSalary() > e2.getSalary()) {
                return 1;
            } else if (e2.getSalary() > e1.getSalary()) {
                return -1;
            }
            return 0;
        });
        System.out.println(employeeList);
    }
}
class Employee {
    private int salary;
    private String name;
    private int age;

    public Employee(int salary, String name, int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString () {
        return name + ", Salary: " + salary;
    }
}
```

Let's look at the syntax of the lambda more closely. To sort employees by name, we used the following expression: `employeeList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));`. First, why are we even allowed to do this? If we look at the documentation for the `myArrayList.sort()` function we see that it expects a `Comparator` object. What we see being passed doesn't _look_ like an instance of a `Comparator`, but it is.

If we look at the `Comparator` interface we can see that it defines only one method we must implement, `compare()`. Since this is the only method required, the `Comparator` interface is said to be functional.

The Java compiler will see the syntax above and reason that, because the `Comparator` interface only specifies one method and because lambdas are anonymous methods, it needs to effectively generate an anonymous class and implement the one method as specified by the lambda.

More simply put, the `sort()` method will run the code to the right of the `->` symbol, providing arguments with the names specified to the left. You don't need to specify argument data types or method return types; that is all specified by the functional interface. Now that we are comfortable with the fact that the lambda expression **is-a** Comparator, let's look at the syntax used.

### Lamdba Syntax

`(e1, e2) -> e1.getName().compareTo(e2.getName())`

Remember that lambda expressions are functions. Functions have inputs (arguments, parameters) and outputs (what they return or do). So the simplest way to look at the expression above is as a function. The arguments are surrounded by parentheses and in a comma separated list (just like regular functions). The outputs are to the right of the arrow operator (`->`). So we could read this as "Given (e1, e2), I will return/perform e1.getName().compareTo(e2.getName())".

```java
public int anonymous (Employee e1, Employee e2) {
  return e1.getName().compareTo(e2.getName());
}
```

Lambda functions do not require us to use the `return` keyword, though it can be used for more complex expressions as we see in the second example:

```java
//Sort by salary
employeeList.sort((e1, e2) -> {
    if (e1.getSalary() > e2.getSalary()) {
        return 1;
    } else if (e2.getSalary() > e1.getSalary()) {
        return -1;
    }
    return 0;
});
```

Lambda expressions can be as complex as you need them to be. You can call other functions, print to the console, or anything else you might need to do.
