# Graphs

- Used on social networks, GPS or wherever we need to represent connected objects.
- Just like trees, graphs consist of nodes and edges. In fact, mathematically speaking a tree is a kind of a graph. It's a graph without any cycles. 
- Graphs don't have a **root node**.

## Building a graph

- *Adjacency matrix*

    * **Space**: O(V^2)
    * **Add **egde**: O(1)
    * **Remove edge**: O(1)
    * **Query** **egde**: O(1)
    * **Find** **Neighbors**: O(V)
    * **Add** **Node**: O(V^2)
    * **Remove** **Node**: O(V^2)

    - Adjacency matrix requires a fair amount of space, but it works really well if we need to add, remove or query edges.
    - However, adding or removing a node run in quadratic time.
    - As a result, we adjacency matrix is suitable if you know ahead of time how many nodes you're going to need, and you're not going add or remove nodes often.

- *Adjacency list*

    * **Space**: O(V^2)d
    * **Add **egde**: O(V)
    * **Remove edge**: O(V)
    * **Query** **egde**: O(V)
    * **Find** **Neighbors**: O(V)
    * **Add** **Node**: O(1)
    * **Remove** **Node**: O(V^2)

    - List<List<Node>>, adding or removing nodes means adding/removing elements from the list

- Best approach: If you have a dense graph, you should use the Adjacency matrix, it has better performance.

## Trasversing a Graph

- Tree traversal starts from the root node.
- When traversing a tree, we start from the root node every node is reachable from the root node.
- In graphs, we start traversing from any node and with this, we only see the nodes that are reachable from that node, not all nodes in the graph.

- **Depth-First**
- **Breath-First**

## Topoligal sorting

- Only works with directed acyclic graphs.
- Topological sorting allows to figure it out the right order we need to process the nodes of a graph.
- It doesn't produce unique results. XABP or XBAP