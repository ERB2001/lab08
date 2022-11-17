package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private static final String TITLE = "SimpleGUI";

    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setEditable(true);

        canvas.add(textField, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();

        canvas.add(textArea, BorderLayout.CENTER);

        JButton print = new JButton("Print");

        JPanel secondCanvas = new JPanel();

        JButton showHistory = new JButton("Show History");

        secondCanvas.add(showHistory, BorderLayout.WEST);

        secondCanvas.add(print, BorderLayout.EAST);

        canvas.add(secondCanvas, BorderLayout.SOUTH);

        frame.add(canvas);

        SimpleController controller = new SimpleController();

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                controller.setNextString(textField.getText());
                controller.printString();
            }
        });

        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String myString = "";
                for (String s : controller.getPrintedElementHistory()) {
                    textArea.setText(myString += s + "\n");
                }
                // textArea.setText(String.valueOf(controller.getPrintedElementHistory()));

                // textArea.setText(controller.getPrintedElementHistory().toString());

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
        new SimpleGUI().display();
    }
    /*
     * usare il getText() quando si vuole prendere il testo
     * e non stamparlo
     */

}
