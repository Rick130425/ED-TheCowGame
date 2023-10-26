package org.example;

/**
 * Punto de entrada principal para el juego TheCowGame.
 */
public class Main {

    /**
     * Método principal que inicia el juego.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        TheCowGame game = new TheCowGame("decisionTree.ser");
        game.start();
    }
}