package com.example.javaprograms;

public class MaxHeap {
    public static void heapify(int[] array){
        //for better optimization we can:
        //end the iteration at the last parent node
        //and to reduce recursions we can start from the last parent node going up
        int lastParent = (array.length / 2) - 1;
        for (int i = lastParent; i >= 0; i--)
            heapify(array, i);
    }
    private static void heapify(int[] array, int index){
        int largerIndex = index;

        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex < array.length && array[leftChildIndex] > array[index])
            largerIndex = leftChildIndex;

        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex < array.length &&array[rightChildIndex] > array[index])
            largerIndex = rightChildIndex;

        if (largerIndex == index)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }
    private static void swap(int[] array, int first, int last){
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }
    public static int getTheKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        Heap heap = new Heap();

        for (int num : array)
            heap.insert(num);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}
