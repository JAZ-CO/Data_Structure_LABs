public class BSTdriver {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.root = new BSTNode<>(2);
        bst.root.right = new BSTNode<>(1);
        bst.root.right.left = new BSTNode<>(4);
        bst.root.left = new BSTNode<>(3);
        bst.root.left.left = new BSTNode<>(5);

    }
}
