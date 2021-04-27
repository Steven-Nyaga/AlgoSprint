package com.example.javaprograms;

public class Sort {
   public void bubbleSort(int[] array) {
       for (int i = 0; i < array.length; i++) {
           for (int j = 1; j < array.length; j++) {
               if (array[j] < array[j - 1]) {
                   swap(array, j, j-1);
               }
           }
       }
   }

   public void selectionSort(int[] array) {
       for (int i = 0; i < array.length; i++) {
           int minIndex = i;
           for (int j = i; j < array.length; j++) {
               if (array[j] < array[minIndex]){
                   minIndex = j;
               }
           }
           swap(array, minIndex, i);
       }
   }

   public void insertionSort(int[] array) {
       for (int i = 1; i < array.length; i++) {
           int current = array[i];
           int j = i - 1;
           while (j >= 0 && array[j] > current) {
               array[j + 1] = array[j];
               j--;
           }
           array[j + 1] = current;
       }
   }

   public void mergeSort(int[] array) {
       //Base condition
       if (array.length < 2)
           return;

       //Dividing the array into two
       int middle = array.length / 2;
       int[] left = new int[middle];
       for (int i = 0; i < middle; i++)
           left[i] = array[i];

       int[] right = new int[array.length - middle];
       for (int i = middle; i < array.length; i++)
           right[i - middle] = array[i];

       //Sorting each Half
       mergeSort(left);
       mergeSort(right);

       //Merge the result
       merge(left, right, array);

   }

   //Swap effect
   private void swap (int[] array, int first, int last) {
       int temp = array[first];
       array[first] = array[last];
       array[last] = temp;
   }

   //Merge effect
    private void merge(int[] left, int[] right, int[] result) {
       int i = 0, j = 0, k = 0;

       while (i < left.length && j < right.length) {
           if (left[i] <= right[i]) {
               result[k++] = left[i++];
           }else {
               result[k++] = right[j++];
           }
       }

       while (i < left.length) {
           result[k++] = left[i++];
       }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
