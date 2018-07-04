import java.util.ArrayList;
import java.util.List;

public class BinaryTree <T> {

    private List<Node> tree;

    /**
     * Empty constructor
     */
    public BinaryTree() {
        this.tree = new ArrayList<>();
    }

    public void add(T data) {

        Node newNode = new Node(data);
        tree.add(newNode);

        for (Node n : tree) {

            if (n.childLeft != null && n.childRight != null)
                continue;;

            if (n.childLeft == null)
                n.childLeft = newNode;
            else if (n.childRight == null)
                n.childRight = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //TODO PM: add output logic
        for (Node n : tree) {
            sb.append(n.toString());
            sb.append("   /\t \\\n");
            
        }

        return sb.toString();
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(" + this.data.toString() + ")");
            return sb.toString();
        }
    }

}
