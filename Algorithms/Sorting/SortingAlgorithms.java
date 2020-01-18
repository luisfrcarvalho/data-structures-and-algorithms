package Algorithms;

import java.util.*;

public class SortingAlgorithms {

    public static String bubbleSort(int[] array) {
        boolean isSorted;
        for(var i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if(array[j] < array[j - 1]) {
                    var temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }

            if(isSorted)
                break;
        }
        return Arrays.toString(array);
    }

    public static String selectionSort(int[] array) {
        for(var i = 0; i < array.length; i++) {
            var minimumIndex  = i;

            for(var j = i; j < array.length; j++) {
                if(array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            var temp = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = temp;
        }

        return Arrays.toString(array);
    }

    public static String insertionSort(int[] array) {
        // Starting at one because the first item is always in the right position
        for(var i = 1; i < array.length; i++) {
            var value = array[i];
            var j = i - 1;

            while(j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }

        return Arrays.toString(array);
    }

    public static void mergeSort(int[] array) {
        if(array.length < 2)
            return;

        // Divide the array into half
        var middle = array.length / 2;
        int[] left = new int[middle];
        for(var i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for(var j = middle; j < array.length; j++)
            right[j - middle] = array[j];

        // Sort
        mergeSort(left);
        mergeSort(right);

        // Merge
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while(i < left.length) {
            result[k++] = left[i++];
        }

        while(j < right.length) {
            result[k++] = right[j++];
        }

    }

    public static void quickSort(int[] array) {
        quickSort(array, 0 , array.length - 1);
    }


    private static void quickSort(int[] array, int start, int end) {
        if(start >= end)
            return;

        var boundary = partitioning(array, start, end);

        quickSort(array, start, boundary - 1); // left
        quickSort(array, boundary + 1, end); // right
    }


    private static int partitioning(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;

        for(int i = start; i <= end; i++) {
            if(array[i] <= pivot) {
                var temp = array[++boundary];
                array[boundary] = array[i];
                array[i] = temp;
            }
        }
        return boundary;
    }


    public static void countingSort(int[] array, int max) {
        int[] counts = new int[max + 1];

        for(var item: array)
            counts[item]++;

        var k = 0;
        for(var i = 0; i < counts.length; i++) {
            for(var j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }

    }

    public static void bucketSort(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for(var i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for(var item : array) {
            var bucketNumber = item / numberOfBuckets;
            buckets.get(bucketNumber).add(item);
        }

        var i = 0;
        for(var bucket : buckets) {
            Collections.sort(bucket);
            for(var item : bucket) {
                array[i++] = item;
            }
        }

    }


}
