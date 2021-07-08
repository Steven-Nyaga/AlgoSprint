package com.example.javaprograms;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    Node root = new Node(' ');

    public void insert(String word){
        Node current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null)
                current.children[index] = new Node(ch);
            current = current.children[index];
        }
        current.isEndWord = true;
    }
}
