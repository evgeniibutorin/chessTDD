package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Bishop extends Figures {

    public Bishop(int id, Color color, Coordinates coordinates, String logo) {
        super(id, color, coordinates, logo);
    }
    @JsonIgnore
    @Getter
    final List<Coordinates> figureMoves = Arrays.asList(
            new Coordinates(1, 1),
            new Coordinates(2, 2),
            new Coordinates(3, 3),
            new Coordinates(4, 4),
            new Coordinates(5, 5),
            new Coordinates(6, 6),
            new Coordinates(7, 7),
            new Coordinates(1, -1),
            new Coordinates(2, -2),
            new Coordinates(3, -3),
            new Coordinates(4, -4),
            new Coordinates(5, -5),
            new Coordinates(6, -6),
            new Coordinates(7, -7),
            new Coordinates(-1, 1),
            new Coordinates(-2, 2),
            new Coordinates(-3, 3),
            new Coordinates(-4, 4),
            new Coordinates(-5, 5),
            new Coordinates(-6, 6),
            new Coordinates(-7, 7),
            new Coordinates(-1, -1),
            new Coordinates(-2, -2),
            new Coordinates(-3, -3),
            new Coordinates(-4, -4),
            new Coordinates(-5, -5),
            new Coordinates(-6, -6),
            new Coordinates(-7, -7)
    );
}
