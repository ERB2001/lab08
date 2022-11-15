package it.unibo.mvc;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    protected final String FILENAME = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + SimpleController.class.getSimpleName() + ".txt";

    File file;

    String currentString;

    List<String> nextString;

    public SimpleController(String s) {
        currentString = s;
        file = new File(FILENAME);
        nextString = new ArrayList<>();
    }

    /*
     * A method for setting the next string to print.
     * Null values are not acceptable,
     * and an exception should be produced
     */
    public void setNextString(String s) {
        nextString.add(s);
    }

    /* A method for getting the next string to print */
    public List<String> getNextString() {
        List<String> lines = new ArrayList<String>();
        for (String s2 : nextString) {
            lines.add(s2);
        }
        return lines;
    }

    /*
     * A method for getting the history of
     * the printed strings (in form of a List of Strings)
     */
    public List<String> getPrintedElementHistory() {
        try {
            List<String> history = new ArrayList<>();
            FileReader reader = new FileReader(FILENAME);
            int data = reader.read();
            while (data != -1) {
                history.add(String.valueOf((char) data));
                data = reader.read();
            }

            List<String> lines = new ArrayList<String>();
            for (String s : history) {
                lines.add(s);
            }
            return history;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    public void saveInFile() {

        try (PrintStream ps = new PrintStream(FILENAME, StandardCharsets.UTF_8)) {
            ps.append(currentString);
            for (String s : nextString) {
                ps.append(s);
            }
            ps.close();
        } catch (IOException e1) {
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }

    }

    /*
     * A method that prints the current string.
     * If the current string is unset,
     * an IllegalStateException should be thrown
     */
    public String toString() {
        return currentString;
    }

    public static void main(String[] args) {
        String current = new String("Ciao");
        String nextString1 = new String("a tutti");
        String nextString2 = new String("come");
        SimpleController controller = new SimpleController(current);
        controller.setNextString(nextString1);
        System.out.println(controller.getNextString());
        controller.setNextString(nextString2);
        System.out.println(controller.getNextString());
        // String[] prova = new String[] { "Ciao", "Come stai?", "Tutto bene" };
        controller.saveInFile();
        System.out.println(controller.getPrintedElementHistory());

    }
}
/*
 * il file mi viene creato solo nel momento in cui gli aggiungo
 * un contenuto
 */
