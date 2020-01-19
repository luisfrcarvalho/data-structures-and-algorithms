package Algorithms;

public class SearchingAlgorithms {

    public static int linearSearch(int[] array, int value)  {
        for(var i= 0; i < array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int value, int front, int back) {
        if(front > back)
            return -1;

        var middle = (front + back) / 2;

        if(array[middle] < value) {
            return binarySearch(array, value, middle + 1, back);
        }

        if(array[middle] > value) {
            return binarySearch(array, value, front, middle - 1);
        }

        return middle;
    }

    public static int binarySearchIterative(int[] array, int value) {
        var front = 0;
        var back = array.length - 1;

        while(front <= back) {
            var middle = (front + back) / 2;

            if(array[middle] < value) {
                front = middle + 1;
                continue;
            }

            if(array[middle] > value) {
                back = middle - 1;
                continue;
            }

            return middle;
        }

        return -1;
    }

    public static int ternarySearch(int[] array, int value) {
        return ternarySearch(array, value, 0, array.length - 1);
    }


    private static int ternarySearch(int[] array, int value, int left, int right) {
        if(left > right)
            return -1;

        int partitionSize = (right-left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if(array[mid1] == value) {
            return mid1;
        }

        if(array[mid2] == value) {
            return mid2;
        }

        if(value < array[mid1]) {
            return ternarySearch(array, value, left, mid1 - 1);
        }

        if(value > array[mid2]) {
            return ternarySearch(array, value, mid2 + 1, right);
        }

        return ternarySearch(array, value, mid1 + 1, mid2 - 1);
    }

    public static int jumpSearch(int[] array, int value) {
        var blockSize = (int) Math.sqrt(array.length);
        var start = 0;
        var next = start + blockSize;

        while(start < array.length && array[next - 1] < value) {
            start = next;
            next += blockSize;
            if(next > array.length) {
                next = array.length;
            }
        }

        for(var i = start; i < next; i++)
            if(array[i] == value)
                return i;

        return -1;
    }

    public static int exponentialSearch(int[] array, int value) {
        var bound = 1;

        while (bound < array.length && array[bound] < value) {
            bound *= 2;
        }

        var lowerBound = bound / 2;
        var upperBound = Math.min(bound, array.length); // To prevent cases where the boundary is higher than array.length

        return binarySearch(array, value, lowerBound, upperBound);
    }
}
