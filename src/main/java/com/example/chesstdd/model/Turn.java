package com.example.chesstdd.model;

import org.springframework.stereotype.Component;

@Component
public class Turn {

    private boolean isFigureWhite;

    public Color toggleAndGet() {
        isFigureWhite = !isFigureWhite;
        return isFigureWhite ? Color.WHITE : Color.DARK;
    }

    public void setFigureTurn() {
        isFigureWhite = false;
    }
}
