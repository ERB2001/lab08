package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Controller {

    private final String FILENAME = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";

    File file;

    public Controller() {
        file = new File(FILENAME);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getPath() {
        return file.getPath();
    }

    public void saveInFile(String s) {

        try (PrintStream ps = new PrintStream(FILENAME, StandardCharsets.UTF_8)) {
            ps.append(s);
        } catch (IOException e1) {
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }

    }
}
