package com.example.chesstdd.model.figure;

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

@AllArgsConstructor
@NoArgsConstructor
public class Bishop implements Figure {

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
    private List<Tail> tailsToMove;

    private List<List<Integer>> figureMoves = Arrays.asList(
            Arrays.asList(1, 1),
            Arrays.asList(2, 2),
            Arrays.asList(3, 3),
            Arrays.asList(4, 4),
            Arrays.asList(5, 5),
            Arrays.asList(6, 6),
            Arrays.asList(7, 7),
            Arrays.asList(1, -1),
            Arrays.asList(2, -2),
            Arrays.asList(3, -3),
            Arrays.asList(4, -4),
            Arrays.asList(5, -5),
            Arrays.asList(6, -6),
            Arrays.asList(7, -7),
            Arrays.asList(-1, 1),
            Arrays.asList(-2, 2),
            Arrays.asList(-3, 3),
            Arrays.asList(-4, 4),
            Arrays.asList(-5, 5),
            Arrays.asList(-6, 6),
            Arrays.asList(-7, 7),
            Arrays.asList(-1, -1),
            Arrays.asList(-2, -2),
            Arrays.asList(-3, -3),
            Arrays.asList(-4, -4),
            Arrays.asList(-5, -5),
            Arrays.asList(-6, -6),
            Arrays.asList(-7, -7)
    );

    public List<Tail> possibleMoves(List<Tail> tails) {
        List<Tail> possibleTalesForMove = new ArrayList<>();
        for (List<Integer> move : figureMoves) {
            int newWidth = widthPosition + move.get(0);
            int newHeight = heightPosition + move.get(1);
            for (Tail tail : tails) {
                if (tail.getTailWidth() == newWidth && tail.getTailHeight() == newHeight) {
                    possibleTalesForMove.add(tail);
                    break;
                }
            }
        }
        tailsToMove = possibleTalesForMove;
        return possibleTalesForMove;
    }

    public List<Integer> coordinateForTheMove() {
        Random random = new Random();
        Tail tail = this.tailsToMove.get(random.nextInt(this.tailsToMove.size()));

        int widthPosition = tail.getTailWidth();
        int heightPosition = tail.getTailHeight();
        return Arrays.asList(widthPosition, heightPosition);
    }

    public Bishop(int id, Color color, int widthPosition, int heightPosition, String logo) {
        this.id = id;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
        this.logo = logo;
    }
}
