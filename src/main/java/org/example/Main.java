package org.example;

import org.example.trees.binaryTree.BinaryNode;
import org.example.trees.binaryTree.BinaryTree;
import org.example.trees.naryTree.NaryNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de nodo
        List<BinaryNode<Integer>> nodes = new ArrayList<>();
        // Declaración de nodos
        for (int i = 1; i <= 17; i++) {
            nodes.add(new BinaryNode<>(i));
        }

        // Declaración de árbol binario
        BinaryTree<Integer> binaryTree = new BinaryTree<>(nodes.get(0));

        // Lista de nodos para agregación de nodos
        List<BinaryNode<Integer>> list = new ArrayList<>();
        // Se agrega el nodo raíz
        list.add((BinaryNode<Integer>) binaryTree.getRoot());

        // Variable de rastréo de index
        int i = 1;
        do {
            // Lista temporal
            List<BinaryNode<Integer>> tempList = new ArrayList<>();
            // Por cada nodo de la lista de agregación
            for (NaryNode<Integer> node: list) {
                // Se agregan dos nodos
                for (int j = 0; j < 2; j++) {
                    if (i < 17) {
                        // Se agrega el nodo
                        node.addChild(nodes.get(i));
                        // Y se guarda en la lista temporal
                        tempList.add(nodes.get(i++));
                    }
                }
            }
            // Se remplaza la lista de asignación por la lista temporal
            list = tempList;
        // Mientras no se hayan guardado todos los nodos, se repite lo anterior
        } while(i < 17);

        // Se imprime el camino pre-orden
        System.out.println(binaryTree.preOrder());
        // Se imprime el camino in-orden
        System.out.println(binaryTree.inOrder());
        // Se imprime el camino post-orden
        System.out.println(binaryTree.postOrder());
        // Se imprime el camino de Euler
        System.out.println(binaryTree.eulerOrder());
    }
}