package Queues;

import java.util.Queue;
import java.util.Stack;

public class CommonQuestions {

    // Reversing a queue using a Stack
    public static void reversingQueue(Queue<Integer> queue) {
        Stack<Integer> queueStack = new Stack();

        while(!queue.isEmpty()) {
            queueStack.add(queue.remove());
        }

        while(!queueStack.isEmpty()) {
            queue.add(queueStack.pop());
        }
    }

}
