package Queues;
import java.util.Arrays;

// Implementing a queue using a circular array
public class ArrayQueue {

    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int size) {
        this.items = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    public void enqueue(int value) {
        if(this.count == this.items.length) {
            throw new IllegalStateException();
        }

        this.items[rear] = value;
        this.rear = (this.rear + 1) % this.items.length; // Mapping the value considering the array size
        this.count++;
    }

    public int dequeue() {
        int item = items[this.front];
        this.items[this.front] = 0;
        this.front = (this.front + 1) % this.items.length; // Mapping the value considering the array size
        this.count--;
        return item;
    }


    public int peek() {
        return this.items[this.front];
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.items);
    }
}
