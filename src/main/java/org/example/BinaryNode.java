package org.example;

import java.util.List;

public class BinaryNode<T> extends NaryNode<T> {

    public BinaryNode(T data) {
        super(data);
    }

    @Override
    public void addChild(NaryNode<T> child) {
        if (!(child instanceof BinaryNode)){
            throw new IllegalArgumentException("The node must be an instance of BinaryNode.");
        }
        if (super.children.size() == 2) {
            throw new IndexOutOfBoundsException("");
        }
        super.addChild(child);
    }
}
