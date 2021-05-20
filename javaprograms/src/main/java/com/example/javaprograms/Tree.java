package com.example.javaprograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    //Traversal with recursion
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node root) {
        if (root == null)
            return;

        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

    //traversal without recursion
    public void inOrderWithoutRecursion() {
        inOrderWithoutRecursion(root);
    }
    private void inOrderWithoutRecursion(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.rightChild;
        }
    }

    //Level order traversal
    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }
    private void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            if (tempNode.leftChild != null) {
                queue.add(tempNode.leftChild);
            }

            if (tempNode.rightChild != null) {
                queue.add(tempNode.rightChild);
            }
        }
    }
}
