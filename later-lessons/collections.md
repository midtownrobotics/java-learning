## Java Collections

Java allows us to store multiple objects of the same type in an array. We can do this with primitive types:

`int[] numbers = new int[5];`

or with Objects:

`User[] users = new User[2];`

By now you should be familiar with arrays, and probably have already noticed their biggest flaw: no flexibility. Once we declare the array, we can't change the size without making an entirely new array. Then we'd have to copy over all the data from the array. What a hassle.

Luckily Java provides us with a whole group of classes to store data in more useful and flexible ways. Introducing...

### Java Collections Framework

The Java Collections Framework (JCF) is a library that provides us with a lot of different ways to store data. We'll look at a few different types. Each of these types follows a general pattern: there is the base interface, and several implementations of that interface (one of which is usually the "default").

#### List

A List in Java is just what you'd expect. It's a flexible data structure that allows us to store objects of the same type together. The "default" implementation of `List` is an `ArrayList`.

```java
List<String> messages = new ArrayList<>();
messages.add("Hello!");
messages.add("Order more pizza");
messages.add("Need napkins now!");

System.out.println(messages.get(1));
```

First, let's discuss the `ArrayList` part of that. An ArrayList is an **implementation** of the `List` interface. It should be your "go-to" List when you need to store data (`LinkedList` is another List implementation). Behind the scenes, ArrayLists actually use arrays - but we don't need to interact with the array directly, as you see above (no `[]` in sight).

Why don't the types match? `List` and `ArrayList` are not the same thing - or are they? As we've said, ArrayList is an implementation of the List interface. Therefore `ArrayList` IS-A `List` (though the reverse is not true).

We can access items in the List with `get(int index)`, and add new items with `add()`. Since we've used String as the type for this List (in the above example), `get()` will return a String, and `add()` will require a String argument to be added to the List. Items can be removed from the list with the `remove()` method.

#### Map

Maps are often referred to as "dictionaries" or "hashes" in other languages. They are an extremely useful data structure. The basic concept of a map is to create an association (a "mapping") between a "key" and a "value". A dictionary is actually a great example of this (hence why that term is used). In a dictionary the "key" is the word, and its associated "value" is the definition of that word.

```java
import java.util.HashMap;
import java.util.Map;

public class MapXample2 {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("chromosome", "a threadlike structure of nucleic acids" +
                " and protein found in the nucleus of most living cells," +
                " carrying genetic information in the form of genes");

        dictionary.put("hammer", "a tool with a heavy metal head" +
                " mounted at right angles at the end of a handle");

        System.out.println(dictionary.get("chromosome"));
        System.out.println(dictionary.get("genetics"));
        System.out.println(dictionary.get("hammer"));
    }
}
```

Of course dictionaries and maps aren't magical! It only knows the words we teach it. We add items to maps using the `put()` method, which accepts two arguments - the key and the value we want to map. Notice that the Map interface has two generic parameters. In this case, they are both Strings, but they could be any type. When the types aren't the same, the order does matter: the first generic is the key and the second is the value. Here are some examples of maps that we might use in various applications.

```java
Map<String, User> userMap; //A map to look up Users by username
Map<User, List<String>> userMessages; //A map between users received messages
Map<Boolean, String> trueFalseStatements; //A map that sorts statements into t/f
```

The `get()` method is used to access a map, but unlike the `get()` method for lists, this method is based on the type of the key. In our example above, it was a String.

HashMaps are a good default implementation of Map. In general, maps are an excellent solution and perform quite well when the key/value pairing is possible.

Consider the following problem: you're writing an application for bank tellers. A customer will walk up and give the teller an account number. The teller will then need to be able to look up their account information.

If we modeled this with a List of Accounts it would look something like this:

```java
List<Account> accountList = new ArrayList<>();
public Account findAccountByNumber (int accountNumber) {
  for (Account account : accountList) {
    if (account.getAccountNumber() == accountNumber) {
      return account;
    }
  }
  return null;
}
```

If we have tens or hundreds of thousands of accounts, this is an extremely inefficient approach. We will have to iterate through on average half of those accounts, checking to see "are we there yet? are we there yet?" Maps provide a much better solution:

```java
Map<Integer, Account> accountMap = new HashMap<>();
public Account findAccountByNumber (int accountNumber) {
  return accountMap.get(accountNumber);
}
```

Because of the way the `get()` function works behind the scenes, this method won't have to search through a list with 100,000 accounts. The Map will either immediately return the Account, or null.

#### Set

The Java "Set" collection models the mathematical concept of a "set". In math, sets can contain anything (often sets of numbers) but each element must be unique. In other words, an element is either in the set, or it's not in the set - it can't be in the set twice. Let's see what this looks like in Java. Try playing around with the code below by adding 5 to the collections.

```java
import java.util.*;

public class SetXample {

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        numList.add(3);
        numSet.add(3);
        numList.add(5);
        numSet.add(5);

        System.out.println("List:" + numList);
        System.out.println("Set:" + numSet);

        while (true) {
            System.out.println("What number to add to the collections?");
            int answer = Integer.parseInt((new Scanner(System.in)).nextLine());
            numList.add(answer);
            numSet.add(answer);

            System.out.println("List:" + numList);
            System.out.println("Set:" + numSet);
        }
    }
}
```

You should see that 5 was successfully added to the List, but the Set remained the same. Notice that the Set does not throw an error - the duplicate element just isn't added.

* HashSet is a good default implementation of Set, just like ArrayList for List and HashMap for Map. As before, I encourage you to research the various implementations and figure out what will work best for your code.
* More formal definition of a Set: an element "e" can be added to the set if and only if the set contains no other element "e2" such that `e.equals(e2)`.
* If set elements are "mutable" (can be changed), the uniqueness of the set isn't guaranteed.

Sets are a useful data structure when you want this "uniqueness" feature. Six friends who all have their own unique "spark" have participated in a 10k walk. We want to pick three lucky winners to receive a prize.

```java
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetXample2 {

    public static void main(String[] args) {
        String[] lotteryNames = {"Johnny", "Jason", "Lily", "Sandra", "Garry", "Nicol"};
        Set<String> winnersNames = new HashSet<>();
        Random random = new Random();
        while (winnersNames.size() < 3) {
            int index = random.nextInt(lotteryNames.length);
            winnersNames.add(lotteryNames[index]);
        }
        System.out.println(winnersNames);
    }
}
```

In this example, I am letting the Set interface do my work for me. Instead of worrying about keeping a list of indexes that I've already used, I simply continue attempting to add names until the set has three names in it. If a name comes up multiple times, it simply won't be inserted again. This method will always return 3 different names (no double winners).

(Note that this approach is probably not the most scalable option; if we had to pick 1,000 winners out of 2,000 people we'd end up looping through a lot of extra times. It's just an example of the use of Sets).

### Default Collections

* List - ArrayList
* Map - HashMap
* Set - HashSet

Different implementations of these collections will perform better or worse under certain circumstances. Let's take a step back and define "perform better". In short, all operations (adding items to a collection, removing items from a collection, iterating through a collection) take time. The amount of time these operations take depends on the implementation of the collection.

For example, `LinkedList` is fast at adding and deleting elements, but slow to get specific elements. `ArrayList` is the opposite, performing add and delete more slowly, but accessing individual elements quickly and easily (which makes a lot of sense if you dive into specifically how they are implemented). Also, it's important to keep in mind that "fast" and "slow" are relative terms. You will have trouble noticing any performance difference between an `ArrayList` and a `LinkedList` with 8 elements, since computers are in general *very* fast. Once your application scales up to having thousands or millions or elements though, it can make a big difference.

In general, the three defaults above are good options. If you need a List, unless you've done some research and considered why a `LinkedList` is going to perform better for your program, you should use ArrayList. There is a lot of information available online about the pros and cons of various collections.

## Performance/Benchmarks

The code below adds the numbers 1 to 1 million to the different collections we've discussed and tracks the time it takes to complete that operation.

```java
import java.util.*;

public class Benchmarkin {

    public static void main(String[] args) {
        final int ONE_MILLION = 1000000; //Note use of final/const variable
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < ONE_MILLION; i++) {
            arrayList.add(i);
        }
        endTime = System.currentTimeMillis();
        long arrayListAddTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < ONE_MILLION; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        long linkedListAddTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < ONE_MILLION; i++) {
            hashSet.add(i);
        }
        endTime = System.currentTimeMillis();
        long hashSetAddTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < ONE_MILLION; i++) {
            hashMap.put(i, i);
        }
        endTime = System.currentTimeMillis();
        long hashMapAddTime = endTime - startTime;

        System.out.println("Time to add 1 million numbers (in milliseconds):");
        System.out.println("ArrayList: " + arrayListAddTime);
        System.out.println("LinkedList: " + linkedListAddTime);
        System.out.println("HashSet: " + hashSetAddTime);
        System.out.println("HashMap: " + hashMapAddTime);
    }
}
```

Notes:
* This is not a rigorous scientific experiment; we're only testing one operation (add/put), and only with one particular data type.
* The outcomes of these benchmarks can change wildly based on the optimization. (Basically, as your code is built into Java byte code, it will attempt to make it run as fast as possible)
* Nevertheless, you should be able to see that ArrayLists are **very** fast
* Use of `final int ONE_MILLION`: at a glance it is hard to tell the difference between 100000, 1000000, and 10000000. To make sure I have the same number of values added, I used this variable. A better name would have been something like "LOOP_TIMES", because now if I want to change the number I'll have to refactor the name as well. Also note the use of the "upper snake case" for final variables (this is the convention in Java).
