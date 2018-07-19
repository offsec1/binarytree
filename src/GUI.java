import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JPanel {


    private JButton addButton;
    private JButton deleteButton;
    private JButton importButton;
    private JButton exportButton;
    private JButton clearButton;
    private BinaryTree<String> binTree;


    /**
     * constructor for user interface
     */
    public GUI() {

        //Panel settings
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        //AddButton
        initAddButton();
        add(addButton);

        //DeleteButton
        initDelButton();
        add(deleteButton);

        //ImportButton
        initImportButton();
        add(importButton);

        //ExportButton
        initExportButton();
        add(exportButton);

        //ClearButton
        initClearButton();
        add(clearButton);

        //Binary tree settings
        binTree = new BinaryTree<>();
    }

    /**
     * initialise settings for the add button
     */
    private void initAddButton() {
        addButton = new JButton("add");
        addButton.setLayout(new FlowLayout());
        addButton.setPreferredSize(new Dimension(80, 40));

        ActionListener buttonHandler;
        buttonHandler = e -> {
            //Adding new Nodes
            String input = JOptionPane.showInputDialog("New value: ");
            binTree.add(input);
            binTree.print();
            repaint();
        };
        addButton.addActionListener(buttonHandler);
    }

    /**
     * initialise settings for the delete button
     */
    private void initDelButton() {
        deleteButton = new JButton("delete");
        deleteButton.setLayout(new FlowLayout());
        deleteButton.setPreferredSize(new Dimension(100, 40));

        ActionListener buttonHandler;
        buttonHandler = e -> {
            //Adding new Nodes
            String input = JOptionPane.showInputDialog("Value to delete: ");
            binTree.delete(input);
            binTree.print();
            repaint();
        };
        deleteButton.addActionListener(buttonHandler);
    }

    /**
     * initialise settings for the import button
     */
    private void initImportButton() {
        importButton = new JButton("import");
        importButton.setLayout(new FlowLayout());
        importButton.setPreferredSize(new Dimension(80, 40));

        ActionListener buttonHandler;
        buttonHandler = e -> {
            //Adding new Nodes
            String path = JOptionPane.showInputDialog("Filename: ");
            binTree = BinaryTreeUtils.importBinaryTree(path);
            repaint();
        };
        importButton.addActionListener(buttonHandler);
    }

    /**
     * initialise settings for the export button
     */
    private void initExportButton() {
        exportButton = new JButton("export");
        exportButton.setLayout(new FlowLayout());
        exportButton.setPreferredSize(new Dimension(80, 40));

        ActionListener buttonHandler;
        buttonHandler = e -> {
            //Adding new Nodes
            String path = JOptionPane.showInputDialog("Filename: ");
            BinaryTreeUtils.exportBinaryTree(binTree, path);
        };
        exportButton.addActionListener(buttonHandler);
    }

    /**
     * initialise settings for the clear button
     */
    private void initClearButton() {
        clearButton = new JButton("clear");
        clearButton.setLayout(new FlowLayout());
        clearButton.setPreferredSize(new Dimension(80, 40));

        ActionListener buttonHandler;
        buttonHandler = e -> {
            //Adding new Nodes
            binTree.deleteTree();
            repaint();
        };
        clearButton.addActionListener(buttonHandler);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<BinaryTree<String>.Node> nodeList = binTree.getBinaryTree();

        for (BinaryTree.Node n: nodeList) {
            g.drawOval(n.x, n.y, 40, 40);
            g.drawString(n.data.toString(), n.x +5, n.y+25);

            if(n.rightChild != null) {
                g.drawLine(n.x+15, n.y+40, n.x+90, n.y+90);
            }

            if(n.leftChild != null) {
                g.drawLine(n.x+15, n.y+40, n.x-50, n.y+90);
            }
        }
    }

}
