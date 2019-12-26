package Heaps;

import java.util.Arrays;

public class CommonInterviewQuestions {
    // Starting from the deepest parent nodes to the root
    public static void heapify(int[] array) {
        var lastParent = array.length/ 2 - 1;

        for(var index = lastParent; index >= 0; index--) {
            if(isValidParent(array, index))
                continue;
            else {
                bubblingDown(array, index);
            }

        }
        System.out.println(Arrays.toString(array));
    }

    public static int greatestKthList(int[] array, int k) {
        if(k < 1 || k > array.length) {
            throw new IllegalStateException();
        }

        var heap = new Heap();
        for(var number: array)
            heap.insert(number);

        for(var i = 0; i < k - 1; i++) {
            heap.remove();
        }
        System.out.println(heap.max());
        return heap.max();
    }

    private static void bubblingDown(int[] array, int index) {
        if(index < 0)
            return;

        var largerIndex = index;

        if(hasLeftChild(array, index)) {
            var leftChildIndex = getLeftChild(array, index);
            largerIndex = array[leftChildIndex] > array[largerIndex] ? leftChildIndex : largerIndex;
        }

        if(hasRightChild(array, index)) {
            var rightChildIndex = getRightChild(array, index);
            largerIndex = array[rightChildIndex] > array[largerIndex] ? rightChildIndex : largerIndex;
        }

        if(index == largerIndex) {
            return;
        }

        swap(array, index, largerIndex);
        bubblingDown(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[second];
        array[second] =  array[first];
        array[first] = temp;
    }

    private static int getParentIndex(int index) {
        return  (index - 1) / 2;
    }

    private static boolean isValidParent(int[] array, int index) {
        if(!hasLeftChild(array, index))
            return true;

        var isValid = array[getLeftChild(array, index)] <= array[index];

        if(hasRightChild(array,index))
            isValid &= array[getRightChild(array, index)] <= array[index];

        return isValid;
    }

    private static int getLeftChild(int[] array, int index) {
        return index * 2 + 1;
    }

    private static int getRightChild(int[] array, int index) {
        return index * 2 + 2;
    }

    private static boolean hasLeftChild(int[] array, int index) {
        return getLeftChild(array, index) < array.length;
    }

    private static boolean hasRightChild(int[] array, int index) {
        return getRightChild(array, index) < array.length;
    }
}
