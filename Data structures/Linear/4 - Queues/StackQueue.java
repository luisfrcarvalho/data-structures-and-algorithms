package Queues;
import java.util.Stack;

// Implementing a queue using 2 Stacks
public class StackQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    public void enqueue(int value) {
        this.stack1.push(value);
    }

    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        movingStack1toStack2();

        return stack2.pop();
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();

        movingStack1toStack2();

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void movingStack1toStack2() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }

}
