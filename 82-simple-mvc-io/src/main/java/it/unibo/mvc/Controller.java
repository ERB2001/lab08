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

    public String fileName() {
        String path = System.getProperty("user.home")
                + File.separator
                + Controller.class.getSimpleName() + ".txt";
        return path;
    }

    public boolean fileExists(File f) {
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String getPath(File f) {
        return f.getPath();
    }

    public String getAbsolutePath(File f) {
        return f.getAbsolutePath();
    }

    public void saveInFile(String s) {
        try (PrintStream ps = new PrintStream(fileName(), StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
