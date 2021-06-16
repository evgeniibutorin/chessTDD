package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Tail;
import com.example.chesstdd.model.figure.Figure;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
public class Pawn implements Figure {
    @Getter
    private int id;

    @Getter
    Color color;

    @Getter
    @Setter
    private int widthPosition;

    @Getter
    @Setter
    private int heightPosition;

    @Getter
    private String logo;

    @Getter
    @JsonIgnore
    private List<Tail> tailsToMove;

    public Pawn(int id, Color color, int widthPosition, int heightPosition, String logo) {
        this.id = id;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
        this.logo = logo;
        this.figureMoves = figureMovesSender();
    }

    List<List<Integer>> figureMoves;

    public List<List<Integer>> figureMovesSender(){
        List<List<Integer>> figureMoves = null;
        if (color.equals(Color.WHITE)){
            figureMoves = Arrays.asList(Arrays.asList(0, 2),
                    Arrays.asList(0,1),
                    Arrays.asList(1,1),
                    Arrays.asList(-1,1));

        }
        if (color.equals(Color.DARK)){
            figureMoves = Arrays.asList(Arrays.asList(0, -2),
                    Arrays.asList(0,-1),
                    Arrays.asList(1,-1),
                    Arrays.asList(-1,-1));

        }
            return figureMoves;
    }

    /**
     * @param tails - tails minus tails with figures of the same color.
     * @return List of tails where a figure can make a move
     */
    public List<Tail> possibleMoves(List<Tail> tails) {
        List<Tail> possibleTalesForMove = new ArrayList<>();
        for (int i = 0; i < figureMoves.size(); i++) {
            List<Integer> move = figureMoves.get(i);
            int newWidth = widthPosition + move.get(0);
            int newHeight = heightPosition + move.get(1);
            for (Tail tail : tails) {
                if (tail.getTailWidth() == newWidth && tail.getTailHeight() == newHeight) {
                    possibleTalesForMove.add(tail);
                    break;
                }
            }
        }
        tailsToMove=possibleTalesForMove;
        return possibleTalesForMove;
    }

    public List<Integer> coordinateForTheMove() {
        Random random = new Random();
        Tail tail = this.tailsToMove.get(random.nextInt(this.tailsToMove.size()));

        int widthPosition = tail.getTailWidth();
        int heightPosition = tail.getTailHeight();
        return Arrays.asList(widthPosition,heightPosition);
    }


}
