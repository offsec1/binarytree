public class Test {

    public static void main(String[] args) {
        //System.out.printf("And awayyyyyy we gooooo!\n");

        String a = "asdf", b = "aa", c = "qwer", d = "uiop";
        BinaryTree<String> stringTree = new BinaryTree<>();
        stringTree.add(a);
        stringTree.add(b);
        stringTree.add(c);
        stringTree.add(d);

        //Integer b = 12;
        //BinaryTree_obsolete<Integer> integerTree = new BinaryTree_obsolete<>();

        //System.out.println(stringTree.toString());
        stringTree.print();

        //stringTree.delete("qwer");
        //System.out.println(stringTree.toString());
        stringTree.print();

        //stringTree.deleteTree();
        //System.out.println(stringTree.toString());
        //stringTree.print();

        //stringTree.add(b);
        //stringTree.print();
        //System.out.println(stringTree.toString());
        //stringTree.print();

        BinaryTreeUtils.exportBinaryTree(stringTree, "bintree.json");

        BinaryTree<String> newTree = BinaryTreeUtils.importBinaryTree("bintree.json");
        newTree.print();
    }
}
