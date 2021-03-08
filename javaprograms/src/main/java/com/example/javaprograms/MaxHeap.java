package com.example.javaprograms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void heapify(int[] array){
        for (int i = 0; i < array.length; i++){
            heapify(array, i);
        }
    }
    private static void heapify(int[] array, int index){
        int largestVal = index;

        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex < array.length && array[leftChildIndex] > array[largestVal])
            largestVal = leftChildIndex;

        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex < array.length && array[rightChildIndex] > array[largestVal])
            largestVal = rightChildIndex;

        if (index == largestVal)
            return;

        swap(array, index, largestVal);
        heapify(array, largestVal);
    }

    private static void swap(int[] array, int first, int last){
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

    public static int getKthLargest(int[] array, int value){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : array)
            maxHeap.add(num);

        for(int i = 1; i < value; i++){
            maxHeap.remove();
        }

        return maxHeap.peek();
    }
}
