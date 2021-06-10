package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;

import java.util.List;

public interface Figure {
    int getId();
    int getPosition();
    void setPosition(int i);
    Color getColor();
    int getHeightPosition();
    void setHeightPosition(int i);
    int getWidthPosition();
    void setWidthPosition(int i);
    List<List<Integer>> possibleMoves();
    List<Integer> coordinatesForTheMove();


}
