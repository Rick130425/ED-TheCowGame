package org.example.trees.binaryTree;

import org.example.trees.naryTree.NaryNode;

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

    public void preOrder(List<T> order) {
        order.add(data);
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).preOrder(order);
        }
        if (children.size() >= 2) {
            ((BinaryNode<T>) children.get(1)).preOrder(order);
        }
    }

    public void inOrder(List<T> order) {
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).inOrder(order);
        }
        order.add(data);
        if (children.size() >= 2) {
            ((BinaryNode<T>) children.get(1)).inOrder(order);
        }
    }

    public void postOrder(List<T> order) {
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).postOrder(order);
        }
        if (children.size() >= 2) {
            ((BinaryNode<T>) children.get(1)).postOrder(order);
        }
        order.add(data);
    }

    public void eulerOrder(List<T> order) {
        order.add(data);
        if (!children.isEmpty()) {
            ((BinaryNode<T>) children.get(0)).eulerOrder(order);
        }
        if (children.size() >= 2) {
            ((BinaryNode<T>) children.get(1)).eulerOrder(order);
        }
        order.add(data);
    }
}
