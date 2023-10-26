package org.example.trees.naryTree;

import java.io.Serializable;

/**
 * Representa un árbol n-ario.
 *
 * @param <T> el tipo de datos almacenado en el árbol.
 */
public class NaryTree<T> implements Serializable {
    protected NaryNode<T> root;

    protected NaryTree() {
    }

    /**
     * Constructor para NaryTree.
     *
     * @param rootData los datos para el nodo raíz.
     */
    public NaryTree(T rootData) {
        root = new NaryNode<>(rootData);
    }

    /**
     * Constructor para NaryTree.
     *
     * @param root el nodo raíz.
     */
    public NaryTree(NaryNode<T> root) {
        this.root = root;
    }

    /**
     * Establece la raíz del árbol n-ario.
     *
     * @param newRoot La nueva raíz.
     */
    public void setRoot(NaryNode<T> newRoot) {
        this.root = newRoot;
    }

    /**
     * Obtiene la raíz del árbol n-ario.
     *
     * @return El nodo raíz del árbol.
     */
    public NaryNode<T> getRoot() {
        return this.root;
    }
}