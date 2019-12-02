package AVLTrees;

public class AVLTree {

    private class AVLNode {

        public AVLNode (int value) {
            this.value = value;
            this.height = 0;
        }

        private int value;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        private int height;

        private AVLNode leftChild;

        private AVLNode rightChild;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public AVLNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(AVLNode leftChild) {
            this.leftChild = leftChild;
        }

        public AVLNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(AVLNode rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    private AVLNode insert(AVLNode node, int value) {
        if(node == null) {
            return new AVLNode(value);
        }

        if(node.getValue() > value) {
            node.setLeftChild(insert(node.getLeftChild(), value));
        } else {
            node.setRightChild(insert(node.getRightChild(), value));
        }

        node.height = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;

        return balance(node);
    }

    public int height(AVLNode node) {
        return node == null ? -1 : node.getHeight();
    }

    // Empty tree is balanced (= 0)
    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.getLeftChild()) - height(node.getRightChild());
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    public int height() {
        return this.height(this.root);
    }

    public AVLNode balance(AVLNode node) {

        if(isRightHeavy(node)) {
            // If the tree is right heavy, we must perform a left rotation
            if(balanceFactor(node.getRightChild()) > 0) {
                node.setRightChild(rightRotation(node.getRightChild()));
            }
            return leftRotation(node);
        } else if(isLeftHeavy(node)) {
            // If the tree is left heavy, we must perform a right rotation
            if(balanceFactor(node.getLeftChild()) < 0) {
               node.setLeftChild(leftRotation(node.getLeftChild()));
            }
            return rightRotation(node);
        }

        return node;
    }

    private AVLNode leftRotation (AVLNode node) {
        var newRoot = node.getRightChild();
        node.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(node);

        // Updating the heights
        node.height = Math.max(height(node.getLeftChild()), height(node.getRightChild()))+ 1;
        newRoot.height = Math.max(height(newRoot.getLeftChild()), height(newRoot.getRightChild())) + 1;

        return newRoot;
    }

    private AVLNode rightRotation (AVLNode node) {
        var newRoot = node.getLeftChild();
        node.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(node);

        // Updating the heights
        node.height = Math.max(height(node.getLeftChild()), height(node.getRightChild()) )+ 1;
        newRoot.height = Math.max(height(newRoot.getLeftChild()), height(newRoot.getRightChild())) + 1;

        return newRoot;
    }

}
