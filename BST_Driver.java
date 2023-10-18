public class BST_Driver
{
    public static void main(String[] args) {

        // To be completed by students

        // Generate the tree.
            BST<String> bst = new BST<>();
            bst.insert("D");
            bst.insert("B");
            bst.insert("F");
            bst.insert("A");
            bst.insert("C");
            bst.insert("H");
            bst.insert("G");
            bst.insert("J");
        // Display the generated tree
            System.out.println("The BST is:");
            bst.printTree();
            System.out.print("Preorder traversal: ");
            bst.preorderTraversal();
            System.out.print("\nInorder traversal: ");
            bst.inorderTraversal();
            System.out.print("\nLevel order traversal: ");
            bst.levelOrderTraversal();
            System.out.println("\nLevel order traversal by levels: ");
            bst.levelOrderTraversalByLevels();

        // Call get node level, and getPathToLeafNode(T e)
            System.out.println("The level of node G is: "+bst.getNodeLevel("G"));
            System.out.println("The path to leaf node 'G': "+bst.getPathToLeafNode("G"));

        //	Call search() and show output of search result (if exist, and how many instances)
            String elem = "G";
            boolean search = bst.search(elem);
            if (search)
                System.out.println(bst.getPathToLeafNode("G")+ " Element " + elem+" Found");
            else
                System.out.println(elem+" Not Found");

        //	Call deleteOneInstanceIfMultiple() and show effect on the tree


        //	Call deleteByCopying() for an item with one instance and show your code generate exception message
            try {
                bst.deleteByCopying(new BST<String>(new BTNode<>("G")).root.data);
            }
            catch (NullPointerException e){
                    System.out.println(e);
            }


        //	Call deleteByCopying() for an item with multiple instances and show effect on the tree

            bst.deleteByCopying(elem);
            System.out.println("Tree after deleting "+ elem + " using delete by copying");
            bst.printTree();

    }
}