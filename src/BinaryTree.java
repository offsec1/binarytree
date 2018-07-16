public class BinaryTree<T extends Comparable<T>> {

    private Node root;
    private int grade;

    /**
     * Empty constructor which sets the root element to null
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Adds a new Node to the binary tree
     * @param data the value of the Node
     */
    public void add(T data) {

        if (root == null)
            root = new Node(data);
        else
            recursiveAdd(root, data);
    }

    /**
     *
     * @param n
     * @param data
     */
    private void recursiveAdd(Node n, T data) {

        if (n.data.compareTo(data) > 0) {
            if (n.leftChild == null)
                n.leftChild = new Node(data);
            else
                recursiveAdd(n.leftChild, data);
        }
        else {
            if (n.rightChild == null)
                n.rightChild = new Node(data);
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

        if (n == null)
            return n;

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
     * TODO PM: maybe delete each node...
     * Deletes the whole binary tree
     */
    public void deleteTree() {
        root = null;
    }




    public void print() {
        System.out.println("\n --- Baum - Uebersicht --- \n");
        grade = 0;
        structure(root);
    }

    private void structure(Node n) {

        //StringBuilder sb = new StringBuilder();

        if (n != null) {
            grade++;
            structure(n.rightChild);
            grade--;
            for (int i = 0; i < grade; i++) {
                System.out.print("    ");
                //sb.append("    ");
            }
            System.out.println(" <- " + n.data);
            //sb.append(" <- " + n.data);
            grade++;
            structure(n.leftChild);
            grade--;// rechter Unterbaum
        }
        //return sb.toString();
    }

    //TODO PM: do this
    @Override
    public String toString() {
        //doesn't work
        //return structure(root);
        return "";
    }

    /**
     * private nested class 'Node'
     */
    private class Node {

        public T data;
        public Node leftChild;
        public Node rightChild;

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
