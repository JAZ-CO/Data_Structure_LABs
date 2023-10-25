import java.util.Scanner;

public class AVLTreeDriver {
        public static void main(String[] args) {
//                System.out.println("\nSINGLE LEFT ROTATION EXAMPLE: ");
//                System.out.println("Insert 45 in the following AVL tree:");
//                AVLTree<Integer> avlTree2 = new AVLTree<Integer>();
//
//                Integer[]  array1 = new Integer []{30, 5, 35, 32, 40};
//                for(int i = 0; i < array1.length ; i++)
//                        avlTree2.insertAVL(array1[i]);
//                avlTree2.printTree();
//                System.out.println("\nInsertion result: ");
//                avlTree2.insertAVL(45);
//                System.out.println();
//                avlTree2.printTree();
                //========================= TASK01=========================================
                AVLTree<Integer> avlTree3 = new AVLTree<Integer>();
                Integer[]  array2 = new Integer []{5, 2, 7, 1, 4,6,9,3,16};
                for(int i = 0; i < array2.length ; i++)
                        avlTree3.insertAVL(array2[i]);
                System.out.println("Tree 3:");
                avlTree3.printTree();
                System.out.println("Insert 15");
                avlTree3.insertAVL(15);
                avlTree3.printTree();



                //================================ TASK02 ================================
                AVLTree<Integer> avlTree4 = new AVLTree<Integer>();
                Integer[]  array3 = new Integer []{7,2,15,1,3,10,17,5,9,13,18,11};
                for(int i = 0; i < array3.length ; i++)
                        avlTree4.insertAVL(array3[i]);
                System.out.println("Tree 4");
                System.out.println("Delete 1 in the following AVL tree:");
                avlTree4.printTree();
                System.out.println("Deletion Result");
                avlTree4.deleteAVL(1);
                avlTree4.printTree();
                //=============================== TASK03 =====================================
                Scanner input = new Scanner(System.in);
                AVLTree<Integer> avlTree5 = new AVLTree<Integer>();
                Integer[]  array4 = new Integer []{32,26,54,14,30,44,27};
                for(int i = 0; i < array4.length ; i++)
                        avlTree5.insertAVL(array4[i]);
                System.out.println("Tree 5");
                System.out.println("Insert the required maximum key in the following AVL tree:");
                avlTree5.printTree();

                avlTree5.insertAVL(input.nextInt());
                avlTree5.balance();
                System.out.println("Insertion result");
                avlTree5.printTree();




                //================================= TASK04 =====================================

        }
}