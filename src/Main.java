import javax.swing.*;
import java.awt.*;

/**
 * @author s0563806
 */
public class Main {

    /**
     * this just starts the app
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * start the app with system look and feel
     */
    public Main() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //display the GUI in a nice way
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                /* ignore if this doesn't work */
            }

            JFrame frame = new JFrame("Binary Tree - by offsec1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GUI());
            frame.pack();
            frame.setLocationRelativeTo(null); //start position is middle of the screen
            frame.setVisible(true);
        });
    }

}