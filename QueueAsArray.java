// ID: 202154790 Name: Jalal Zainaddin

import java.util.Stack;

// Java program to implement a queue using an array
public class QueueAsArray<T extends Comparable<T>>{
    private int front, rear, capacity;
    private T[] queue;

    public QueueAsArray(int capacity) {
        front = rear = -1;
        this.capacity = capacity;
        queue = (T[]) new Comparable[capacity];
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
        // if queue is empty:
        if(isEmpty()){
            front++;
            rear++;
            queue[rear] = data;
        }
        else{
            // create two primary local stacks to move queue elements
            Stack<T> s1 = new Stack<>();
            Stack<T> s2 = new Stack<>();
            // if queue is not empty, we have three conditions:
            //1- if the front is bigger than the data provided, we just have to dequeue() all elements to s1 then to s2 to be sorted,
            //then add the data to the front, then enqueue the rest of s2
            if (queue[front].compareTo(data) == 1){
                while(!isEmpty()){
                    s1.push(dequeue());
                }
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                front++;
                rear++;
                queue[rear] = data;
                while(!s2.isEmpty()){
                    rear++;
                    queue[rear] = s2.pop();
                }
            }
            //2- if the last element of queue is less than data, just add it to the end
            else if (queue[rear].compareTo(data) == -1) {
                rear++;
                queue[rear] = data;
            }
            //3- else if it is in between, we have to create two additional stacks, because s1 will hold the value that is smaller the data,
            // and s2 holds the data that is bigger than the data, then we use s3 (s1 in correct order) and s4 (s2 in ...)
            // then we enqueue all the elements of s3, then we add the data, and lastly, we add all element of s4 into the queue
            else{
                // initialize s3 (for s1) and s4 (for s2)
                Stack<T> s3 = new Stack<>();
                Stack<T> s4 = new Stack<>();
                while(!isEmpty()){
                    // compare the first element
                    T frontElem = dequeue();
                    // if it's less than data, push it to s1
                    if (frontElem.compareTo(data) == -1){
                        s1.push(frontElem);
                    }
                    // if it's bigger than the data, push it to s2
                    else {
                        s2.push(frontElem);
                    }
                }
                // push all element of s1 to s3 to make it add to the queue in correct order
                while(!s1.isEmpty()){
                    s3.push(s1.pop());
                }
                // push all element of s2 to s4 to make it add to the queue in correct order
                while(!s2.isEmpty()){
                    s4.push(s2.pop());
                }
                // addition of values lower than data
                front++;
                while(!s3.isEmpty()){
                    rear++;
                    queue[rear] = s3.pop();
                }
                // the addition of the new data itself
                rear++;
                queue[rear] = data;
                // addition of the values bigger than data
                while (!s4.isEmpty()){
                    rear++;
                    queue[rear] = s4.pop();
                }
            }
        }



    }

    public T dequeue() {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");
        T temp = queue[front];
        if (rear == 0) {
            rear = front = -1;
        }
        else{
            for(int i = 0; i <= rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        }
        return temp;
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