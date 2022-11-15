package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    /*
     * A method for setting the next string to print.
     * Null values are not acceptable,
     * and an exception should be produced
     */
    public void setNextString(String s) {
    }

    /* A method for getting the next string to print */
    public String getNextString() {
        return null;
    }

    /*
     * A method for getting the history of
     * the printed strings (in form of a List of Strings)
     */
    public List<String> getPrintedElementHistory() {
        return null;
    }

    /*
     * A method that prints the current string.
     * If the current string is unset,
     * an IllegalStateException should be thrown
     */
    public String toString() {
        return null;
    }
}
