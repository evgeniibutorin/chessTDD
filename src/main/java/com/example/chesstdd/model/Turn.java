package com.example.chesstdd.model;

import org.springframework.stereotype.Component;

@Component
public class Turn {

    private boolean isFigureWhite = false;

    public boolean isFigureTern() {
        isFigureWhite = !isFigureWhite;
        return isFigureWhite;
    }


    public void setFigureTurn() {
        isFigureWhite = false;
    }

}
