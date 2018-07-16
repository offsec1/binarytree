import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel {


    //private MyJGrid grid;
    private JButton startButton;
    private JLabel gridLabel;


    /**
     * constructor for user interface
     */
    public GUI() {

        //Panel settings
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(650, 650));

        //Button
        initButton();
        add(startButton, BorderLayout.LINE_END);

        //Label
        gridLabel = new JLabel("Grid: 50x50");
        add(gridLabel, BorderLayout.LINE_START);

    }

    /**
     * initialise settings for the button
     */
    private void initButton() {
        startButton = new JButton("start");
        startButton.setLayout(new BorderLayout());
        startButton.setPreferredSize(new Dimension(75, 40));

        ActionListener buttonHandler;
        buttonHandler = e -> {
            System.out.println("Button pressed");
        };
        startButton.addActionListener(buttonHandler);
    }



}
