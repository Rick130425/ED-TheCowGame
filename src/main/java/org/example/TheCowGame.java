package org.example;

import org.example.trees.binaryTree.BinaryNode;
import org.example.trees.binaryTree.BinaryTree;
import org.example.trees.naryTree.NaryNode;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Implementa la lógica principal del juego de la Vaca.
 * El juego intenta adivinar el animal en el que el usuario está pensando a través de una serie de preguntas.
 */
public class TheCowGame {
    private BinaryTree<DecisionNode> decisionTree;
    private final Scanner input = new Scanner(System.in);

    /**
     * Constructor que carga el árbol de decisiones desde un archivo o crea uno nuevo si no existe.
     *
     * @param path Ruta del archivo que contiene el árbol de decisiones.
     */
    public TheCowGame(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            decisionTree = (BinaryTree<DecisionNode>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            decisionTree = new BinaryTree<>(new DecisionNode("¿Tiene cuernos?", null));
            decisionTree.getRoot().addChild(new BinaryNode<>(new DecisionNode(null, "Vaca")));
            decisionTree.getRoot().addChild(new BinaryNode<>(new DecisionNode(null, "Gato")));
        }
    }

    /**
     * Inicia el juego y continúa hasta que el usuario decida salir.
     */
    public void start() {
        System.out.println("Bienvenido al juego de la Vaca.");
        int answer;
        do {
            System.out.println("""
                    -------------------------------
                    Responde las preguntas e intentaré adivinar tu animal.
                    """);
            askNode(decisionTree.getRoot());
            System.out.println();
            System.out.print("""
                    ¿Desea jugar de nuevo?
                    1) Sí
                    2) No
                    R: """);
            answer = input.nextInt();
        } while (answer == 1);
        saveDecisionTree();
    }

    /**
     * Guarda el árbol de decisiones en un archivo.
     */
    private void saveDecisionTree() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("decisionTree.ser"))) {
            oos.writeObject(decisionTree);
        } catch (IOException e) {
            System.err.println("Error al guardar el árbol de decisiones: " + e.getMessage());
        }
    }

    /**
     * Realiza preguntas al usuario y navega por el árbol de decisiones para adivinar el animal.
     *
     * @param question Nodo actual del árbol de decisiones.
     */
    public void askNode(NaryNode<DecisionNode> question) {
        List<NaryNode<DecisionNode>> children = question.getChildren();
        int answer;

        System.out.println(question.getData());
        System.out.print("""
                1) Sí
                2) No
                R:\s""");

        answer = input.nextInt();
        System.out.println();

        // Consumir el carácter de nueva línea restante
        input.nextLine();

        if (children.get(answer - 1).getData().isQuestion()) {
            askNode(children.get(answer - 1));
        } else {
            System.out.printf("Tu animal: %s\n", children.get(answer - 1).getData());
            System.out.print("""
                    ¿Acerté?
                    1) Sí
                    2) No
                    R:\s""");

            int isCorrect = input.nextInt();

            // Consumir el carácter de nueva línea restante
            input.nextLine();

            switch (isCorrect) {
                case 1:
                    break;
                case 2:
                    String[] info = new String[2];
                    NaryNode<DecisionNode> errAns = children.get(answer - 1);
                    BinaryNode<DecisionNode> newDecision;

                    System.out.println("¿Qué animal pensaste?: ");
                    info[0] = input.nextLine();
                    System.out.println("¿Qué lo diferencia?: ");
                    info[1] = input.nextLine();

                    newDecision = new BinaryNode<>(new DecisionNode(String.format("¿%s?", info[1]), null));
                    newDecision.addChild(new BinaryNode<>(new DecisionNode(null, info[0])));
                    newDecision.addChild(errAns);

                    question.removeChild(children.get(answer - 1));
                    question.addChild(newDecision, answer - 1);
                    break;
                default:
                    System.out.println("Respuesta no válida.");
                    break;
            }
        }
    }
}
