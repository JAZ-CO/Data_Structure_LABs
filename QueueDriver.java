public class QueueDriver {
    public static void main(String[] args) {
        QueueAsArray<Integer> queue = new QueueAsArray<>(5);
        // 60   20   40   30   70
        queue.enqueue(60);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println(queue);
        System.out.println("First dequeued element is: "+ queue.dequeue());
        System.out.println("Second dequeued element is: "+ queue.dequeue());
        System.out.println("After two node deletion the queue is:" + queue);
        System.out.println("Element at queue front is: " + queue.peek());

    }
}
