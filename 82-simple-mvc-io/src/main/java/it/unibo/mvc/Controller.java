package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Controller {

    public String fileName() {
        String path = System.getProperty("user.home")
                + File.separator
                + "output.txt";
        return path;
    }

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

    public String getPath() {
        return fileCreation().getPath();
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
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }

    }
}
