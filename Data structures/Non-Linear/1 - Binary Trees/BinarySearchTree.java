package BinaryTrees;
// Binary Tree
// Don't Forget: Left Child < Node < Right Child (Binary Search Tree)
public class BinarySearchTree {

    private class Node {

        private int value;

        private Node leftChild;

        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node root;

    public BinarySearchTree() {

    }

    public void insert(int value) {

        if(root == null) {
            this.root = new Node(value);
            return;
        }

        var current = root;
        while(true) {
            if(value < current.getValue()) {
                if(current.getLeftChild() == null) {
                    current.setLeftChild(new Node(value));
                    return;
                }
                current = current.getLeftChild();
            } else {
                if(current.getRightChild() == null) {
                    current.setRightChild(new Node(value));
                    return;
                }
                current = current.getRightChild();
            }
        }
    }

    public boolean find(int value) {
        if(root == null) {
            return false;
        }
        var current = root;
        while(true) {
            if(value == current.getValue()) {
                return true;
            }

            if(value < current.getValue()) {
                if(current.getLeftChild() == null) {
                    return false;
                }
                current = current.getLeftChild();
            } else {
                if(current.getRightChild() == null) {
                    return false;
                }
                current = current.getRightChild();
            }
        }
    }

    // Root, Left, Right
    public void DepthFirstPreOrder(){
        DepthFirstPreOrder(this.root);
    }

    private void DepthFirstPreOrder(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        DepthFirstPreOrder(root.leftChild);
        DepthFirstPreOrder(root.rightChild);
    }

    //  Left, Right, Root
    public void DepthFirstPostOrder(){
        DepthFirstPostOrder(this.root);
    }

    private void DepthFirstPostOrder(Node root){
        if(root == null)
            return;

        DepthFirstPostOrder(root.leftChild);
        DepthFirstPostOrder(root.rightChild);
        System.out.println(root.value);
    }

    //  Left, Right, Root
    public void DepthFirstInOrder(){
        DepthFirstInOrder(this.root);
    }

    private void DepthFirstInOrder(Node root){
        if(root == null)
            return;

        DepthFirstInOrder(root.leftChild);
        System.out.println(root.value);
        DepthFirstInOrder(root.rightChild);
    }

    public int height() {
        if(root == null) {
            return -1;
        }

        return height(this.root);
    }

    private int height (Node node) {
        if(node == null) {
            return -1;
        }

        if(node.getLeftChild() == null && node.getRightChild() == null)
            return 0;

        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public int minimumValueOnBinarySearchTree() {
        return minimumValueOnBinarySearchTree(this.root);
    }

    // O(log n)
    private int minimumValueOnBinarySearchTree(Node node) {
        if(node == null) {
            throw new IllegalStateException();
        }
        return node.getLeftChild() == null ? node.getValue() : minimumValueOnBinarySearchTree(node.getLeftChild());
    }

    public int minimumValueBinaryTree() {
        return minimumValueBinaryTree(this.root);
    }

    public int minimumValueBinaryTree(Node node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }

        if(node.getLeftChild() == null && node.getLeftChild() == null) {
            return node.getValue();
        }

        var leftMinimum = minimumValueBinaryTree(node.getLeftChild());
        var rightMinimum = minimumValueBinaryTree(node.getRightChild());
        return Math.min(node.getValue(), Math.min(leftMinimum, rightMinimum));
    }

    private boolean isLeaf(Node node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

    public boolean equals(BinarySearchTree other) {
        if(other == null)
            return false;

        return equals(this.root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null) {
            return true;
        }

        if(first != null && second != null) {
            return first.getValue() == second.getValue() &&
                    isLeaf(first) == isLeaf(second) &&
                    equals(first.getLeftChild(), second.getLeftChild()) &&
                    equals(first.getRightChild(), second.getRightChild());
        }

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        if(node == null)
            return true;

        if(node.getValue() < min || node.getValue() > max) {
            return false;
        }

        return  isBinarySearchTree(node.getLeftChild(), min, node.getValue() - 1) && isBinarySearchTree(node.getRightChild(), node.getValue() + 1, max);
    }

    public void nodesAtKDistance(int distance) {
        nodesAtKDistance(this.root, distance);
    }

    private void nodesAtKDistance(Node node, int distance) {
        if(node == null) {
            return;
        }

        if(distance == 0) {
            System.out.println(node.getValue());
            return;
        }

        nodesAtKDistance(node.getLeftChild(), distance - 1);
        nodesAtKDistance(node.getRightChild(), distance - 1);
    }

    public void traverseLevelOrder() {
        var height = height();
        for(var distance  = 0; distance <= height; distance++) {
            nodesAtKDistance(distance);
        }
    }
}
