import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>>
{
    private T[] array;
    private int size;
    private int capacity;

    public BinaryHeap(){
        this(50);
    }

    public BinaryHeap(int capacity)
    {
        this.capacity = capacity;
        size = 0;
        array = (T[]) new Comparable[this.capacity + 1];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull()
    {
        return size == array.length - 1;
    }

    public BinaryHeap(T[] comparable)
    {
        this(comparable.length);

        for(int i = 0; i < comparable.length; i++)
            array[i + 1] = comparable[i];

        size = comparable.length;

//        buildHeapTopDown(); //part of  Task01
        buildHeapBottomUp();
    }

    private void buildHeapBottomUp()
    {
        // Task01
        // we take the last non-terminal node to start from down to up
        for (int i = size/2; i >=1; i--) {
            percolateDown(i);
        }
    }

    private void buildHeapTopDown()
    {
        // Task02
        // we take the root node to start from up to down
        for (int i = 1; i <=size ; i++) {
            percolateUp(i);
        }
    }

    private void percolateDown(int index)
    {
        // Task01

        // assign the index of a next child node
        int nextChild;
        // store the key of given child
        T temp = array[index];
        for (; index*2 <= size; index = nextChild){
            // assign it to the index of next child
            nextChild = index*2;
            // we check if the right of the next child exists to compare between the siblings
            if (nextChild != size && array[nextChild + 1].compareTo(array[nextChild])<0)
                //go to right sibling
                nextChild++;
            // compare between right child and its parent, if it's less, swap them
            if (array[nextChild].compareTo(temp) <0)
                array[index] = array[nextChild];
            else
                break;

        }
        // end of swapping
        array[index] = temp;
    }

    private void percolateUp(int index){
        // Task01

        // check if index is still not at root and compare if the parent is less than child
        if (index > 1 && array[index].compareTo(array[index/2] )< 0)
        {
            // swap between them
            T temp = array[index];
            array[index] = array[index/2];
            array[index/2] = temp;

            // go to the next child
            index = index/2;
            percolateUp(index);
        }
    }


    public void purge()
    {
        while(size > 0)
            array[size--] = null;
    }

    public void enqueue(T comparable)
    {
        int index = ++size;

        // percolate up via a hole
        while(index > 1 && array[index / 2].compareTo(comparable) > 0)
        {
            array[index] = array[index / 2];
            index = index / 2 ;
        }

        array[index] = comparable;
    }

    public T findMin()
    {
        return array[1];
    }

    public T  dequeueMin()
    {
        T  minItem = array[1];
        array[1] = array[size];
        size--;
        percolateDown(1);
        return minItem;
    }

    public T[] heapSort() {
        T[] x = (T[]) new Comparable[size];
        int total = size;
        for(int i = 0; i < total; i++) {
            x[i] = dequeueMin();
        }
        return x;
    }
    public String toString(){
        if(size == 0)
            return "[ ]";

        String str = "[";
        int k;
        for(k = 1; k <= array.length - 2; k++)
            str += array[k] + ", ";

        str += array[k] + "]";

        return str;

    }
}