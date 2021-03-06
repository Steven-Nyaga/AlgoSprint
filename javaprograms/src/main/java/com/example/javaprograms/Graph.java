package com.example.javaprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge (String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
//        adjacencyList.get(toNode).add(fromNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            return;

        for (Node n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traversDFR(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        traversDFR(node, new HashSet<>());
    }
    private void traversDFR(Node node, Set<Node> visited) {
        System.out.println(node);
        visited.add(node);

        for (Node n : adjacencyList.get(node))
            if (!visited.contains(n))
                traversDFR(n, visited);
    }

    public void traverseDFI(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (Node neighbour : adjacencyList.get(current))
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
        }
    }

    public void traverseBF(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (Node neighbour : adjacencyList.get(current))
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values())
            topologicalSort(node, stack, visited);

        List<String> sorted = new ArrayList<>();

        while (!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node node, Stack<Node> stack, Set<Node> visited){
        if (visited.contains(node))
            return;

        visited.add(node);

        for (Node neighbour : adjacencyList.get(node))
            topologicalSort(neighbour, stack, visited);

        stack.push(node);
    }

    public boolean isCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();

            if (isCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }
    private boolean isCycle (Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (Node neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;

            if (visiting.contains(neighbour))
                return true;

            if (isCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
