// ID: 202154790 Name: Jalal Zainaddin
public class QueueAsArrayDriver {
    public static void main(String[] args)  {
        QueueAsArray<Integer> q = new QueueAsArray<Integer>(8);
        // 30, 60, 40, 70, 50, 35, 10, 80
        q.enqueue(30);
        q.enqueue(60);
        q.enqueue(40);
        q.enqueue(70);
        q.enqueue(50);
        q.enqueue(35);
        q.enqueue(10);
        q.enqueue(80);

        System.out.println("The min priority-queue is: "+q);
        System.out.println("First element to be dequeued: " + q.dequeue());
        System.out.println("Second element to be dequeued: " + q.dequeue());
        System.out.println("The modified min priority-queue is: " + q );
    }
}