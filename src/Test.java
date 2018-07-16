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

        stringTree.print();

        stringTree.delete("qwer");
        stringTree.print();

        stringTree.deleteTree();
        stringTree.print();

        //System.out.println(stringTree.toString());

    }
}
