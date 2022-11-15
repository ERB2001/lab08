package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Controller {

    private final static String fileName = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";

    private File file;

    public Controller() {
        this.file = new File(fileName);
    }

    public Controller(File f) {
        this.file = f;
    }

    public void setFile(File f) {
        file = f;
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return file.getPath();
    }

    public void saveInFile(String s) {
        /*
         * try (FileWriter fw = new FileWriter(fileName)) {
         * fw.append(s);
         * } catch (IOException e1) {
         * e1.printStackTrace();
         * }
         */

        /*
         * try {
         * FileWriter fw = new FileWriter(fileName);
         * fw.append(s);
         * } catch (IOException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         */

        try (PrintStream ps = new PrintStream(fileName, StandardCharsets.UTF_8)) {
            ps.append(s);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
