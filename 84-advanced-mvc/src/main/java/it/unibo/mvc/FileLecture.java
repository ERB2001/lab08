package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLecture {

    private final static String PATH = System.getProperty("user.dir")
            + System.getProperty("file.separator")
            + "src/main/resources/config.yml";

    private FileReader reader;

    private BufferedReader bufferReader;

    private Configuration.Builder confBuilder;

    private Configuration conf;

    public FileLecture() {

        confBuilder = new Configuration.Builder();

        try {
            reader = new FileReader(PATH);
            bufferReader = new BufferedReader(reader);
            // int data = reader.read();
            String splitter;
            while ((splitter = bufferReader.readLine()) != null) {
                System.out.println(splitter);
                String[] lines = splitter.split(":");
                if (lines.length == 2) {

                    final int value = Integer.parseInt(lines[1].trim());

                    if (lines[0].contains("maximum")) {
                        confBuilder.setMax(value);
                    } else if (lines[0].contains("minimum")) {
                        confBuilder.setMin(value);
                    } else if (lines[0].contains("attempts")) {
                        confBuilder.setAttempts(value);
                    }
                } else {
                    DrawNumberView dV = new DrawNumberViewImpl();
                    dV.displayError("My Error");
                }
            }
            conf = confBuilder.build();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*
     * public Configuration.Builder getConfigurtionBuilder() {
     * return this.confBuilder;
     * }
     */

    public Configuration getConfiguration() {
        return this.conf;
    }

    public static void main(String[] args) {
        System.out.println(new FileLecture().getConfiguration().getAttempts());
    }

}
