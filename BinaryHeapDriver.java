import java.util.Arrays;
public class BinaryHeapDriver
{
        public static void main(String[] args) {
                Integer[] array = {10, 2, 8, 9, 1, 6, 3, 4, 0, 5};
                System.out.println("The original array is: "+Arrays.toString(array));
                BinaryHeap binaryHeap = new BinaryHeap(array);
                //builds heap bottom up: change the constructor to build it top-down
                System.out.println("The min-heap is: " + binaryHeap);
                System.out.println("The sorted array is: " + Arrays.toString(binaryHeap.heapSort()));
        }
}