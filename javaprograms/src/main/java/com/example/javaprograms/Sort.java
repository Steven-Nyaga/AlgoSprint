package com.example.javaprograms;

public class Sort {
    public void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 1; j < array.length; j++){
                if (array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
            }
        }
    }
    private void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < minIndex){
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }
}
