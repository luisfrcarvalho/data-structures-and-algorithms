package Queues;

import java.util.Arrays;

// Objects are processed based on their priority not in the order they joined the queue.
// High priority means high value in this case
public class PriorityQueue {

    private int[] items;
    private int count;

    public PriorityQueue(int size) {
        this.items = new int[size];
        this.count = 0;
    }

    public void enqueue(int item) {
        if(count == items.length)
            throw new IllegalStateException();

        items[shiftItems(item)] = item;
        count++;
    }

    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        int value = items[--count];
        items[count] = 0;
        return value;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == items.length;
    }

    private int shiftItems(int item) {
        int i;
        for(i = count - 1; i >= 0; i--) {
            if(items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
