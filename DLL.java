// id: 202154790 , sec: 54

//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
            return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
            head = new DLLNode<T>(el,head,null);
            head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
            tail = new DLLNode<T>(el,null,tail);
            tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }
    public void printAll() {
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
            return null;
        else return tmp.info;
    }

    // Excercises method below
    public void printReverse(){
        // we took the tail and print its previous info until its null
        DLLNode<T> tailCopy = tail;
        while(tailCopy != null){
            System.out.print(tailCopy.info + " ");
            tailCopy = tailCopy.prev;
        }
        System.out.println();
    }
    public void delete7(){
        /* In order to delete the 7th occurence each time, we have to specify three variables:
        * 1- count: this variables objective is to count the steps until it reaches the 7th, which helps to stop the loop.
        * 2- reverse: this is a boolean variable that helps to swich the direction of iteration, if it is false, we iterate
        * from head to tail, if true, we iterate from tail to head.
        * 3- headCopy: this is a reference to the head of the list, we use it to iterate by going to next or previouis
        *
        * after counting operations using while loop, we go through multiple of conditions before deleting the 7th element */

        int count =2;
        boolean reverse = false;
        DLLNode<T> headCopy = head;
                if (headCopy.next == null){
                    head = null;
                }
                else {
                    while (count != 7 && !this.isEmpty()) {
                        if (headCopy.next != null & !reverse) {
                            headCopy = headCopy.next;
                            count++;
                        } else if (headCopy.next == null) {
                            reverse = true;
                        }
                        if (headCopy.prev != null & reverse) {
                            headCopy = headCopy.prev;
                            count++;
                        } else if (headCopy.prev == null) {
                            reverse = false;
                        }
                    }
                    if (!reverse) {
                        if (headCopy.next != null) {
                            headCopy.next = headCopy.next.next;
                        } else {
                            if (headCopy.prev != null) {
                                if (headCopy.prev.prev == null) {
                                    this.deleteFromHead();
                                } else {
                                    headCopy.prev = headCopy.prev.prev;
                                    headCopy.prev.next = headCopy;
                                }
                            }
                        }

                    } else {
                        if (headCopy.prev != null) {

                            if (headCopy.prev.prev == null) {
                                this.deleteFromHead();
                            } else {
                                headCopy.prev = headCopy.prev.prev;
                                headCopy.prev.next = headCopy;
                            }
                        }
                    }
                }
    }
    public void insertAlternate(DLL<T> newList){

        /* In order to insert the second list elements between the first list, we created a new DLL list,
        * add the element from first list by adding to tail, then we add second element from second list, then iterate the two,
        * after that, we delete every element from list1, then copy new DLL list to list1*/

        DLL<T> newDll = new DLL<>();

        DLLNode<T> firstHead = this.head;
        DLLNode<T> secondHead = newList.head;

        while (firstHead != null || secondHead != null) {
            if (firstHead != null) {
                newDll.addToTail(firstHead.info);
                firstHead = firstHead.next;
            }
            if (secondHead != null){
                newDll.addToTail(secondHead.info);
                secondHead = secondHead.next;
        }
        }

        while(this.head != null){
            this.deleteFromTail();

        }
        DLLNode<T> newHead = newDll.head;
        while (newHead != null){
            this.addToTail(newHead.info);
            newHead = newHead.next;
        }

        this.printAll();


    }
}
//****************************  DLLNode.java  *******************************
//                  node of generic doubly linked list class

class DLLNode<T> {
    public T info;
    public DLLNode<T> next, prev;
    public DLLNode() {
        next = null; prev = null;
    }
    public DLLNode(T el) {
        info = el; next = null; prev = null;
    }
    public DLLNode(T el, DLLNode<T> n, DLLNode<T> p) {
        info = el; next = n; prev = p;
    }
}
