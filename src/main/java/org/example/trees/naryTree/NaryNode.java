package org.example.trees.naryTree;

import java.util.ArrayList;
import java.util.List;

public class NaryNode<T> {
    protected T data;
    protected List<NaryNode<T>> children;

    public NaryNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(NaryNode<T> child) {
        this.children.add(child);
    }

    public void removeChild(NaryNode<T> child) {
        this.children.remove(child);
    }

    public List<NaryNode<T>> getChildren() {
        return this.children;
    }

    public T getData() {
        return this.data;
    }


}