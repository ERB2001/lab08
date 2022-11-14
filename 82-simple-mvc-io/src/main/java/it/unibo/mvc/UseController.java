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
        Controller controller = new Controller();
        controller.fileName();
        System.out.println(controller.getPath());
        // System.out.println(controller.getAbsolutePath());
        String s = new String("Nuovo Tentativo");
        controller.saveInFile(s);
    }
}
