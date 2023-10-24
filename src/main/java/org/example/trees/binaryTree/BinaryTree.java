package org.example.trees.binaryTree;

import org.example.trees.naryTree.NaryNode;
import org.example.trees.naryTree.NaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> extends NaryTree<T> {
    public BinaryTree(T rootData) {
        super(rootData);
        this.root = new BinaryNode<>(rootData);
    }

    public BinaryTree(BinaryNode<T> root) {
        super(root);
    }

    @Override
    public void setRoot(NaryNode<T> newRoot) {
        if (!(newRoot instanceof BinaryNode)) {
            throw new IllegalArgumentException("The root must be an instance of BinaryNode.");
        }
        this.root = newRoot;
    }

    public List<T> preOrder() {
        List<T> order = new ArrayList<>();
        ((BinaryNode<T>) root).preOrder(order);

        return order;
    }

    public List<T> inOrder() {
        List<T> order = new ArrayList<>();
        ((BinaryNode<T>) root).inOrder(order);

        return order;
    }

    public List<T> postOrder() {
        List<T> order = new ArrayList<>();
        ((BinaryNode<T>) root).postOrder(order);

        return order;
    }


    public List<T> eulerOrder() {
        List<T> order = new ArrayList<>();
        ((BinaryNode<T>) root).eulerOrder(order);

        return order;
    }
}
