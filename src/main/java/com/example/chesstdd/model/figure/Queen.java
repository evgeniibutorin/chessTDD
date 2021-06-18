package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Queen extends Figures {

    @Getter
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
            Arrays.asList(-7, -7),
            Arrays.asList(0, 1),
            Arrays.asList(0, 2),
            Arrays.asList(0, 3),
            Arrays.asList(0, 4),
            Arrays.asList(0, 5),
            Arrays.asList(0, 6),
            Arrays.asList(0, 7),
            Arrays.asList(0, -1),
            Arrays.asList(0, -2),
            Arrays.asList(0, -3),
            Arrays.asList(0, -4),
            Arrays.asList(0, -5),
            Arrays.asList(0, -6),
            Arrays.asList(0, -7),
            Arrays.asList(-1, 0),
            Arrays.asList(-2, 0),
            Arrays.asList(-3, 0),
            Arrays.asList(-4, 0),
            Arrays.asList(-5, 0),
            Arrays.asList(-6, 0),
            Arrays.asList(-7, 0),
            Arrays.asList(-1, 0),
            Arrays.asList(-2, 0),
            Arrays.asList(-3, 0),
            Arrays.asList(-4, 0),
            Arrays.asList(-5, 0),
            Arrays.asList(-6, 0),
            Arrays.asList(-7, 0)
    );

    public Queen(int id, Color color, int widthPosition, int heightPosition, String logo) {
        super(id, color, widthPosition, heightPosition, logo);
    }

}
