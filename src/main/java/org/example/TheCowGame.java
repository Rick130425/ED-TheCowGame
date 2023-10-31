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
        // Intenta cargar el árbol de decisiones desde un archivo.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            decisionTree = (BinaryTree<DecisionNode>) ois.readObject();
        // Si no puede cargarlo, crea un árbol de decisiones predeterminado.
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
        // Muestra el mensaje de bienvenida.
        System.out.println("Bienvenido al juego de la Vaca.");
        int answer;
        // Bucle principal del juego.
        do {
            System.out.println("""
                    -------------------------------
                    Responde las preguntas e intentaré adivinar tu animal.
                    """);
            // Se llama a la función de pregunta, dándo de parámetro el nodo raíz
            askNode(decisionTree.getRoot());
            System.out.println();
            // Se pregunta si se desea continuar
            System.out.print("""
                    ¿Desea jugar de nuevo?
                    1) Sí
                    2) No
                    R:\s""");
            answer = input.nextInt();
        } while (answer == 1);
        // Guarda el árbol de decisiones al finalizar.
        saveDecisionTree();
    }

    /**
     * Guarda el árbol de decisiones en un archivo.
     */
    private void saveDecisionTree() {
        // Intenta guardar el árbol de decisiones en un archivo.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("decisionTree.ser"))) {
            oos.writeObject(decisionTree);
        // Si ocurre un error, se muestra un mensaje
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
        // Se guardan los hijos de la pregunta
        List<NaryNode<DecisionNode>> children = question.getChildren();
        int answer;

        // Se imprime la pregunta
        System.out.println(question.getData());
        // Se pregunta si sí o no
        System.out.print("""
                1) Sí
                2) No
                R:\s""");

        answer = input.nextInt();
        System.out.println();

        // Consumir el carácter de nueva línea restante
        input.nextLine();

        // Si el nodo correspondiente (a la respuesta) es una pregunta
        if (children.get(answer - 1).getData().isQuestion()) {
            // Se llama a la función de pregunta
            askNode(children.get(answer - 1));
        // Si no
        } else {
            // Se imprime el animal correspondiente
            System.out.printf("Tu animal: %s\n", children.get(answer - 1).getData());
            // Y se pregunta si se acertó
            System.out.print("""
                    ¿Acerté?
                    1) Sí
                    2) No
                    R:\s""");

            int isCorrect = input.nextInt();

            // Consumir el carácter de nueva línea restante
            input.nextLine();

            switch (isCorrect) {
                // Si la respuesta en Sí
                case 1:
                    // Se imprime que ganó
                    System.out.println("¡Gané! :D");
                    break;
                // Si la respuesta es No
                case 2:
                    // Se declara un arreglo para guardar la información
                    String[] info = new String[2];
                    // Se guarda la respuesta errónea
                    NaryNode<DecisionNode> errAns = children.get(answer - 1);
                    // Se declara newDecision
                    BinaryNode<DecisionNode> newDecision;

                    // Se pregunta el animal pensado
                    System.out.println("¿Qué animal pensaste?: ");
                    // Se guarda
                    info[0] = input.nextLine();
                    // Se pregunta la diferencia
                    System.out.println("¿Qué lo diferencia?: ");
                    // Se guarda
                    info[1] = input.nextLine();

                    // Se asigna newDecision con la pregunta (hecha con base en la diferencia)
                    newDecision = new BinaryNode<>(new DecisionNode(String.format("¿%s?", info[1]), null));
                    // Se agrega como hijo el animal pensado
                    newDecision.addChild(new BinaryNode<>(new DecisionNode(null, info[0])));
                    // Y luego el animal erróneo
                    newDecision.addChild(errAns);

                    // Se remueve el 2do hijo de la pregunta
                    question.removeChild(children.get(answer - 1));
                    // Y se guarda como hijo newDecision
                    question.addChild(newDecision, answer - 1);
                    break;
                // Si no es ninguno de los anteriores
                default:
                    // Se imprime que la respuesta no es válida
                    System.out.println("Respuesta no válida.");
                    break;
            }
        }
    }
}
