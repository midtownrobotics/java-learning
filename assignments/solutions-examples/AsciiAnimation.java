/**
 * Created by pauldennis on 6/13/17.
 */
public class AsciiAnimation {

    //Here is my main method, which is just going to loop through the animation and be done.
    public static void main(String[] args) {
        for (int x = 0; x < 15; x++) {
            clearMacScreen();
            drawBox(x); //As x increases the box will get bigger
            wait(250);
        }
    }

    //This function draws a "box" of the given size
    public static void drawBox (int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            drawLine(size);
        }
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //This function draws a "line" of the given size.
    //Each line starts with a | followed by *size* spaces, then a closing |
    //This is a good example of a "helper function" - its job is just to help the drawBox() function
    //This is good coding practice because it will make the drawBox() function much simpler to write
    public static void drawLine (int size) {
        System.out.print("|");
        for (int i = 0; i < size; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    //This is the one of the functions I gave you to clear the screen
    //Note that this might not work properly running from the IDE
    public static void clearMacScreen() {
        //This is a special character combination that clears the screen
        System.out.print("\033[H\033[2J");
    }

    //This function will allow you to pause your program for a certain number of milliseconds
    //Longer pauses result in a slower animation
    public static void wait (int millis) {
        //This function uses something we haven't discussed yet called "exception handling"
        //Don't worry about it for now
        try {
            Thread.sleep(millis); // <- This is the line that actually does something
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
