package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.example.chesstdd.model.Tail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Figures {
    @JsonIgnore
    @Getter
    final List<Coordinates> figureMoves;

    public Pawn(int id, Color color, Coordinates coordinates, String logo) {
        super(id, color, coordinates, logo);
        this.figureMoves = figureMovesSender();
    }

    public List<Coordinates> figureMovesSender() {
        List<Coordinates> figureMoves = null;
        if (super.getColor().equals(Color.WHITE)) {
            figureMoves = Arrays.asList(
                    new Coordinates(0, 2),
                    new Coordinates(0, 1),
                    new Coordinates(1, 1),
                    new Coordinates(-1, 1));

        }
        if (super.getColor().equals(Color.DARK)) {
            figureMoves = Arrays.asList(
                    new Coordinates(0, -2),
                    new Coordinates(0, -1),
                    new Coordinates(1, -1),
                    new Coordinates(-1, -1));

        }
        return figureMoves;
    }

    /**
     * @param tails - tails minus tails with figures of the same color.
     * @return List of tails where a figure can make a move
     */

    @Override
    public List<Tail> possibleMoves(List<Tail> tails) {
        List<Tail> possibleTalesForMove = new ArrayList<>();
        for (int i = 0; i < figureMoves.size(); i++) {
            Coordinates moveCoordinates = figureMoves.get(i);
//            List<Integer> move = figureMoves.get(i);
            Coordinates coordinates = new Coordinates();
            coordinates.setWidthPosition(coordinates.getWidthPosition()+moveCoordinates.getWidthPosition());
            coordinates.setHeightPosition(coordinates.getHeightPosition()+moveCoordinates.getHeightPosition());
//            int newWidth = widthPosition + move.get(0);
//            int newHeight = heightPosition + move.get(1);
            for (Tail tail : tails) {
                if (tail.getCoordinates().equals(coordinates))
                if (tail.getCoordinates().equals(coordinates)&&i==0&&tail.getFigure()==null) {
                    possibleTalesForMove.add(tail);
                    break;
                }
                else if (tail.getCoordinates().equals(coordinates)&&i>0&&!(tail.getFigure()==null)){
                    possibleTalesForMove.add(tail);
                    break;
                }
            }
        }
        super.setTailsToMove(possibleTalesForMove);
        return possibleTalesForMove;
    }



}
