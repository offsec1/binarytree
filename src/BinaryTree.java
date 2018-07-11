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

        //don't process the root element
        if (tree.size() > 1) {

            for (Node n : tree) {

                if (n.childLeft != null && n.childRight != null)
                    continue;

                if (n.childLeft == null) {
                    n.childLeft = newNode;
                    break;
                }
                else if (n.childRight == null) {
                    n.childRight = newNode;
                    break;
                }
            }
        }
    }

    public void exportTree() {
        //TODO PM: export tree to a file (xml would be nice but I guess bin or txt is appropriate for the exam)
    }

    public void importTree() {
        //TODO PM: import tree from file
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(tree.get(0).toString());

        //TODO PM: add output logic (it's okay for testing but not good like this)
        for (Node n : tree) {

            if (n.childLeft == null && n.childRight == null)
                break;

            sb.append("\n   /\t \\\n");

            if (n.childLeft != null)
                sb.append(n.childLeft.toString());
            if (n.childRight != null)
                sb.append(n.childRight.toString());

            sb.append("\n");
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
