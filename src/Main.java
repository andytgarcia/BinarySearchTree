public class Main {
    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();

        tree.add(100);
        tree.add(50);
        tree.add(200);
        tree.add(156);
        tree.add(75);
        tree.add(120);
        tree.add(25);



        tree.printInOrder();

        System.out.println();

        System.out.println(tree.exists(120));
        System.out.println(tree.exists(100));
        System.out.println(tree.exists(75));
        System.out.println(tree.exists(155));
        System.out.println(tree.exists(52));
        System.out.println(tree.exists(25));
    }
}
