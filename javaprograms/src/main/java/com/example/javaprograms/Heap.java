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

}
