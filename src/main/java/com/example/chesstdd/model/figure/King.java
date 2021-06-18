package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class King extends Figures {
    @JsonIgnore
    @Getter
    final List<Coordinates> figureMoves = Arrays.asList(
            new Coordinates(0, 1),
            new Coordinates(1, 0),
            new Coordinates(0, -1),
            new Coordinates(-1, 0),
            new Coordinates(1, 1),
            new Coordinates(1, -1),
            new Coordinates(-1, 1),
            new Coordinates(-1, -1));

    public King(int id, Color color, Coordinates coordinates, String logo) {
        super(id, color, coordinates, logo);
    }
}









