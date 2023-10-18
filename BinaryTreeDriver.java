public class BinaryTreeDriver{
    public static void main(String args[]) {
        // To be completed by students
        BinaryTree<Integer> tree = new BinaryTree<>();
        BTNode<Integer> root = new BTNode<>(1);
        BTNode<Integer> left = new BTNode<>(2);
        BTNode<Integer> right = new BTNode<>(3);

        tree.root = root;
        tree.root.left = left;
        tree.root.left.left = new BTNode<>(4);
        tree.root.left.right = new BTNode<>(5);
        tree.root.left.right.left = new BTNode<>(12);
        tree.root.right = right;
        tree.root.right.right = new BTNode<>(8);


        System.out.println("The number of one-child nodes in the tree is " + tree.numOneChildNodes());
        System.out.println("The root subtrees have equal number of nodes: " + tree.subtreesHaveEqualNumberOfNodes());
        int key = 5;
        if (tree.search(key))
            System.out.println("The key " + key + " is in tree");

        System.out.print("Preorder traversal: ");
        tree.preorderTraversal();
        System.out.print("\nInorder traversal: ");
        tree.inorderTraversal();
        System.out.println();

        key = 3;
        if (tree.search(key)){
            System.out.println("Before deleting key "+key+  " level order traversal of binary tree is: ");
            tree.levelOrderTraversal();
        }
        System.out.println("The tree is:");
        tree.printTree();

        if (tree.search(key)){
            System.out.println("After deleting key "+key+  " level order traversal of binary tree is: ");
            tree.levelOrderTraversal();
        }
        System.out.println("The tree is:");
        tree.printTree();

    }
}