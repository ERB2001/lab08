package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

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

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        canvas.add(field, BorderLayout.NORTH);

        JPanel myCanvas = new JPanel();
        myCanvas.setLayout(new BorderLayout());

        JButton browse = new JButton("Browse");

        myCanvas.add(browse, BorderLayout.NORTH);

        canvas.add(myCanvas);

        frame.add(canvas);

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
