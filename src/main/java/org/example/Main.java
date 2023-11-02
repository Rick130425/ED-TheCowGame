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
        // Crea una instancia del juego TheCowGame.
        TheCowGame game = new TheCowGame();
        // Inicia el juego.
        game.start();
    }
}