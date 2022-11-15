package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "SimpleGUIWithFileChooser";

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField field = new JTextField();
        field.setEditable(false);

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        JPanel secondCanvas = new JPanel();

        secondCanvas.setLayout(new BorderLayout());

        JButton save = new JButton("Save");

        canvas.add(save, BorderLayout.SOUTH);

        JButton browse = new JButton("Browse...");

        JFileChooser chooser = new JFileChooser();

        secondCanvas.add(field, BorderLayout.CENTER);

        secondCanvas.add(browse, BorderLayout.LINE_END);

        canvas.add(secondCanvas, BorderLayout.NORTH);

        frame.add(canvas);

        /*
         * browse.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent arg0) {
         * // TODO Auto-generated method stub
         * 
         * try {
         * if (result == JFileChooser.APPROVE_OPTION) {
         * Controller controller = new Controller();
         * File file = new File("SimpleGUIWithFileChooser.txt");
         * controller.setFile(file);
         * }
         * } catch (Exception e) {
         * // TODO: handle exception
         * JOptionPane.showMessageDialog(dialog, "Error");
         * e.printStackTrace();
         * }
         * 
         * }
         * });
         */

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                int result = chooser.showSaveDialog(frame);

                JDialog dialog = new JDialog();

                if (result == JFileChooser.APPROVE_OPTION) {
                    Controller controller = new Controller();
                    // File file = new File("output.txt");
                    controller.setFile(chooser.getSelectedFile());
                    field.setText(controller.getPath());
                    field.getText();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Error");
                }
            }
        });
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
