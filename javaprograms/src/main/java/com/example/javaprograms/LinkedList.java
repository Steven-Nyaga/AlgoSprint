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

    public int size(){
        if (first == null)
            return -1;

        Node current = first;
        int count = 1;

        while (current != null){
            current = current.next;
            count++;
        }

        return count;
    }

    public void reverse(){
        Node p = first;
        Node c = first.next;
        while (c != null){
            Node n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        last = first;
        last.next = null;
        first = p;
    }

    public int getTheKthValueFromLast(int k){
        Node pointer1 = first;
        Node pointer2 = first;

        for (int i = 0; i < k - 1; i++)
            pointer2 = pointer2.next;

        while (pointer2 != last){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1.value;
    }

    public void printMiddle(){
        Node pointer1 = first;
        Node pointer2 = first;

        while (pointer2 != last && pointer2.next != last){
            pointer2 = pointer2.next.next;
            pointer1 = pointer1.next;
        }

        if (pointer2 == last)
            System.out.println(pointer1.value);
        else
            System.out.println(pointer1.value + " " + pointer1.next.value);
    }

    public boolean hasLoop(){
        Node pointer1 = first;
        Node pointer2 = first;

        while (pointer2 != null){
            pointer2 = pointer2.next.next;
            pointer1 = pointer1.next;
            if (pointer1 == pointer2){
                return true;
            }
        }

        return false;
    }
}
