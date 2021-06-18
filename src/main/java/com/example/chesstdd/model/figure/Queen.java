package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Queen extends Figures {
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
            new Coordinates(-7, -7),
            new Coordinates(0, 1),
            new Coordinates(0, 2),
            new Coordinates(0, 3),
            new Coordinates(0, 4),
            new Coordinates(0, 5),
            new Coordinates(0, 6),
            new Coordinates(0, 7),
            new Coordinates(0, -1),
            new Coordinates(0, -2),
            new Coordinates(0, -3),
            new Coordinates(0, -4),
            new Coordinates(0, -5),
            new Coordinates(0, -6),
            new Coordinates(0, -7),
            new Coordinates(-1, 0),
            new Coordinates(-2, 0),
            new Coordinates(-3, 0),
            new Coordinates(-4, 0),
            new Coordinates(-5, 0),
            new Coordinates(-6, 0),
            new Coordinates(-7, 0),
            new Coordinates(-1, 0),
            new Coordinates(-2, 0),
            new Coordinates(-3, 0),
            new Coordinates(-4, 0),
            new Coordinates(-5, 0),
            new Coordinates(-6, 0),
            new Coordinates(-7, 0)
    );

    public Queen(int id, Color color, Coordinates coordinates, String logo) {
        super(id, color, coordinates, logo);
    }

}
