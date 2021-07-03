package com.example.javaprograms;

public class AVLTree {
    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
    }
    private AVLNode insert(AVLNode root, int value){
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);

        if (value > root.value)
            root.rightChild = insert(root.rightChild, value);

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        int balanceFactor = balanceFactor(root);
        if (isLeftHeavy(root))
            System.out.println(root.value + " is left heavy");
        if (isRightHeavy(root))
            System.out.println(root.value + " is right heavy");

        return root;
    }
    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }
    private int balanceFactor(AVLNode node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }
    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }
}
