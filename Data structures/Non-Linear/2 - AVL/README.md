# AVL Trees (Adelson-Velsky and Landis)

- Self-balancing trees;
- If a binary search tree is not structured properly, the performance is gonna drop to O(n);
- **Balanced tree**: Height(left) - Height(right) <= 1;
- **Right Sekewed Tree**: Most of the nodes only have the right child;
- **Left Sekewed Tree**: Most of the nodes only have the left child;
- Skewed trees behave like a *linked list*;
- Even if the items that we're inserting in a tree are not sorted, the trees can still become unbalanced;
- AVL Trees was created in order to create Self-balancing trees.
- We also have algorithms like:
    * Red-black trees
    * B-Trees
    * Splay trees
    * 2-3 trees

## Rotations

* On AVL trees everytime we add/delete an item, the rebalance is performed ensuring **Height(left) - Height(right) <= 1**

* Four types of rotation:
    - Left (LL)
    - Right (RR)
    - Left-Right (LR)
    - Right-Left (RL)

* To choose a rotation method, it depends on the what side of the tree is heavy.

 ## Notes

- As a tree becomes unbalanced, search operations in the worst-case scenario could have an complexity of O(n), similar to linked lists. Self-balancing trees come to solve this problem.