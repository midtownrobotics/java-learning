## File I/O in Java

It's often useful to be able to write data to files. This could be for various reasons - maybe your program creates some CSV (comma separated value) data that you output to a file and other users use this data. Maybe you want to create a debugging log for your program. In any case, Java has good built-in functions to write to (and read from) files.

### File Output - Writing To File

We will use the `File` and `FileWriter` classes (in the java.io package). The `File` class represents the file we'll be writing to - we have to provide it the file name. The `FileWriter` class will handle the heavy lifting of copying data and so on - all we have to do is point it to the `File` and have it get started.

Copy the code below into an IntelliJ project and run it.

```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOExample {

    public static void main(String[] args) {
        try {
            File file = new File("greetings.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello World!\n"); //Very simple!
            fileWriter.write("File IO is cool and not scary!");
            fileWriter.close(); //close() cleans up and commits changes
        } //If Java doesn't find the file it will create it for us
        catch (IOException ex) { //A general exception that covers many errors
            ex.printStackTrace();
        }
    }
}
```

You should see a `greetings.txt` file appear with the greeting we wrote.

### File Input - Reading From File

In practice, reading from a file is usually a bit more complex. This is because you usually have to interpret and parse the data we are reading in. For now, we won't worry about parsing the data.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIOExample2 {

    public static void main(String[] args) {
        String[] fileContents = getFileContents("list.txt");

        for (String line : fileContents) {
            System.out.println(line);
        }
    }

    //Returns the contents of the given file as a String[] separated by lines
    //If it can't find the file it will return null after printing an error
    public static String[] getFileContents (String fileName) {
        File file = new File (fileName);
        try {
            Scanner fileScanner = new Scanner(file);
            List<String> fileContents = new ArrayList<>();
            while (fileScanner.hasNext()) {
                fileContents.add(fileScanner.nextLine());
            }
            return fileContents.toArray(new String[0]); //Converts the list to an array
        } //Since this time we are asking for data back from the file
        //We have to specify what to do if it isn't found
        catch (FileNotFoundException ex) {
            System.out.println("Could not find file *" + fileName + "*");
            ex.printStackTrace();
            return null;
        }
    }
}
```

Create a file called `list.txt` and add some content to it, for example:

```
apples
bananas
raspberries
strawberries
```

When you run the code above, you should see those lines printed out.
