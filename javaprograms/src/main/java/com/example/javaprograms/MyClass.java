package com.example.javaprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyClass {
    public static void main (String [] args){
        int[] numbers = {5,3,8,4,1,2,10};
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int num : numbers){
//            minHeap.add(num);
//        }
//        for (int i = 0; i < numbers.length; i++){
//            numbers[i] = minHeap.remove();
//        }
//        System.out.println(Arrays.toString(numbers));
//        MaxHeap.heapify(numbers);
//        System.out.println(Arrays.toString(numbers));

        System.out.println(MaxHeap.getKthLargest(numbers, 2));













//        String military = String.format("%02d:%02d:%02d", 7,25,15);
//        String str1 = String.format("%d", 10);          // Integer value
//        String str2 = String.format("%s", "Amar Singh"); // String value
//        String str3 = String.format("%f", 101.00);       // Float value
//        String str4 = String.format("%x", 101);          // Hexadecimal value
//        String str5 = String.format("%c", 'c');          // Char value
//        System.out.println(str1);
//        System.out.println(str2);
//        System.out.println(str3);
//        System.out.println(str4);
//        System.out.println(str5);
//        System.out.println(military);
    }
}