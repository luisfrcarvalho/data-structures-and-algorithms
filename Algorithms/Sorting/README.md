# Sorting

## Comparison Algorithms
- They sort data by comparing items

### Bubble Sort

- The simplest of all sorting algorithms;
- We scan the array from left to right and if items are out of order we swap them;
- At the end of each pass the next largest item bubbles up and moves to its correct position;

**Best case scenario** (Sorted Array): O(n)  
**Worst case scenario**: O(n^2)

### Selection Sort

- Like bubble sort we need multiple passes to sort an array;
- It divides the array into two parts: Sorted and Unsorted;
- It is called Selection Sort because at each pass we get the minimum value from the unsorted part and we move it to the right position;

**Best case scenario** (Sorted Array): O(n^2)  
**Worst case scenario**: O(n^2)

### Insertion Sort

- Basically, every time we get an item you need to insert it in the right position;
- It divides the array into two parts: Sorted and Unsorted;
- Instead of swapping items, we shifted them to the right;

**Best case scenario** (Sorted Array): O(n)  
**Worst case scenario** (Sorted Array in descending order): O(n^2)


### Merge sort

- Divide and conquer algorithm. It divides the array to subs-arrays until they become easy to sort;
- The idea behind Merge sort is to break down  alist into smaller and smaller sub-list, sort those items and merge them back to build a completely sorted list;
- Merge sort allocates additional space;
- We need to be aware that an array with only one item is already sorted;
- This algorithm is faster than the previous. However, it comes with an aditional cost, the cost of allocating additional space.

**Space**: O(n)  
**Best case scenario**: (Sorted Array): O(n * log n)   
**Worst case scenario**: (Sorted Array in descending order): O(n * log n)

### Quick sort

- Unlike merge sort does not need additional space. It can rearrange the array in place;
- We start by choosing an element called the pivot. Then, we starting rearranging the array, so that elements greater than the pivot are on the right side and, smaller elements on the left.
- Typically, we select the last item as a pivot. However, there are many ways to do it, like randomly, etc.
- With a good pivot selection quick sort runs in O(n * log n);
- When we choose a pivot, the pivot after the partitioning will move to his current position;


**Best case scenario** (Pivot is in the middle): O(n * log n)  
**Worst case scenario** (Pivot far from the middle): O(n^2)


## Non-Comparison Algorithms
- They do not use comparisons. They use basic math.

### Counting sort

- Instead of using comparisons, we count occurrences of the items in the input array and, we use that to sort the data;
- K represents the maximum value in the input array;
- Linear time complexity. However, it requires additional space. (Time-memory trade-off)
- We should use it when:
    - Allocating extra space is not an issue;
    - Values are positive integers;
    - Most of the values in the range are present.

**Space**: O(K)  
**Worst case scenario**: O(K + N) => **Linear**


### Bucket sort

- The bucket sort divides the input array into buckets. Each bucket will be sorted using another sorting algorithm. Finally, all buckets will be combined;
- With this approach we sort a smaller array, which is faster;
- **Bucket** = Item / numberOfBuckets
- More buckets, easy to sort, but more space. (Time-memory trade-off)

**Space**: O(K + N) => K number of buckets  
**Best case scenario**: O(K + N) => **Linear**  
**Worst case scenario**: O(K + N^2) => Dependens on which algorithm we choose