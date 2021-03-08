package com.example.javaprograms;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value){
        if (isFull())
            throw  new IllegalStateException();

        items[size++] = value;

        bubbleUp();

    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public boolean isFull(){
        return size == items.length;
    }

    public void remove(){
        if (isEmpty())
            throw new IllegalStateException();

        items[0] = items[size -1];
        size--;

        int index = 0;
        while (index <= size && !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);

            swap(index, largerChildIndex);

            index = largerChildIndex;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int largerChildIndex(int index){
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return Math.max(leftChildIndex(index), rightChildIndex(index));
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;

        boolean isValid = items[index] >= leftChild(index);

        if (!hasRightChild(index))
            return isValid &= isValid & items[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index){
        return (index * 2) + 2;
    }

    private void bubbleDown() {
    }
}
