package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;


public class King extends Figures {

    @Getter
    List<List<Integer>> figureMoves = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 0),
            Arrays.asList(0, -1),
            Arrays.asList(-1, 0),
            Arrays.asList(1, 1),
            Arrays.asList(1, -1),
            Arrays.asList(-1, 1),
            Arrays.asList(-1, -1));

    public King(int id, Color color, int widthPosition, int heightPosition, String logo) {
        super(id, color, widthPosition, heightPosition, logo);
    }
}









