package org.example;

import java.io.Serializable;

/**
 * Representa un nodo de decisión que puede contener una pregunta o una respuesta.
 * Utilizado en el juego para determinar el animal que el usuario está pensando.
 */
public record DecisionNode(String question, String answer) implements Serializable {

    /**
     * Determina si el nodo actual es una pregunta.
     *
     * @return true si el nodo contiene una pregunta, false en caso contrario.
     */
    public boolean isQuestion() {
        return question != null;
    }

    /**
     * Devuelve una representación en cadena del nodo.
     *
     * @return la pregunta si el nodo es una pregunta, de lo contrario la respuesta.
     */
    @Override
    public String toString() {
        return isQuestion() ? question : answer;
    }
}
