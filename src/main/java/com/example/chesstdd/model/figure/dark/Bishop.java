package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Tail;
import com.example.chesstdd.model.figure.Figure;
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
    @Setter
    private int position;

    @Getter
    Color color;

    @Getter
    @Setter
    private int widthPosition;

    @Getter
    @Setter
    private int heightPosition;


    List<List<Integer>> figureMoves = Arrays.asList(
            Arrays.asList(1,1),
            Arrays.asList(2,2),
            Arrays.asList(3,3),
            Arrays.asList(4,4),
            Arrays.asList(5,5),
            Arrays.asList(6,6),
            Arrays.asList(7,7),
            Arrays.asList(1,-1),
            Arrays.asList(2,-2),
            Arrays.asList(3,-3),
            Arrays.asList(4,-4),
            Arrays.asList(5,-5),
            Arrays.asList(6,-6),
            Arrays.asList(7,-7),
            Arrays.asList(-1,1),
            Arrays.asList(-2,2),
            Arrays.asList(-3,3),
            Arrays.asList(-4,4),
            Arrays.asList(-5,5),
            Arrays.asList(-6,6),
            Arrays.asList(-7,7),
            Arrays.asList(-1,-1),
            Arrays.asList(-2,-2),
            Arrays.asList(-3,-3),
            Arrays.asList(-4,-4),
            Arrays.asList(-5,-5),
            Arrays.asList(-6,-6),
            Arrays.asList(-7,-7)
    );

    public List<Tail> possibleMoves(List<Tail> tails) {
        List<Tail> possibleTalesForMove = new ArrayList<>();
        for (int i = 0; i < figureMoves.size(); i++) {
            List<Integer> move = figureMoves.get(i);
            int newWidth = widthPosition+move.get(0);
            int newHeight = heightPosition+move.get(1);
            for (Tail tail:tails){
                if (tail.getTailWidth()==newWidth&&tail.getTailHeight()==newHeight){
                    possibleTalesForMove.add(tail);
                }
            }
        }

        return possibleTalesForMove;
    }

    public Tail tailForTheMove(List<Tail> tails){
        List<Tail> possibleMoves = possibleMoves(tails);
        Random rand = new Random();
        Tail move = possibleMoves.get(rand.nextInt(possibleMoves.size()));
        return move;
    }

    public Bishop(int id, int position, Color color, int widthPosition, int heightPosition) {
        this.id = id;
        this.position = position;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
    }
}
