package it.unibo.mvc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString;

    private List<String> history;

    public SimpleController() {
        currentString = null;
        history = new ArrayList<>();
    }

    /*
     * A method for setting the next string to print.
     * Null values are not acceptable,
     * and an exception should be produced
     */
    public void setNextString(String s) {
        if (s != null) {
            currentString = s;
        } else {
            throw new NullPointerException("Error");
        }
    }

    /* A method for getting the next string to print */
    public String getNextString() {
        return currentString;
    }

    /*
     * A method for getting the history of
     * the printed strings (in form of a List of Strings)
     */
    public List<String> getPrintedElementHistory() {
        return List.copyOf(history);
    }

    /*
     * A method that prints the current string.
     * If the current string is unset,
     * an IllegalStateException should be thrown
     */
    public void printString() {
        if (currentString != null) {
            System.out.println(currentString);
            history.add(currentString);
        } else {
            throw new IllegalStateException("Error");
        }

    }
}
/*
 * il file mi viene creato solo nel momento in cui gli aggiungo
 * un contenuto
 */
