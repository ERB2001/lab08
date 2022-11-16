package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /*
     * A method for setting the next string to print.
     * Null values are not acceptable,
     * and an exception should be produced
     */
    void setNextString(String s);

    /* A method for getting the next string to print */
    String getNextString();

    /*
     * A method for getting the history of
     * the printed strings (in form of a List of Strings)
     */
    List<String> getPrintedElementHistory();

    /*
     * A method that prints the current string.
     * If the current string is unset,
     * an IllegalStateException should be thrown
     */
    String toString();

}
