package com.example.javaprograms;

import java.util.ArrayList;
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

    //Find random node
    
}
