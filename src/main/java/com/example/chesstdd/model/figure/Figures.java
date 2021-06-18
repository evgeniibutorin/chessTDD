package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Tail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Figures {

    @Getter
    private int id;

    @Getter
    private Color color;

    @Getter
    @Setter
    private int widthPosition;

    @Getter
    @Setter
    private int heightPosition;

    @Getter
    private String logo;

    @JsonIgnore
    @Getter
    @Setter
    private List<Tail> tailsToMove;

    public abstract List<List<Integer>> getFigureMoves();

    public List<Tail> possibleMoves(List<Tail> tails) {
        List<Tail> possibleTalesForMove = new ArrayList<>();
        List<List<Integer>> moves = getFigureMoves();
        for (List<Integer> move : moves) {
            int newWidth = widthPosition + move.get(0);
            int newHeight = heightPosition + move.get(1);
            for (Tail tail : tails) {
                if (tail.getTailWidth() == newWidth && tail.getTailHeight() == newHeight) {
                    possibleTalesForMove.add(tail);
                    break;
                }
            }
        }
        setTailsToMove(possibleTalesForMove);
        return possibleTalesForMove;
    }

    public List<Integer> coordinateForTheMove() {
        Random random = new Random();
        Tail tail = getTailsToMove().get(random.nextInt(getTailsToMove().size()));

        int widthPosition = tail.getTailWidth();
        int heightPosition = tail.getTailHeight();
        return Arrays.asList(widthPosition, heightPosition);
    }

    public Figures(int id, Color color, int widthPosition, int heightPosition, String logo) {
        this.id = id;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
        this.logo = logo;
    }


}