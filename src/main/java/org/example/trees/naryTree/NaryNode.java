package org.example.trees.naryTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un nodo n-ario.
 *
 * @param <T> el tipo de datos almacenado en el nodo.
 */
public class NaryNode<T> implements Serializable {
    /**
     * Información guardada en el nodo.
     */
    protected T data;
    /**
     * Lista de hijos del nodo.
     */
    protected List<NaryNode<T>> children;

    /**
     * Constructor para NaryNode (necesario para la serialización).
     */
    protected NaryNode() {
    }

    /**
     * Constructor para NaryNode.
     *
     * @param data los datos a almacenar en el nodo.
     */
    public NaryNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    /**
     * Agrega un hijo al nodo n-ario.
     *
     * @param child El nodo hijo a agregar.
     */
    public void addChild(NaryNode<T> child) {
        // Agrega un nodo hijo a la lista de hijos.
        this.children.add(child);
    }

    /**
     * Agrega un hijo al nodo n-ario en la posición dada.
     *
     * @param child El nodo hijo a agregar.
     * @param pos   La posición donde se agregará el hijo.
     */
    public void addChild(NaryNode<T> child, int pos) {
        // Agrega un nodo hijo en una posición específica.
        this.children.add(pos, child);
    }

    /**
     * Elimina un hijo del nodo n-ario.
     *
     * @param child El nodo hijo a eliminar.
     */
    public void removeChild(NaryNode<T> child) {
        // Elimina un nodo hijo de la lista.
        this.children.remove(child);
    }

    /**
     * Obtiene los hijos del nodo n-ario.
     *
     * @return Una lista de hijos del nodo.
     */
    public List<NaryNode<T>> getChildren() {
        // Devuelve la lista de hijos del nodo.
        return this.children;
    }

    /**
     * Obtiene los datos del nodo n-ario.
     *
     * @return Los datos almacenados en el nodo.
     */
    public T getData() {
        // Devuelve los datos almacenados en el nodo.
        return this.data;
    }
}