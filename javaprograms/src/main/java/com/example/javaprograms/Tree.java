package com.example.javaprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value){
        Node node = new Node(value);
        if (root == null){
           root = node;
           return;
        }
        Node current = root;
        while(true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            if (value > current.value){
                if (current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        if(value == root.value){
            return true;
        }
        Node current = root;
        while (true){
            if (value < current.value){
                if (current.leftChild == null)
                    break;
                current = current.leftChild;
            }
            if (value > current.value){
                if (current.rightChild == null)
                    break;
                current = current.rightChild;
            }
            if (value == current.value){
                return true;
            }
        }
        return false;
    }

    //Traverse a tree in pre-order
    public void preOrderTraverse(){
        preOrderTraverse(root);
    }
    private void preOrderTraverse(Node node){
        if(node == null)
            return;
        System.out.println(node.value);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    //Traverse a tree in in-order
    public void inOrderTraverse(){
        inOrderTraverse(root);
    }
    private void inOrderTraverse(Node node){
        if(node == null)
            return;

        inOrderTraverse(node.leftChild);
        System.out.println(node.value);
        inOrderTraverse(node.rightChild);
    }

    //Traverse a tree in post-order
    public void postOrderTraverse(){
        postOrderTraverse(root);
    }
    private void postOrderTraverse(Node node){
        if(node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.value);
    }

    //Height of the tree
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null)
            return -1;
        if(root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    //Find minimum of binary tree
    public int findMin(){
        return findMin(root);
    }
    public int findMin(Node root){
        if(root.leftChild == null && root.rightChild == null)
            return  root.value;
        int left = findMin(root.leftChild);
        int right = findMin(root.rightChild);

        return Math.min((Math.min(left, right)), root.value);
    }

    //Finding minimum of binary search tree
    public int bTSMin(){
        if (root == null)
            throw new IllegalStateException();

        Node current = root;
        Node last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    //Checking if two trees are the same
    public boolean equals(Tree other){
        return equals(root, other.root);
    }
    private boolean equals (Node first, Node second){
        if(first == null && second == null)
            return true;
        if(first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        return false;
    }

    //Validating a binary search tree
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;
        if(root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    //Swapping nodes to make the tree not a binary search
    public void swapRoot(){
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    //Nodes at K distance from the root
    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null)
            return;
        if(distance == 0){
//            System.out.println(root.value);
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    //Finding number of leaves in tree
    public int countLeaves(){
        return countLeaves(root);
    }
    private int count = 0;
    private int countLeaves(Node root){
        if (root == null){
            return 0;
        }
        else {
            if (root.leftChild == null && root.rightChild == null){
                count++;
            }
            else {
                if (root.leftChild != null){
                    countLeaves(root.leftChild);
                }
                if(root.rightChild != null){
                    countLeaves(root.rightChild);
                }
            }
        }
        return count;
    }

    //Finding Max Value
    public int max(){
       return max(root);
    }
    private int max(Node root){
        if (root.leftChild == null && root.rightChild == null)
            return root.value;
        int left = max(root.leftChild);
        int right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    //Max for Binary Search tree
    public int BTSMax(){
        Node current = root;
        Node last = current;
        while (current != null){
            last = current;
            current = current.rightChild;
        }
        return last.value;
    }

    //Find using recursion
//    public boolean contains(int num){
//
//    }
//    private boolean contains(Node root, int num){
//        if (root == null)
//            return false;
//        if (root.value == num)
//            return true;
//
//    }

    //returning ancestors
    public boolean getAncestors(int val){
        return getAncestors(root, val);
    }
    private boolean getAncestors(Node root, int target)
    {
        /* base cases */
        if (root == null)
            return false;

        if (root.value == target)
            return true;

        /* If target is present in either left or right subtree
           of this node, then print this node */
        if (getAncestors(root.leftChild, target)
                || getAncestors(root.rightChild, target))
        {
            System.out.print(root.value + " ");
            return true;
        }

        /* Else return false */
        return false;
    }

    //Find random node
}
