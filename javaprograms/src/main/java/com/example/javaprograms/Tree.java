package com.example.javaprograms;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int val) {
        Node node = new Node(val);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (val < current.value){
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }

                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }

                current = current.rightChild;
            }
        }
    }

    public boolean find(int val) {
        if (root == null)
            return false;

        Node current = root;
        while (current != null) {
            if (val == current.value)
                return true;
            else if (val < current.value)
                current = current.leftChild;
            else if (val > current.value)
                current = current.rightChild;
        }

        return false;
    }
}
