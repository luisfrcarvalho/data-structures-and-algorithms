package Heaps;

import java.util.Arrays;

//Since the Heaps are complete trees and they don't have holes, we can use arrays.
// - leftChild = indexParent * 2 + 1
// - rightChild = indexParent * 2 + 2
public class Heap {

    public int[] heap;
    public int count;

    public Heap() {
        this.heap = new int[20];
        this.count = 0;
    }

    public void insert(int value) {
        if(isFull())
            throw new IllegalStateException();

        this.heap[count++] = value;

        bubbleUp(count - 1);
    }

    public void remove() {
        if(isEmpty())
            throw new IllegalStateException();

        this.heap[0] = this.heap[--count];
        bubbleDown(0);
    }

    private void bubbleUp(int index) {
        while(index > 0 && this.heap[getParentIndex(index)] < this.heap[index]) {
            swap(index, getParentIndex(index));
            index =  getParentIndex(index);
        }
    }

    private void bubbleDown(int index) {
        while(index <= count && !isValidParent(index)) {
            var maxChildIndex = largerChildIndex(index);
            swap(index, maxChildIndex);
            index = maxChildIndex;
        }
    }

    public boolean isFull() {
        return this.count == this.heap.length;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    private void swap(int first, int second) {
        var temp = this.heap[second];
        this.heap[second] =  this.heap[first];
        this.heap[first] = temp;
    }

    private int getParentIndex(int index) {
        return  (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    private boolean hasLeftChild(int index) {
        return  getLeftChildIndex(index) < count;
    }

    private boolean hasRightChild(int index) {
        return  getRightChildIndex(index) < count;
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;

        if(!hasRightChild(index))
            return this.heap[getLeftChildIndex(index)] <= this.heap[index];

        return Math.max(this.heap[getLeftChildIndex(index)], this.heap[getRightChildIndex(index)]) <= this.heap[index];
    }

    private int largerChildIndex(int index) {
        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return getLeftChildIndex(index);

        var leftChildIndex = getLeftChildIndex(index);
        var rightChildIndex = getRightChildIndex(index);

        return  this.heap[leftChildIndex] > this.heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }

    public int max() {
        if(isEmpty())
            throw new IllegalStateException();
        return this.heap[0];
    }
}
