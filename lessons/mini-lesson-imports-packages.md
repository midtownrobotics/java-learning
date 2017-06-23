## Imports and Packages

We've made reference to packages and import statements before. This lesson will cover those topics in more detail.

### Packages

Packages are just ways of organizing your files. When you're writing a small assignment for class you most likely have 1-4 different files. Imagine working on a project with literally hundreds of files. You wouldn't want all the work from that project to just be stored in one big folder.

In Java, the `package` keyword, optionally used at the top of a file, just makes it clear where that file lives within your project.

`package robotics.autonomous`

Every project has a "root" for the source files - where they live by default. The statement above means that inside that `src` folder is a `robotics` folder and inside that is a `autonomous` folder, and inside that is where this particular file lives.

Once you start to have more than 8-10 files in your project, you should use packages to keep them organized. Hint: you can use the IDE to make the process of moving files around a lot easier - it will automatically change the `package` for you when you refactor.

### Import Statements

"Import" is a bit of a deceptive term. When I first learned Java (back when you were learning to say "mama" and "dada" - I'm super old), I thought that import statements effectively copied in someone else's code to your file. That is completely wrong.

Imports are actually an example of a concept that C++ makes a little bit more explicit by referring to it as a "namespace". By default in Java, we're in the `java.lang` namespace. That might sound intimidating, but it just means this: we're already sitting in "java.lang" territory, and that allows us to know everything in that world. For example, we "know" about java.lang.String - we don't have to import it.

Anything you don't "know" about, you will have to tell Java where to locate it. To do this, you can use the **fully qualified class name**. `java.lang.String` is the fully qualified class name of String - and you can refer to it like that (though you have no need to).

```java
java.lang.String myName = "Paul";
```

Let's consider something we don't "know" about by default: the `Scanner` class we used to get input from the user. The fully qualified class name is `java.util.Scanner`. The `java.util` package contains a lot of very useful classes. If we only needed a Scanner in one place, we could skip the import and just refer to it by that fully qualified class name:

```java
java.util.Scanner myScanner; //No import needed!
```

However, for classes you will be using a lot, this isn't very convenient (especially for classes with a really long name such as `org.springframework.web.bind.annotation.RequestBody`). So we can use an `import` statement to let Java know about that namespace. (In C++ instead of import they say "using namespace" which is much more accurate)

```java
//At beginning of file
import java.util.Scanner;
//Later:
Scanner myScanner; //No fully qualified class name needed!
```

You can also use an asterisk `*` to import everything from a package:

```java
import java.util.*;
//Now we have everything in this package including:
//Scanner, HashMap, Arrays, Collections, and many many more!
```

In general it is best practice to limit your imports to only what you need (don't gratuitously use `*`). Why is this?

When I first learned Java I thought that more import statements meant more foreign code copied in, which would make your code take longer to run. In reality, unused imports shouldn't slow down your code much if it all. The problem occurs when you try to define a class that's already defined.

Let's say your program requires scanning some files. You've never heard of the Scanner class but you're confident. "Ahah!" you say to yourself, "I will write my own class to scan files. I'll call it a Scanner!" Everything is fine, and your class works great. Then, you need the Map class so you `import java.util.*;`. Suddenly Java doesn't know what you mean by "Scanner" - do you mean the `java.util.Scanner` you asked it to import, or the `robotics.mypackage.Scanner` class you defined yourself?

This is why you should make it a habit to only import things you need. Use `.*` imports sparingly, only if you will be using a huge number of things from the package.

Hint: your IDE will help you out with imports in two ways. First, if you refer to something in regular Java packages that you haven't yet imported (like Scanner) it will suggest the possible imports, and you can confirm and add them automatically with a hotkey. In IntelliJ it's Alt-Enter.

Second, if an import becomes unnecessary (maybe you thought you needed a Scanner and then decided on something else), the IDE will mark those as unused and grey them out. This is your queue to either get rid of the import statement or use it.
