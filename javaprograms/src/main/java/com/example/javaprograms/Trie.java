package com.example.javaprograms;

import java.util.HashMap;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }

    Node root = new Node(' ');

    public void insert(String word){
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node current = root;
        for (char ch : word.toCharArray()){
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndWord;
    }

    public void traversal() {
        traversal(root);
    }
    private void traversal(Node root){
        System.out.println(root.value);

        for (Node child : root.getChildren())
            traversal(child);

//        System.out.println(root.value);
    }
}
