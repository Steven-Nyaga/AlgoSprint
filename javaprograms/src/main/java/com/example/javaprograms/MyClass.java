package com.example.javaprograms;

import java.util.ArrayList;

public class MyClass {
    public static void main (String [] args){
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);

        System.out.println(tree.getAncestors(6));

//        tree.swapRoot();
//        ArrayList<Integer> list = new ArrayList<>();
//        list = tree.getNodesAtDistance(2);
//        for(int value : list)
//            System.out.println(value);
//        System.out.println(tree.isBinarySearchTree());

















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