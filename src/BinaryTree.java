public class BinaryTree <T> {

    private Node root;

    /**
     * Empty constructor
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Constructor which initialises the root element
     * @param data root element
     */
    public BinaryTree(T data) {
        this.root = new Node(data);
    }

    public void add(T data) {

        //initial Object
        if (root == null)
            root = new Node(data);
        else {

            //TODO PM: HERE YOU GO THIS IS WROOOONG!!!!
            Node currentNode = root;
            Node previousNode = null;

            while (currentNode.childLeft != null && currentNode.childRight != null) {

                previousNode = currentNode;
                currentNode = currentNode.childLeft; // or right!!!!11!!
            }

        }

        //TODO PM: add logic
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
