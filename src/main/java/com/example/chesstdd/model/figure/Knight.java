package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Knight extends Figures {
    @JsonIgnore
    @Getter
    final List<Coordinates> figureMoves = Arrays.asList(
            new Coordinates(-2, 1),
            new Coordinates(-1, 2),
            new Coordinates(1, 2),
            new Coordinates(2, 1),
            new Coordinates(2, -1),
            new Coordinates(1, -2),
            new Coordinates(-1, -2),
            new Coordinates(-2, -1));

    public Knight(int id, Color color, Coordinates coordinates, String logo) {
        super(id, color, coordinates, logo);
    }

}
