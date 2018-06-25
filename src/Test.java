public class Test {

    public static void main(String[] args) {
        System.out.printf("And awayyyyyy we gooooo!");

        String a = "asdf";
        BinaryTree<String> stringTree = new BinaryTree<>();
        stringTree.add(a);

        Integer b = 12;
        BinaryTree<Integer> integerTree = new BinaryTree<>(b);

        //System.out.println(stringTree.toString());

    }
}
