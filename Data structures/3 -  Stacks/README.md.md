# Stacks

- Allow to: 
    - implement the undo feature
    - build compilers (parssing the syntax of expressions)
    - evaluate expressions (calculator)
    - build navigation (forward/back on browsers)

- Last In First Out (LIFO)
- Wrapper from an array or linked lists. 
- They don't have lookups(ability to search), since they're not really meant for that.

# Operations
- All operations run in O(1) time complexity

## Push 
- Adding elements to a stack

## Pop
- Removing the top element

## Peek
- Getting the top element

## IsEmpty
- Checking if a stack is empty


# Reversing a string
- Easilly resolved with stacks

1. First we put each char of the string in the stack
2. Then since the strings are imutable in c#/java we could not use the String object to store the reverse. We should use a stringbuffer.
    - Imutable means, everytime we declare a string a new array is created to store that string. Adn since arrays are not resizable, during the method we would create a lot of new string objects.
3. Then, we just return stringbufffer.toString();


# Balanced expressions
- "(1+2)"
- For each openning "(" we add it to the stack
- For each closing ")" we pop from the stack
- Return the method stack.empty()
* When popping do not forget to check if the stack is empty

