package org.example.trees.naryTree;

import java.io.Serializable;

/**
 * Representa un árbol n-ario.
 * @param <T> el tipo de datos almacenado en el árbol.
 */
public class NaryTree<T> implements Serializable {
    protected NaryNode<T> root;

    protected NaryTree() {
    }

    /**
     * Constructor para NaryTree.
     * @param rootData los datos para el nodo raíz.
     */
    public NaryTree(T rootData) {
        // Inicializa la raíz del árbol n-ario.
        root = new NaryNode<>(rootData);
    }

    /**
     * Constructor para NaryTree.
     * @param root el nodo raíz.
     */
    public NaryTree(NaryNode<T> root) {
        this.root = root;
    }

    // Establece la raíz del árbol n-ario.
    public void setRoot(NaryNode<T> newRoot) {
        // Establece la nueva raíz.
        this.root = newRoot;
    }

    // Obtiene la raíz del árbol n-ario.
    public NaryNode<T> getRoot() {
        // Retorna la raíz del árbol.
        return this.root;
    }
}