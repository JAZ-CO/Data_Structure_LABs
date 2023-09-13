// Name, ID, Section Number, Date
// Jalal Zainaddin, s202154790, 54, 09/03/2023

//**************************  SLL.java  *********************************
//           a generic singly linked list class

public class SLL<T> {

    private class SLLNode<T> {
        private T info;
        private SLLNode<T> next;
        public SLLNode() {
            this(null,null);
        }
        public SLLNode(T el) {
            this(el,null);
        }
        public SLLNode(T el, SLLNode<T> ptr) {
            info = el; next = ptr;
        }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info;
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    @Override
    public String toString() {
        if(head == null)
            return "[ ]";
        String str = "[ ";
        SLLNode<T> tmp = head;
        while(tmp != null){
            str += tmp.info + " ";
            tmp = tmp.next;
        }
        return str+"]";
    }

    public boolean contains(T el) {
        if(head == null)
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
            if(tmp.info.equals(el))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public int size(){
        if(head == null)
            return 0;

        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
            count++;
            p = p.next;
        }

        return count;
    }

    //  Please write the methods of Task02 here:

    // insertBefore method:

    public void insertBefore(int index, T newElem) throws IndexOutOfBoundsException{

        // throw the exception when the index is too big or below zero or the list is empty
        if (this.isEmpty() || index >= this.size() || index <0){
            throw new IndexOutOfBoundsException();
        }

        // create the new node, the one that contains the value passed
        SLLNode<T> temp = new SLLNode<>(newElem);

        // first case: place it before the node at index 0:
        if (index ==0){
            temp.next = head;
            head = temp;
        }
        // second case: place it before the last node:
        else if (index == this.size() -1) {
            T prevInfo = tail.info;
            tail.info = newElem;
            tail.next = new SLLNode<>(prevInfo);
            tail = tail.next;
        }
        // third case: place it between other places:
        else {
            // creating next head node that is used to iterate throw nodes
            SLLNode<T> nextHead = head;
            for (int i = 0; i < index-1; i++) {
                nextHead = nextHead.next;
            }

            temp.next = nextHead.next;
            nextHead.next = temp;

        }

    }

    // delete Method
    public T  delete(int  index) throws IndexOutOfBoundsException{
        // throw the exception when the index is too big or below zero or the list is empty
        if (this.isEmpty() || index >= this.size() || index <0){
            throw new IndexOutOfBoundsException();
        }
        // create the variable that holds the info of the deleted node (to return it)
        T prevInfo;
        SLLNode<T> nextHead = head;

        // delete element at index 0
        if (index == 0){
            prevInfo = head.info;
            head = head.next;

        }
        // other cases
        else{
            for (int i = 0; i < index - 1; i++) {
                nextHead = nextHead.next;
            }
            prevInfo = nextHead.next.info;
            nextHead.next = nextHead.next.next;
        }
        return prevInfo;
    }

    // insert after second occurrence
    public  void  insertAfterSecondOccurrence(T  e1,  T   e2) throws NullPointerException{
        // creating count, and three nodes: 1- new node 2- next head node, previous head node
        int count=0;
        SLLNode<T> temp = new SLLNode<>(e1);
        SLLNode<T> nextHead = head;
        SLLNode<T> prevHead = new SLLNode<>();
        if (this.isEmpty() || this.size() < 2 ) {
            throw new IndexOutOfBoundsException();
        }
            while (count <2){
            if (nextHead.info.equals(e2)){
                count++;
            }

            if (nextHead.next != null){
                prevHead = nextHead;
                nextHead = nextHead.next;

            } else if (nextHead.next == null && count ==2) {


            } else if (nextHead.next == null ) {
                throw new NullPointerException();
            }
        }

        if (nextHead.info.equals(e2)){

            tail.next = new SLLNode<>(e1);
            tail = tail.next;
        }
        else {
            prevHead.next = temp;
            temp.next = nextHead;
        }

    }


}