package com.example.javaprograms;

import java.util.HashMap;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node{
        private char value;
//        private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word){
        Node current = root;
        for (char ch : word.toCharArray()){
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if (word == null)
            return false;

        Node current = root;
        for(char ch : word .toCharArray()){
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }
    private void traverse(Node root){
        //Pre-order
//        System.out.println(root.value);
//
//        for (Node child : root.getChildren()){
//            traverse(child);
//        }

        //Post Order
        for (Node child : root.getChildren()){
            traverse(child);
        }
        System.out.println(root.value);
    }

    public void remove(String word){
        remove(root, word, 0);
    }
    private void remove(Node root, String word, int index){
        if (index == word.length())
            root.isEndOfWord = false;

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        
    }

}
