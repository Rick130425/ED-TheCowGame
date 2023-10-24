package org.example.trees.naryTree;

public class NaryTree<T> {
    protected NaryNode<T> root;

    public NaryTree(T rootData) {
        root = new NaryNode<>(rootData);
    }

    public NaryTree(NaryNode<T> root) {
        this.root = root;
    }

    // Puedes agregar más métodos según lo necesites para operaciones del árbol n-ario.
    public void setRoot(NaryNode<T> newRoot) {
        this.root = newRoot;
    }

    public NaryNode<T> getRoot() {
        return this.root;
    }
}