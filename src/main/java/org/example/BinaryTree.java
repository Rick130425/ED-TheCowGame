package org.example;

public class BinaryTree<T> extends NaryTree<T> {
    public BinaryTree(T rootData) {
        super(rootData);
        this.root = new BinaryNode<>(rootData);
    }

    @Override
    public void setRoot(NaryNode<T> newRoot) {
        if (!(newRoot instanceof BinaryNode)) {
            throw new IllegalArgumentException("The root must be an instance of BinaryNode.");
        }
        this.root = newRoot;
    }
}