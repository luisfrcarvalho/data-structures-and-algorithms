package Graphs;

import java.beans.Visibility;
import java.util.*;

public class Graph {

    private class Node {
        private String label;

        public Node (String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.put(node, new LinkedList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if(fromNode == null) {
            throw new IllegalArgumentException();
        }

        var toNode = nodes.get(to);
        if(toNode == null) {
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(toNode);
        // adjacencyList.get(toNode).add(fromNode); -> Undirected graph
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if(node == null)
            return;

        for(var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }


    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if(fromNode == null) {
           return;
        }

        var toNode = nodes.get(to);
        if(toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void depthFirstTraversal(String label) {
        var node = nodes.get(label);
        if(node == null)
            return;
        depthFirstTraversal(node, new HashSet<>());
    }

    private void depthFirstTraversal(Node node, Set<Node> set) {
        System.out.println(node);
        set.add(node);

        for (var n :  adjacencyList.get(node)) {
            if(!set.contains(n)) {
                depthFirstTraversal(n, set);
            }
        }
    }

    public void depthFirstTraversalIterative(String label) {
        var node = nodes.get(label);
        if(node == null)
            return;

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if(visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (var n :  adjacencyList.get(current))
                if(!visited.contains(n))
                    stack.push(n);
        }

    }

    public void breathFirstTraversal(String label) {
        var node = nodes.get(label);
        if(node == null) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if(visited.contains(current))
                continue;

            System.out.println(current);

            visited.add(current);

            for (var n :  adjacencyList.get(current))
                if(!visited.contains(n))
                    queue.add(n);
        }
    }

    public List<String> topologicalSort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for(var n : nodes.values()) {
            topologicalSort(n, visited, stack);
        }

        var list = new LinkedList<String>();
        while(!stack.isEmpty()) {
            list.addLast(stack.pop().label);
        }

        return list;
    }

    public void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node))
            return;

        visited.add(node);

        for(var neighbour : adjacencyList.get(node))
            if(!visited.contains(neighbour))
                topologicalSort(neighbour, visited, stack);

        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for(var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour))
                continue;

            if(visiting.contains(neighbour))
                return true;

           if(hasCycle(neighbour, all, visiting, visited))
               return true;
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

    public void print() {
        for (var node : adjacencyList.keySet()) {
            var edges = adjacencyList.get(node);
            if(!edges.isEmpty()) {
                System.out.println(node + " -> Edges: "+ edges);
            }
        }
    }

}
