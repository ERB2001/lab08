package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "Controller GUI";

    private static final int PROPORTION = 5;

    protected static final String PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";

    private final JFrame frame = new JFrame();

    private final JTextArea textArea = new JTextArea();

    public SimpleGUI() {
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(textArea);

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        JButton save = new JButton("Save");

        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(textArea, BorderLayout.CENTER);

        // frame.setContentPane(canvas);
        frame.add(canvas);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

                Controller controller = new Controller();
                controller.saveInFile(textArea.getText());

            }
        });
    }

    public void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        // textArea.setBounds(0, 0, 300, 100);

        // chiedere come si possono rendere i vari elementi come
        // textarea auto-resizable

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
