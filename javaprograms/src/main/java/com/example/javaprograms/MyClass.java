package com.example.javaprograms;

public class MyClass {
    public static void main (String [] args){

        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.removeEdge("A","C");
        graph.print();



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