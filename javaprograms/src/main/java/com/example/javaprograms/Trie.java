package com.example.javaprograms;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
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

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }
    private void remove(Node root, String word, int index) {
        if (index == word.length()){
            root.isEndWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndWord)
            root.removeChild(ch);
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNode(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }
    private void findWords(Node root, String prefix, List<String> words){
     if (root == null)
         return;

     if (root.isEndWord)
         words.add(prefix);

     for (Node child : root.getChildren())
         findWords(child, prefix + child.value, words);

    }
    private Node findLastNode(String prefix) {
        if (prefix == null)
            return null;
        
        Node current = root;
        for (char ch : prefix.toCharArray()){
            Node child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }
}
