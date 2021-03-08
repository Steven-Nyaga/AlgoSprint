package com.example.javaprograms;

public class AVLTree {
    private class AVLNode{
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    private AVLNode root;

    //Insertion to AVLTree
    public void insert(int val){
        root = insert(root, val);
    }
    private AVLNode insert(AVLNode root, int val){
        if (root == null){
            return new AVLNode(val);
        }
        if (val < root.value)
            root.leftChild = insert(root.leftChild, val);
        else
            root.rightChild = insert(root.rightChild, val);

        setHeight(root);

        root = balanced(root);

        return root;
    }

    private int height (AVLNode node){
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balancedFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balancedFactor(node) < -1;
    }

    private int balancedFactor(AVLNode node){
        return (node == null) ? 0 :height(node.leftChild) - height(node.rightChild);
    }

    private AVLNode balanced(AVLNode root){
        if (isLeftHeavy(root)){
            if(balancedFactor(root.rightChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }else if (isRightHeavy(root)){
            if(balancedFactor(root.rightChild) > 0)
               root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        AVLNode newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        AVLNode newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

    public int isBalanced(){
        return isBalanced(root);
    }
    private int isBalanced(AVLNode root){
        if (root == null)
            return 0;

        int leftSide = isBalanced(root.leftChild);
        if (leftSide == -1)
            return -1;
        int rightSide = isBalanced(root.rightChild);
        if (rightSide == -1)
            return -1;
        if (Math.abs(leftSide -rightSide) > 1)
            return -1;

        return (Math.max(leftSide,rightSide) + 1);
    }
}
