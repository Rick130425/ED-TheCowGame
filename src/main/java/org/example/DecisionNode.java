package org.example;

import java.io.Serializable;

public record DecisionNode(String question, String answer) implements Serializable {
    public boolean isQuestion(){
        return question != null;
    }

    @Override
    public String toString() {
        return isQuestion() ? question : answer;
    }
}
