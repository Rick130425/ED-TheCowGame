package org.example.trees.binaryTree;

import org.example.trees.naryTree.NaryNode;
import org.example.trees.naryTree.NaryTree;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un árbol binario.
 * @param <T> el tipo de datos almacenado en el árbol.
 */
public class BinaryTree<T> extends NaryTree<T> {

    /**
     * Constructor para BinaryTree.
     * @param rootData los datos para el nodo raíz.
     */
    public BinaryTree(T rootData) {
        super(rootData);
        // Inicializa la raíz del árbol binario.
        this.root = new BinaryNode<>(rootData);
    }

    /**
     * Constructor para BinaryTree.
     * @param root el nodo raíz.
     */
    public BinaryTree(BinaryNode<T> root) {
        super(root);
    }

    // Establece la raíz del árbol binario.
    @Override
    public void setRoot(NaryNode<T> newRoot) {
        // Verifica si la nueva raíz es una instancia de BinaryNode.
        if (!(newRoot instanceof BinaryNode)) {
            throw new IllegalArgumentException("La raíz debe ser una instancia de BinaryNode.");
        }
        // Establece la nueva raíz.
        this.root = newRoot;
    }

    // Recorrido en pre-orden.
    public List<T> preOrder() {
        List<T> order = new ArrayList<>();
        // Inicia el recorrido desde la raíz.
        ((BinaryNode<T>) root).preOrder(order);
        return order;
    }

    // Recorrido en in-orden.
    public List<T> inOrder() {
        List<T> order = new ArrayList<>();
        // Inicia el recorrido desde la raíz.
        ((BinaryNode<T>) root).inOrder(order);
        return order;
    }

    // Recorrido en post-orden.
    public List<T> postOrder() {
        List<T> order = new ArrayList<>();
        // Inicia el recorrido desde la raíz.
        ((BinaryNode<T>) root).postOrder(order);
        return order;
    }

    // Recorrido en orden de Euler.
    public List<T> eulerOrder() {
        List<T> order = new ArrayList<>();
        // Inicia el recorrido desde la raíz.
        ((BinaryNode<T>) root).eulerOrder(order);
        return order;
    }
}