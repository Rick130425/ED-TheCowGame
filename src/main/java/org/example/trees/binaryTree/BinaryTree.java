package org.example.trees.binaryTree;

import org.example.trees.naryTree.NaryNode;
import org.example.trees.naryTree.NaryTree;

import java.io.Serializable;

/**
 * Representa un árbol binario.
 *
 * @param <T> el tipo de datos almacenado en el árbol.
 */
public class BinaryTree<T> extends NaryTree<T> implements Serializable {

    protected BinaryTree() {
    }

    /**
     * Constructor para BinaryTree.
     *
     * @param rootData los datos para el nodo raíz.
     */
    public BinaryTree(T rootData) {
        super(rootData);
        this.root = new BinaryNode<>(rootData);
    }

    /**
     * Constructor para BinaryTree.
     *
     * @param root el nodo raíz.
     */
    public BinaryTree(BinaryNode<T> root) {
        super(root);
    }

    /**
     * Establece la raíz del árbol binario.
     *
     * @param newRoot La nueva raíz.
     * @throws IllegalArgumentException Si la nueva raíz no es una instancia de BinaryNode.
     */
    @Override
    public void setRoot(NaryNode<T> newRoot) {
        if (!(newRoot instanceof BinaryNode)) {
            throw new IllegalArgumentException("La raíz debe ser una instancia de BinaryNode.");
        }
        super.setRoot(newRoot);
    }
}