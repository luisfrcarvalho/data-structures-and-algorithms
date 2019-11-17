package Stacks;

import java.util.Arrays;

/**
 * Implementing a Stack using an array
 * However, we can use LinkedLists too
 */
public class Stack_ {

    private int[] items = new int[5];
    private int index;

    public  Stack_() {
        this.index = 0;
    }

    public void push(int value) {
        if(index  == items.length)
            throw new StackOverflowError();

        items[index++] = value;
    }

    public int pop() {
        if(index == 0)
            throw new IllegalStateException();

        return items[index--];
    }

    public int peek() {
        if(index == 0)
            throw new IllegalStateException();

        return items[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0 , index));
    }
}
