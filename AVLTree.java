public class AVLTree<T extends Comparable<T>> extends BST<T> {

    protected int height;

    public AVLTree() {
        super();
        height = -1;
    }

    public AVLTree(BTNode<T> root) {
        super(root);
        height = -1;
    }

    public void purge(){
        super.purge();
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BTNode<T> node) {
        if(node == null)
            return -1;
        else
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private AVLTree<T> getLeftAVL() {
        AVLTree<T> leftsubtree = new AVLTree<T>(root.left);
        return leftsubtree;
    }

    private AVLTree<T> getRightAVL() {
        AVLTree<T> rightsubtree = new AVLTree<T>(root.right);
        return rightsubtree;
    }

    protected int getBalanceFactor() {
        if(isEmpty())
            return 0;
        else
            return getRightAVL().getHeight() - getLeftAVL().getHeight();
    }

    public void insertAVL(T el){
        super.insert(el);
        this.balance();
    }

    public void deleteAVL(T el) {
        // to be completed by students
        // delete by copy
        deleteByCopying(el);
        // balance the tree after deleting
        balance();
    }

    protected void balance()
    {
        if(!isEmpty())
        {
            getLeftAVL().balance();
            getRightAVL().balance();

            adjustHeight();

            int balanceFactor = getBalanceFactor();

            if(balanceFactor == -2) {
                if(getRightAVL().getBalanceFactor() == 0 && getLeftAVL().getBalanceFactor() == -1)    /// special case
                    rotateRight();
                else if(getLeftAVL().getBalanceFactor() <= 0)
                    rotateRight();
                else
                    rotateLeftRight();
            }

            else if(balanceFactor == 2) {

                if(getRightAVL().getBalanceFactor() == 0)         /// special case that cannot be done
                    rotateLeft();                                /// by double rotations
                else if(getRightAVL().getBalanceFactor() > 0)
                    rotateLeft();
                else
                    rotateRightLeft();
            }
        }
    }

    protected void adjustHeight()
    {
        if(isEmpty())
            height = -1;
        else
            height = 1 + Math.max(getLeftAVL().getHeight(), getRightAVL().getHeight());
    }

    protected void rotateRight() {
        // to be completed by students
        // store right node
        BTNode<T> tempNode = root.right;
        // change the right of the root to left
        root.right = root.left;
        // change the left of the root to its left of the left
        root.left = root.left.left;
        root.right.left = root.right.right;
        // return the original right to be the right of the right root
        root.right.right = tempNode;

        // swap between root data and rights data
        T val = (T) root.data;
        root.data = root.right.data;
        root.right.data = val;

        getRightAVL().adjustHeight();
        adjustHeight();
    }

    protected void rotateLeft() {
//        System.out.println("LEFT ROTATION");
        BTNode<T> tempNode = root.left;
        root.left = root.right;
        root.right = root.left.right;
        root.left.right = root.left.left;
        root.left.left = tempNode;

        T val = (T) root.data;
        root.data = root.left.data;
        root.left.data = val;

        getLeftAVL().adjustHeight();
        adjustHeight();
    }

    protected void rotateLeftRight()
    {
//        System.out.println("Double Rotation...");
        getLeftAVL().rotateLeft();
        getLeftAVL().adjustHeight();
        this.rotateRight();
        this.adjustHeight();
    }

    protected void rotateRightLeft()
    {
//        System.out.println("Double Rotation...");
        // to be completed by students
        // take the right part of the tree and do right rotation
        getRightAVL().rotateRight();
        getRightAVL().adjustHeight();
        // then do left rotation
        this.rotateLeft();
        this.adjustHeight();
    }

    public void levelOrderTraversal(){
        levelOrderTraversal(root);
    }

}