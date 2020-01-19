# Searching

## Linear Search

- The simplest searching algorithm;
- Iterate over a list, inspect each item, if we find the item we return the index. Otherwise, we return a negative value;
- Works well dealing with small lists; 

**Best case scenario**: O(1) => Item at the beginning of the list <br>
**Worst case scenario**: O(n) => Item does not exist or it's at the end of the list

## Binary Search

- Only works on sorted lists;
- Divide and Conquer algorithm;
- At every step, we calculate the middle value, and we cut down the number of items by half;
- **Middle index**:*(front + back) / 2*

**Time Complexity**: O(log n)
**Space Complexity**: 
    - Recursive: O(log2 n)
    - Iterative: O(1)

- It does not mean that iterative implementation is better because requires less space. The extra space that we need in the recursive implementation is way smaller. **Log 1.000.000 = 19**

## Ternary Search

- Only work on sorted lists;
- Divide an conquer algorithm;
- Instead of dividing the list in two halfs like Binary Search, we divide the list in three parts;
- **PartitionSize** = *(left + right) / 3*
- **Mid1**  = *left + partitionSize*
- **Mid2** = *right - partitionSize*

**Time Complexity**: O(log3 n)
**Space Complexity**: 
    - Recursive: O(log n)
    - Iterative: O(1)

- Binary search is faster than Ternary search (Lots of comparisons).
- As we divide our array into more parts, our search algorithm gets slower. As we increase the number of parts, the time complexity moves forward to linearity.

## Jump Search

- Improvement to linear search;
- Requires a sorted array;
- We divide the list into a few blocks, and instead of checking every item, we jumped to the block where the target item may exist. That's we call this algorithm jump search.

**Time Complexity**: O(root(n))

- **Number of blocks**: *root(n)*

- It uses two points. One that represents the start of the current block, and others that determines the start of the next block.

## Exponential Search

- Start with a small range and see if the target item is in that range or not. If not, then we double the range at each step. Once we find a range where the target item might exist in, we will do a binary search in that range.

**Time Complexity**: O(log i) => di number of the uperbound