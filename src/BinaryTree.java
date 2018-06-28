import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree <T> {

    private List<Node> tree;

    /**
     * Empty constructor
     */
    public BinaryTree() {
        this.tree = new ArrayList<>(); //hmmmmmm
    }

    /**
     * Constructor which initialises the root element
     * @param data root element
     */
    public BinaryTree(T data) {
        this.tree = new ArrayList<>(); //hmmmmmmm
        this.tree.add(new Node(data));
    }

    public void add(T data) {

        Node newNode = new Node(data);

        tree.add(newNode);

        for (Node n : tree) {
            if (n.childLeft == null)
                n.childLeft = newNode;
            else if (n.childRight == null)
                n.childRight = newNode;
        }
    }

    @Override
    public String toString() {
        return tree.toString();
    }

    private class Node {

        /*
        Maybe add:
        int gradeOfPosition;
        int xPosition;
        int yPosition;
         */

        public T data;
        public Node childLeft;
        public Node childRight;

        public Node(T d) {
            this.data = d;
            this.childLeft = null;
            this.childRight = null;
        }

    }

}
