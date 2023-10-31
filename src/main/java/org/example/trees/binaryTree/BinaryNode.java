package org.example.trees.binaryTree;

import org.example.trees.naryTree.NaryNode;

import java.io.Serializable;

/**
 * Representa un nodo binario.
 *
 * @param <T> el tipo de datos almacenado en el nodo.
 */
public class BinaryNode<T> extends NaryNode<T> implements Serializable {

    private BinaryNode() {
        super();
    }

    /**
     * Constructor para BinaryNode.
     *
     * @param data los datos a almacenar en el nodo.
     */
    public BinaryNode(T data) {
        super(data);
    }

    /**
     * Agrega un hijo al nodo binario.
     *
     * @param child El nodo hijo a agregar.
     * @throws IllegalArgumentException  Si el nodo no es una instancia de BinaryNode.
     * @throws IndexOutOfBoundsException Si el nodo ya tiene dos hijos.
     */
    @Override
    public void addChild(NaryNode<T> child) {
        // Verifica si el nodo hijo es una instancia de BinaryNode.
        if (!(child instanceof BinaryNode)) {
            throw new IllegalArgumentException("El nodo debe ser una instancia de BinaryNode.");
        }
        // Verifica si el nodo ya tiene dos hijos.
        if (super.children.size() == 2) {
            throw new IndexOutOfBoundsException("Se excedió el límite de hijos.");
        }
        // Agrega el nodo hijo.
        super.addChild(child);
    }

    /**
     * Agrega un hijo al nodo binario en la posición dada.
     *
     * @param child El nodo hijo a agregar.
     * @param pos   La posición donde se agregará el hijo.
     * @throws IllegalArgumentException  Si el nodo no es una instancia de BinaryNode.
     * @throws IndexOutOfBoundsException Si el nodo ya tiene dos hijos.
     */
    @Override
    public void addChild(NaryNode<T> child, int pos) {
        // Verifica si el nodo hijo es una instancia de BinaryNode.
        if (!(child instanceof BinaryNode)) {
            throw new IllegalArgumentException("El nodo debe ser una instancia de BinaryNode.");
        }
        // Verifica si el nodo ya tiene dos hijos.
        if (super.children.size() == 2) {
            throw new IndexOutOfBoundsException("Se excedió el límite de hijos.");
        }
        // Agrega el nodo hijo.
        super.addChild(child, pos);
    }
}
