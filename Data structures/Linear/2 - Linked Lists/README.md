# Linked lists

- After arrays, they're the mostly used data structures.
- We use linked list to store items sequently. Unlike Arrays they can grow/shrink automatically.
- A linked list consiste a group of nodes disposed in sequence. Each node holds two pieces of data:
    * Value
    * Address to the next node in the list
- First Node: Head | Last Node: Tail
- They're not stored sequently in the memory. They can be all over the place. That's why we need the address to the next node.

# Operations

## Insertion

* Begining - O(1) 
* End - O(1) 
* Middle - O(N)

## Delete

* Begining - O(1) 
* End - O(N) => We can easily get the tail. However, we need to point the tail to the node before the last node.
* Middle - O(N)

## Lookup
// Since the items are not stored sequentally in the memory
* By Value - O(n)
* By Index - O(n)  

# Arrays vs Linked lists

- Arrays are fixed sized. So, if don't know ahead of time the space that we need, we should use dynamic arrays or linked lists.

- Dynamic arrays grow up by 50%-100% when they get full. Sometimes, they can waste memory.

- Linked lists do not waste memory. However, they take more memory because each node needs to store the value of the next node.

- In order to choose one, we need to analyze what we want because there are always tradeoffs.
    - If we need to do insertions - Linked lists
    - Accessing by index  - Arrays

# Types of linked lists

- Single 
    - Value
    - Next node
- Doubly
    - value
    - Next node
    - Previous node

* They can be circular, last node pointing to the first node.


# Reversing a linked list and Kth node from the end
 
- Commonly used on interviews