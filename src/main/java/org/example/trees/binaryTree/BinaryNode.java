package org.example.trees.binaryTree;

import org.example.trees.naryTree.NaryNode;

import java.io.Serializable;
import java.util.List;

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
        if (!(child instanceof BinaryNode)) {
            throw new IllegalArgumentException("El nodo debe ser una instancia de BinaryNode.");
        }
        if (super.children.size() == 2) {
            throw new IndexOutOfBoundsException("Se excedió el límite de hijos.");
        }
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
        if (!(child instanceof BinaryNode)) {
            throw new IllegalArgumentException("El nodo debe ser una instancia de BinaryNode.");
        }
        if (super.children.size() == 2) {
            throw new IndexOutOfBoundsException("Se excedió el límite de hijos.");
        }
        super.addChild(child, pos);
    }

    // Recorrido en pre-orden.
    public void preOrder(List<T> order) {
        order.add(data);
        // Si tiene hijo izquierdo, recorre el hijo izquierdo.
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).preOrder(order);
        }
        // Si tiene hijo derecho, recorre el hijo derecho.
        if (children.size() == 2) {
            ((BinaryNode<T>) children.get(1)).preOrder(order);
        }
    }

    // Recorrido en in-orden.
    public void inOrder(List<T> order) {
        // Si tiene hijo izquierdo, recorre el hijo izquierdo.
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).inOrder(order);
        }
        order.add(data);
        // Si tiene hijo derecho, recorre el hijo derecho.
        if (children.size() == 2) {
            ((BinaryNode<T>) children.get(1)).inOrder(order);
        }
    }

    // Recorrido en post-orden.
    public void postOrder(List<T> order) {
        // Si tiene hijo izquierdo, recorre el hijo izquierdo.
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).postOrder(order);
        }
        // Si tiene hijo derecho, recorre el hijo derecho.
        if (children.size() == 2) {
            ((BinaryNode<T>) children.get(1)).postOrder(order);
        }
        order.add(data);
    }

    // Recorrido en orden de Euler.
    public void eulerOrder(List<T> order) {
        order.add(data);
        // Si tiene hijo izquierdo, recorre el hijo izquierdo.
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).eulerOrder(order);
        }
        // Si tiene hijo derecho, recorre el hijo derecho.
        if (children.size() == 2) {
            ((BinaryNode<T>) children.get(1)).eulerOrder(order);
        }
        order.add(data);
    }
}
