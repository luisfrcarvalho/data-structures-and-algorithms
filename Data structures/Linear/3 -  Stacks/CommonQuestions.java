package Stacks;

import java.util.*;

public class CommonQuestions {

    public static String ReverseString(String input) {
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> reversed = new Stack();
        for(char ch : input.toCharArray())
            reversed.push(ch);

        // Since Strings are immutable in Java, if we have a string with a million of characters,
        // We should use the String Buffer Class, because it's optimized for string manipulation.
        // So, in order to our algorithm be scalable we should use StringBuffer
        // NOTE: Every time we modify a String, a new string object is created in memory.
        // String result = "";
        StringBuffer result = new StringBuffer();

        while(!reversed.empty())
            result.append(reversed.pop());

        return result.toString();
    }
    // If it's an opening bracket, we push it to the stack
    // If it's a closing bracket, we pop from the stack and check if they closing and opening match
    // NOTE: Very simple implementation, adding other types of brackets jus needs more validation
    public static boolean BalancedExpression(String input) {
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack();
        for(char ch : input.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else if (ch == ')'){
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                continue;
            }
        }

        return stack.empty();
    }


}
