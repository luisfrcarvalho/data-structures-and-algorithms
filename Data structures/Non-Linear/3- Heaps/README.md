# Heaps (Binary Trees)

- A special type of tree
- **Complete Tree**: Every level, except potentially the last level, is completely filled, and levels are filled from the left to right.
- The **value** of every node is greater than or equal to his children. (**HEAP Property**).
- A heap is a complete binary tree, which satisfies the HEAP property.

- **Max Heap**: Root node holds the largest value. Going down on the heap, means find low values.
- **Min Heap**: Root node holds the smallest value. Goind down on the heap, means find large values.

- We can use them for:
    - Sorting (HeapSort)
    - Graph Algorithms (shortest path)
    - Priority queues
    - Find the kth smallest/largest value (Very common question on interviews)

- **Bubble up**: the node moves up, becomes the parent of his parent
- **Bubble down**: the node moves down, becomes the children of his children

- In **max heaps**, large values will bubble up till the top. The opposite happens on the **min heaps**.

- Time complexity
    - ***Insertion***: 
        - O(log n), in the worst case the inserted value will bubble up until the top, which means the height (worst case) of the tree.
    - ***Deletion***: 
        - In heaps, we only can delete the root node, not one of the inner nodes.
        - O(log n), same as Insertion. However, it requires bubbling down.
    - ***MaxValue***: O(1), just get the root node value

- Since the Heaps are complete trees and they don't have holes, we can use arrays.

- **Important**
    * One of the applications of heaps, is to sort data. We add all the values to the heap and popping the values from the heap, they will come down in descending order. (Using Max Heap);

    * Queues can be implemented using Heaps. It'll improve the insertion operation from O(n) to O(log n). However, deletions will decrease their performance from O(1) to O(log n).

- ***Common interview questions***
    - **Heapify**: Taking an array and apply the heap property on it;

- **Note**: 
    - Mathematically, we can prove that in a perfect binary Tree half of the nodes are in the last level.
    - Heap do not support looking up values, because of how the nodes are structured. They only allow inspecting the maximum or minimum value, depending on the type of the heap.