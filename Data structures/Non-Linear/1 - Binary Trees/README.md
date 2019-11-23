# Binary Trees

- They have tons of applications on databases, websites, etc;
- A tree stores elements in a hierarchy (Elements = Nodes, Lines Connecting the nodes = Edges);
- Top node is called the **Root**;
- Nodes without children are called **Leafs**;
- Binary Trees only allow each node having at maximum two children;
- Left Node Value < Node < Right Node Value (Only on Binary Search Trees).

* **Operations** 
- Insert: O(log n), because in each iteration we threw half of our nodes away;
- Lookup: O(log n);
- Delete: O(log n);

Note: Better performance than Arrays and LinkedLists

# Traversing a Tree

- **Breadth first**
    - Visits all the nodes at the same level (Runs horizontally)
    - Also called Level Order, because we're trasversing level by level
    - Easilly implemented with **Height** and **nodesAtKDistance**()
- **Depth first**
    - Go deep from Root Node to the Leafs
    - *Pre-order*
        - Root, Left, Right
    - *In-order*
        - Left, Root, Right (The numbers will come out in ascending order)
    - *Post-order*
        - Left, Right, Root (Visit the leafs nodes first back to the root)

# Depth vs Height
- *Depth*  = count the number of edges from the root to the target node
- *Height* = Opossite of Depth (Distance from the a specific node to the Root)
- *Tree Heigth* = Longest path from the Root Node to a Leaf (Height(Root))

# Binary Tree vs Binary Search Tree 
- Left Node Value < Node < Right Node Value
- The above condition is only applied on Binary Search Trees.