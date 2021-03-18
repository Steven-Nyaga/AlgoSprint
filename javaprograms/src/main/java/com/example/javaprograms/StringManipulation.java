package com.example.javaprograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

    public static boolean areRotations(String str1, String str2){
        if (str1.length() != str2.length())
            return false;
        if (!(str1 + str1).contains(str2))
            return false;
        return true;
    }

    public static String removeDuplicates(String s){
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()){
            if (!set.contains(ch)){
                set.add(ch);
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static char mostRepeatedCharacter(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else {
                map.put(ch, 1);
            }
        }

        int max = 0;
        char result = ' ';

        for (char ch : map.keySet()){
            if (map.get(ch) > max){
                max = map.get(ch);
                result = ch;
            }
        }

        return result;
    }

    public static String capitalize(String s){
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String str1, String str2){
        if (str1 == null || str2 == null)
            return false;
        char[] forStr1 = str1.toCharArray();
        Arrays.sort(forStr1);
        char[] forStr2 = str2.toCharArray();
        Arrays.sort(forStr2);

        return Arrays.equals(forStr1, forStr2);
    }

    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
