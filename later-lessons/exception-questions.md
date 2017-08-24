## Questions on Exception handling

Q. In what order will Java evaluate try/catch/finally blocks?

    * Try is executed first; program will jump to appropriate catch blocks, then finally will run if there was an exception thrown
    * Program will evaluate all catch blocks first to determine which ones are most likely to be triggered, then start the try block.
    * Try is executed first; program will jump to appropriate catch blocks, then finally will always run
    * Try is executed first; program will jump to appropriate catch blocks, then return to the try block, then run the finally block.

Q. What is the value of `sum` at the end of this code?
```java
int sum = 0;
try {
    sum += 5;
    String s = null;
    try {
        s.toLowerCase();
    } catch (NullPointerException ex) {
        sum *= 2;
    }
} catch (NumberFormatException ex) {
    sum -= 10;
} finally {
    sum *= 3;
}
```
      * 10
      * 30
      * 20
      * 5
      * 15
