package Graphs;

import java.security.InvalidParameterException;
import java.util.*;

public class WeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges;

        public Node(String label) {
            this.label = label;
            this.edges = new ArrayList<>();
        }

        public void addEge(Node to, int weight)  {
            edges.add(new Edge(this, to, weight));
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    private class Edge {

        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "[" + this.from + " -> " + this.to + ", " + this.weight + "]";
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if(fromNode == null)
            throw new InvalidParameterException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new InvalidParameterException();

       fromNode.addEge(toNode, weight);
       toNode.addEge(fromNode, weight);
    }

    public boolean hasCycle() {

        var visited = new HashSet<Node>();

        for(var node : nodes.values()) {
            if(!visited.contains(node) && hasCycle(node, null, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for(var edge : node.edges){
            if(edge.to == parent)
                continue;

            if(visited.contains(edge.to) ||hasCycle(edge.to, node, visited))
                return true;
        }
        return false;
    }

    public class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    /*
     * Dijkstra's Algorithm
     */
    public Path getShortestDistance(String from, String to) {
        var fromNode = nodes.get(from);
        if(fromNode == null)
            throw new InvalidParameterException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new InvalidParameterException();

        Map<Node, Integer> distances = new HashMap<>();
        for(var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(nodes.get(from), 0);

        Map<Node, Node> previousNodes = new HashMap<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.priority));
        Set<Node> visited = new HashSet<>();
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for(var edge : current.edges) {

                if(visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return build(previousNodes, toNode);
    }

    /*
     * Prim's Algorithm - Minimum spanning tree
     */
    public WeightedGraph minimumSpanningTree() {
       var tree = new WeightedGraph();

       if(nodes.isEmpty())
           return tree;

       PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
       var startNode = nodes.values().iterator().next();
       edges.addAll(startNode.edges);
       tree.addNode(startNode.label);

       if(edges.isEmpty())
            return tree;

       while(tree.nodes.size() < nodes.size()) {
           var minimumEdge = edges.remove();
           var nextNode = minimumEdge.to;

           if(tree.nodes.containsKey(nextNode.label))
               continue;

           tree.addNode(nextNode.label);
           tree.addEdge(minimumEdge.from.label, nextNode.label, minimumEdge.weight);

           for(var edge : nextNode.edges) {
               if(!tree.nodes.containsKey(edge.to.label))
                   edges.add(edge);
           }
       }

       return tree;
    }

    private Path build(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        var previous = previousNodes.get(toNode);
        while(previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while(!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }


    public void print() {
        for (var node : nodes.values()) {
            var edges = node.edges;
            if(!edges.isEmpty()) {
                System.out.println(node + " -> Edges: "+ edges);
            }
        }
    }

}
