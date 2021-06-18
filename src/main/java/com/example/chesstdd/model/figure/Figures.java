package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.example.chesstdd.model.Tail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Figures {
    @JsonIgnore
    @Getter
    private final int id;
    @JsonIgnore
    @Getter
    private final Color color;

    @Getter
    @Setter
    @JsonIgnore
    private Coordinates coordinates;

    @Getter
    private final String logo;

    @JsonIgnore
    @Getter
    @Setter
    private List<Tail> tailsToMove;

    public abstract List<Coordinates> getFigureMoves();

    public List<Tail> possibleMoves(List<Tail> tails) {
        List<Tail> possibleTalesForMove = new ArrayList<>();
        List<Coordinates> moves = getFigureMoves();
        for (Coordinates move : moves) {
            Coordinates newCoordinates = new Coordinates(
                    coordinates.getWidthPosition() + move.getWidthPosition(),
                    coordinates.getHeightPosition() + move.getHeightPosition());
            for (Tail tail : tails) {
                if (tail.getCoordinates().equals(newCoordinates)) {
                    possibleTalesForMove.add(tail);
                    break;
                }
            }
        }
        setTailsToMove(possibleTalesForMove);
        return possibleTalesForMove;
    }

    public Coordinates coordinateForTheMove() {
        Random random = new Random();
        return getTailsToMove().get(random.nextInt(getTailsToMove().size())).getCoordinates();
    }

    public Figures(int id, Color color, Coordinates coordinates, String logo) {
        this.id = id;
        this.color = color;
        this.coordinates = coordinates;
        this.logo = logo;
    }


}