package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File file;

    public Controller() {
        file = new File(fileName());
    }

    public String fileName() {
        String path = System.getProperty("user.home")
                + File.separator
                + "output.txt";
        return path;
    }

    /*
    public File fileCreation() {
        File file = new File(fileName());
        return file;
    }
    */

    /*
     * public boolean fileExists(File f) {
     * if (f.exists()) {
     * return true;
     * } else {
     * return false;
     * }
     * }
     */

    public void setFile(File f) {
       file = f; //settaggio del file dandogli un altro nome
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return file.getPath();
    }

    /*
     * public String getAbsolutePath() {
     * return fileCreation().getAbsolutePath();
     * }
     */

    public void saveInFile(String s) {
        try (PrintStream ps = new PrintStream(fileName(), StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (IOException e1) {
            e1.printStackTrace(); 
        }
    }
}
