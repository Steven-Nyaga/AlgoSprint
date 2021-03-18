package com.example.javaprograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class StringManipulation {
    public static int countVowels(String s){
        int count = 0;
        for (char ch : s.toLowerCase().toCharArray()){
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }

        return count;
    }

    public static String reverseString(String s){
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }

    public static String reverseWords(String s){
        String[] words = s.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
