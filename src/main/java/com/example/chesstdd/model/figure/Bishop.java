package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;

import java.util.Arrays;
import java.util.List;

public class Bishop extends Figures {

    public Bishop(int id, Color color, int widthPosition, int heightPosition, String logo) {
        super(id, color, widthPosition, heightPosition, logo);
    }


    List<List<Integer>> figureMoves = Arrays.asList(
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

    @Override
    public List<List<Integer>> getFigureMoves() {
        return figureMoves;
    }

}
