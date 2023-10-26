package org.example.trees.naryTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un nodo n-ario.
 * @param <T> el tipo de datos almacenado en el nodo.
 */
public class NaryNode<T> implements Serializable {
    protected T data;
    protected List<NaryNode<T>> children;

    protected NaryNode() {
    }

    /**
     * Constructor para NaryNode.
     * @param data los datos a almacenar en el nodo.
     */
    public NaryNode(T data) {
        this.data = data;
        // Inicializa la lista de hijos.
        this.children = new ArrayList<>();
    }

    // Agrega un hijo al nodo n-ario.
    public void addChild(NaryNode<T> child) {
        // Añade el hijo a la lista.
        this.children.add(child);
    }

    // Agrega un hijo al nodo n-ario en la posición dada.
    public void addChild(NaryNode<T> child, int pos) {
        // Añade el hijo a la lista.
        this.children.add(pos, child);
    }

    // Elimina un hijo del nodo n-ario.
    public void removeChild(NaryNode<T> child) {
        // Elimina el hijo de la lista.
        this.children.remove(child);
    }

    // Obtiene los hijos del nodo n-ario.
    public List<NaryNode<T>> getChildren() {
        // Retorna la lista de hijos.
        return this.children;
    }

    // Obtiene los datos del nodo n-ario.
    public T getData() {
        // Retorna los datos del nodo.
        return this.data;
    }
}