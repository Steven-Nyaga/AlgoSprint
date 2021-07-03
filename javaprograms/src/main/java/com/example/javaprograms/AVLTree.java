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

        setHeight(root);

        return balance(root);
    }
    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }
    private int setHeight(AVLNode node){
        return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
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
    private AVLNode balance(AVLNode node){
        if (isLeftHeavy(node)){
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = leftRotation(node.leftChild);
            return rightRotation(node);
        }
        if (isRightHeavy(node)){
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rightRotation(node.rightChild);
            return leftRotation(node);
        }

        return node;
    }

    private AVLNode leftRotation(AVLNode node){
        AVLNode newRoot = node.rightChild;

        node.rightChild = node.leftChild;
        node.leftChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rightRotation(AVLNode node){
        AVLNode newRoot = node.leftChild;

        node.leftChild = node.rightChild;
        node.rightChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }
}
