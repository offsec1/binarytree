import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {

    private Node root;
    private ArrayList<Node> nodeList;

    private int grade; //used for printing tree on console
    private int w = 120, h=80; //used for the printing on the GUI

    /**
     * Empty constructor which sets the root element to null
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Collects all Nodes and returns them
     * @return all Nodes in an ArrayList
     */
    public ArrayList<Node> getBinaryTree() {
        nodeList = new ArrayList<>();
        grade = 0;
        fillNodeList(root);
        return nodeList;
    }

    /**
     * Is called by the getBinaryTree function to collect all nodes recursively
     * @param n node object
     */
    private void fillNodeList(Node n) {
        if (n != null) {
            grade++;
            fillNodeList(n.rightChild);
            grade--;
            nodeList.add(n);
            grade++;
            fillNodeList(n.leftChild);
            grade--;
        }
    }

    /**
     * Adds a new Node to the binary tree
     * @param data the value of the Node
     */
    public void add(T data) {

        if (root == null) {
            root = new Node(data);
            root.x = 400;
            root.y = 60;
        }
        else
            recursiveAdd(root, data);
    }

    /**
     * Recursively loops the tree until it finds the right place to add the new node
     * @param n the node object
     * @param data data which is added
     */
    private void recursiveAdd(Node n, T data) {

        if (n.data.compareTo(data) > 0) {
            if (n.leftChild == null) {
                n.leftChild = new Node(data);
                n.leftChild.x = n.x - w;
                n.leftChild.y = n.y + h;
                w -=5;
            }
            else
                recursiveAdd(n.leftChild, data);
        }
        else {
            if (n.rightChild == null) {
                n.rightChild = new Node(data);
                n.rightChild.x = n.x + w;
                n.rightChild.y = n.y + h;
                w -=5;
            }
            else
                recursiveAdd(n.rightChild, data);
        }
    }

    /**
     * Calls the recursiveDelete function if the root is not null
     * If there is more than one node with the same data only the first occurrence is deleted
     * @param data the data which is to be deleted
     */
    public void delete(T data) {

        root = recursiveDelete(root, data);
    }

    /**
     * Recursively loops the tree until it finds the given data and deletes it
     * StackOverflow helped a lot there
     * @see <a href="https://stackoverflow.com/questions/28397521/remove-recursively-from-a-binary-search-tree">StackOverflow - remove recursively from a binary searh tree</a>
     * @param n the node object
     * @param data the data which is removed
     * @return
     */
    private Node recursiveDelete(Node n, T data) {

        if (n == null || data == null)
            return null;

        if (n.data.compareTo(data) > 0) {
            n.leftChild = recursiveDelete(n.leftChild, data);
        }
        else if (n.data.compareTo(data) < 0){
            n.rightChild = recursiveDelete(n.rightChild, data);
        }
        else {

            //node has only one or no child
            if (n.leftChild == null)
                return n.rightChild;
            else if (n.rightChild == null)
                return n.leftChild;

            //node has two children
            n.data = minNodeData(n.rightChild);
            n.rightChild = recursiveDelete(n.rightChild, n.data);
        }

        return n;
    }

    /**
     * In order to remove an object without messing up the tree structure this helper method is used
     * It finds the node which should replace the deleted one
     * @param n node object
     * @return minimal value in the subtree starting from given node
     */
    private T minNodeData(Node n) {
        T minData = n.data;

        while(n.leftChild != null) {
            minData = n.leftChild.data;
            n = n.leftChild;
        }

        return minData;
    }

    /**
     * Deletes the whole binary tree
     */
    public void deleteTree() {
        root = null;
    }


    /**
     * Print the tree to the console
     */
    public void print() {
        System.out.println("\n --- Baum - Uebersicht --- \n");
        grade = 0;
        structure(root);
    }

    /**
     * This actually prints the tree to the console recursively
     * @param n node object
     */
    private void structure(Node n) {

        if (n != null) {
            grade++;
            structure(n.rightChild);
            grade--;
            for (int i = 0; i < grade; i++) {
                System.out.print("    ");
            }
            System.out.println(" <- " + n.data);
            grade++;
            structure(n.leftChild);
            grade--;
        }
    }

    /**
     * public nested class 'Node'
     */
    public class Node {

        public T data;
        public Node leftChild;
        public Node rightChild;
        public int x, y;

        /**
         * Constructor
         * @param data the value which needs to be stored
         */
        public Node(T data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

    }
}
