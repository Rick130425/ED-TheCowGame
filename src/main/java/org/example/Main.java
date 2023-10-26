package org.example;

import org.example.trees.binaryTree.BinaryNode;
import org.example.trees.binaryTree.BinaryTree;
import org.example.trees.naryTree.NaryNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TheCowGame game = new TheCowGame("decisionTree.ser");
        game.start();
    }
}