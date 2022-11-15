package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class UseController {
    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + UseController.class.getSimpleName() + ".txt";

    public static void main(String[] args) {
        /*
         * try (PrintStream ps = new PrintStream(PATH, StandardCharsets.UTF_8)) {
         * ps.print("You");
         * } catch (IOException e1) {
         * e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
         * }
         * }
         */
        /*
         * Controller controller = new Controller();
         * controller.fileName();
         * System.out.println(controller.getPath());
         * // System.out.println(controller.getAbsolutePath());
         * File file = new File(controller.fileName());
         * controller.setFile(file);
         * String s = new String("Nuovo Tentativo");
         * controller.saveInFile(s);
         */
        File file = new File("File1.txt");
        Controller controller = new Controller();
        String s = new String("Nuovo");
        controller.saveInFile(s);
        System.out.println(controller.getPath());
        String s2 = new String("Nuovo3");
        controller.saveInFile(s2);
    }
}
