# Arrays

- Simplest data structure
- Arrays are used in multiple languages and allow to store a list of items sequentially.
- Calculating the address of an item trough index is really simple => O(1)

## Advantages
- If we want to store a list of items and access them trough index, Arrays are the optimal data structure to do it, since calculating the memory address is very simple.

## Disadvantages
- They're static, which means that we need to specify their size when allocating them. 
- Resize the array means creating a new one, and copy all the elements from the old array to the new one. => O(n).
- Deletion cause sifthing in memory => Worst case scenario O(n).

## Dynamic Arrays
- ArrayList
- In some languages like JS and Python, Arrays are natively dynamic

# Operations

## Insertion
- O(n)

## Delete
- O(n)

## Lookup
- O(1)