package org.example;

import org.example.trees.binaryTree.BinaryNode;
import org.example.trees.binaryTree.BinaryTree;
import org.example.trees.naryTree.NaryNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BinaryNode<Integer>> nodes = new ArrayList<>();
        for (int i = 1; i <= 17; i++) {
            nodes.add(new BinaryNode<>(i));
        }

        BinaryTree<Integer> binaryTree = new BinaryTree<>(nodes.get(0));

        List<BinaryNode<Integer>> list = new ArrayList<>();
        list.add((BinaryNode<Integer>) binaryTree.getRoot());

        int i = 1;
        do {
            List<BinaryNode<Integer>> tempList = new ArrayList<>();
            for (NaryNode<Integer> node: list) {
                for (int j = 0; j < 2; j++) {
                    if (i < 17) {
                        node.addChild(nodes.get(i));
                        tempList.add(nodes.get(i++));
                    }
                }
            }
            list = tempList;
        } while(i < 17

        );

        System.out.println(binaryTree.preOrder());
        System.out.println(binaryTree.inOrder());
        System.out.println(binaryTree.postOrder());
        System.out.println(binaryTree.eulerOrder());
    }
}