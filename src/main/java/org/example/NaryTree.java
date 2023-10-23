package org.example;

public class NaryTree<T> {
    NaryNode<T> root;

    public NaryTree(T rootData) {
        root = new NaryNode<>(rootData);
    }

    // Puedes agregar más métodos según lo necesites para operaciones del árbol n-ario.
    public void setRoot(NaryNode<T> newRoot) {
        this.root = newRoot;
    }

    public NaryNode<T> getRoot() {
        return this.root;
    }
}