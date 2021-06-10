package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class King implements Figure {

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
            Arrays.asList(0,1),
            Arrays.asList(1,0),
            Arrays.asList(0,-1),
            Arrays.asList(-1,0),
            Arrays.asList(1,1),
            Arrays.asList(1,-1),
            Arrays.asList(-1,1),
            Arrays.asList(-1,-1));

    @Override
    public List<List<Integer>> possibleMoves() {
        return null;
    }

    @Override
    public List<Integer> coordinatesForTheMove() {
        return null;
    }

    public King(int id, int position, Color color, int widthPosition, int heightPosition) {
        this.id = id;
        this.position = position;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
    }
}
