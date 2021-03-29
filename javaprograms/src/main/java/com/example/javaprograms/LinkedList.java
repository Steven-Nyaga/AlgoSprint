package com.example.javaprograms;

public class LinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int val){
        Node node = new Node(val);

        if (first == null)
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int val){
        Node node = new Node(val);

        if (first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public int indexOf(int val){
        if (first == null)
            return -1;

        int count = 0;
        Node current = first;

        while (current != null){
            if (current.value == val) return count;
            current = current.next;
            count++;
        }

        return -1;
    }

    public boolean contains(int val){
        if (first == null)
            return false;

        Node current = first;
        while (current != null){
            if (current.value == val)
                return true;
            current = current.next;
        }

        return false;
    }

    public void removeFirst(){
        if (first == null)
            return;

        Node second = first.next;
        first.next = null;
        first = second;

    }

    public void removeLast(){
        if (first == null)
            return;

        if (first == last){
            first = last = null;
            return;
        }

        Node current = first;
        while (current != null){
            if (current.next == last)
                break;
            current = current.next;
        }

        last = current;
        last.next = null;
    }
}
