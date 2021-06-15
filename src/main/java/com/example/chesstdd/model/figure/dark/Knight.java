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
public class Knight implements Figure {

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
    @JsonIgnore
    private List<Tail> tailsToMove;


    @Getter
    private String logo;

    List<List<Integer>> figureMoves = Arrays.asList(
            Arrays.asList(-2, 1),
            Arrays.asList(-1,2),
            Arrays.asList(1,2),
            Arrays.asList(2,1),
            Arrays.asList(2,-1),
            Arrays.asList(1,-2),
            Arrays.asList(-1,-2),
            Arrays.asList(-2,-1));

    /**
     * @param tails - tails minus tails with figures of the same color.
     * @return
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
        this.tailsToMove=possibleTalesForMove;
        return possibleTalesForMove;
    }

    /**
     * Change figure coordinate
     * @param tail - target tails to move
     */
        public List<Integer> coordinateForTheMove() {
            Random random = new Random();
            Tail tail = this.tailsToMove.get(random.nextInt(this.tailsToMove.size()));

            int widthPosition = tail.getTailWidth();
            int heightPosition = tail.getTailHeight();
            return Arrays.asList(widthPosition,heightPosition);
    }

    public Knight(int id, Color color, int widthPosition, int heightPosition, String logo) {
        this.id = id;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
        this.logo = logo;
    }
}
