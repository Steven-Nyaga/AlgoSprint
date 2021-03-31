package com.example.javaprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MyClass {
    public static void main (String [] args){

        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(50);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.printMiddle();
        System.out.println(linkedList.hasLoop());




//        Trie trie = new Trie();
//        trie.insert("canada");
//        trie.insert("cat");
//        System.out.println(trie.contains("can"));
//        trie.traverse();













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