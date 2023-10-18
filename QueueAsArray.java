// Java program to implement a queue using an array
public class QueueAsArray<T> {
    private int front, rear, capacity;
    private T[] queue;

    public QueueAsArray(int capacity) {
        front = rear = -1;
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return rear == capacity - 1;
    }

    // function to insert an element at the rear of the queue
    public void enqueue(T data)  {
        if (isFull())
            throw new UnsupportedOperationException("Queue is full!");
        if(isEmpty())
            front++;

        rear++;
        queue[rear] = data;
    }

//    public T dequeue() {
//        // queue is empty
//        if (isEmpty())
//            throw new UnsupportedOperationException("Queue is empty!");
//        // store the first element
//        T temp = queue[front];
//        // if the queue has only one element
//        if (rear == 0) {
//            rear = front = -1;
//        }
//
//        else{
//            // shift all elements to the left
//            for(int i = 0; i <= rear - 1; i++) {
//                queue[i] = queue[i + 1];
//            }
//            // decrease rear by one to match the index of the last element
//            rear--;
//        }
//        // return the stored value of the previous element in first position
//        return temp;
//    }
    public T dequeue(){
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");
        T temp = queue[front];
        if(rear == 0){
            front = rear = -1;
            return temp;
        }
        T deletedElem = queue[front];
        dequeue(0);
        rear--;
        return deletedElem;
    }
    private void dequeue(int idx){
        if (idx == rear)
            return;
        queue[idx] = queue[idx + 1 ];
        idx++;
        dequeue(idx);
    }


    public boolean search(T e){
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        for(int i = 0; i <= rear; i++)
            if(e.equals(queue[i]))
                return true;

        return false;
    }

    public String toString()  {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        String str = "";
        for (int i = 0; i <= rear; i++) {
            str = str + queue[i] + "   ";
        }

        return str;
    }

    public  T peek() {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        return queue[front];
    }
}