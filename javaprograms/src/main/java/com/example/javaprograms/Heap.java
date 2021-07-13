package com.example.javaprograms;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;

        int index = size - 1;

        bubbleUp(index);
    }

    public boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp(int index) {
        while (index > 0 && items[index] > items[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int value = items[0];
        items[0] = items[--size];

        int index = 0;

        bubbleDown(index);

        return value;
    }

    private void bubbleDown(int index) {
        while (index <= size && !isValid(index)){
            int largerIndex = getLargerIndex(index);
            swap(index, largerIndex);
            index = largerIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private boolean isValid(int index) {
        if (!hasLeftChild(index))
            return true;

        if (!hasRightChild(index))
            return items[index] >= leftChild(index);

        return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }

    private int getLargerIndex(int index) {
        //if there is no left child it means the node has no children because in heaps
        //we fill nodes from left to right
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private  boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }
    private  boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    public int[] heapSort(int[] array, Heap heap) {
        for (int num : array)
            heap.insert(num);
        //Descending
//        for (int i = 0; i < array.length; i++)
//            array[i] = heap.remove();

        //Ascending
        for (int i = array.length - 1; i >= 0; i--)
            array[i] = heap.remove();

        return array;
    }

}
