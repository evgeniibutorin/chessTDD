package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Knight extends Figures {
    @JsonIgnore
    @Getter
    final List<List<Integer>> figureMoves = Arrays.asList(
            Arrays.asList(-2, 1),
            Arrays.asList(-1, 2),
            Arrays.asList(1, 2),
            Arrays.asList(2, 1),
            Arrays.asList(2, -1),
            Arrays.asList(1, -2),
            Arrays.asList(-1, -2),
            Arrays.asList(-2, -1));

    public Knight(int id, Color color, int widthPosition, int heightPosition, String logo) {
        super(id, color, widthPosition, heightPosition, logo);
    }

}
