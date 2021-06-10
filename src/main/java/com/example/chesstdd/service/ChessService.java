package com.example.chesstdd.service;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Tail;
import com.example.chesstdd.model.figure.Figure;
import com.example.chesstdd.model.figure.dark.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.chesstdd.model.Color.DARK;
import static com.example.chesstdd.model.Color.WHITE;

public class ChessService {

    private int tern = 0;

    List<Figure> figures = createFigure();
    List<Tail> tails = setCoordinate(tailIdAndFigureIdCreator());



    public List<Tail> tailIdAndFigureIdCreator() {
        List<Tail> board = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            Figure figure = null;
            if (i < 16 || i > 47) {
                figure = figures.get(i);
            }
            board.add(new Tail(i, figure));
        }
        return board;
    }

    public List<Tail> setCoordinate(List<Tail> list) {
        List<Tail> supplementedTileList = list;
        for (int i = 0; i < supplementedTileList.size(); i++) {
            int width = i;
            int height = 0;
            if (i > 7 && i < 16){ height = 1; width = i-8;}
            if (i > 15 && i < 24){ height = 2; width = i-16;}
            if (i > 23 && i < 32){ height = 3;width = i-24;}
            if (i > 31 && i < 40){ height = 4;width = i-32;}
            if (i > 39 && i < 48){ height = 5;width = i-40;}
            if (i > 47 && i < 56){ height = 6;width = i-48;}
            if (i > 55 && i < 64){ height = 7;width = i-56;}
            Tail tail = supplementedTileList.get(i);
            tail.setTailWidth(width);
            tail.setTailHeight(height);
        }
        return supplementedTileList;
    }

    public List<Figure> createFigure() {
        List<Figure> board = new ArrayList<>();
        board.add(new Rook(0,0,WHITE,0,1));
        for (int i = 0; i < 64; i++) {
            if (i == 0 || i == 7) {
                int width = i;
                int height = 0;
                board.add(new Rook(i,i,WHITE,width,height));
            } else if (i == 1 || i == 6) {
                int width = i;
                int height = 0;
                board.add(new Knight(i,i,WHITE,width,height));
            } else if (i == 2 || i == 5) {
                int width = i;
                int height = 0;
                board.add(new Bishop(i,i,WHITE,width,height));
            } else if (i == 3) {
                board.add(new King(i,i,WHITE,3,0));
            } else if (i == 4) {
                board.add(new Pawn(i, i, WHITE,4,0));
            } else if (i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15) {
                int width = i;
                int height = 1;
                board.add(new Queen(i, i, WHITE,width,height));
            } else if (i == 56 || i == 63) {
                int width = i-56;
                int height = 7;
                board.add(new Rook(i, i, DARK,width,height));
            } else if (i == 57 || i == 62) {
                int width = i-56;
                int height = 7;
                board.add(new Knight(i, i, DARK,width,height));
            } else if (i == 58 || i == 61) {
                int width = i-56;
                int height = 7;
                board.add(new Bishop(i, i, DARK,width,height));
            } else if (i == 59) {
                board.add(new King(i, i, DARK,3,7));
            } else if (i == 60) {
                board.add(new Queen(i, i, DARK,4,7));
            } else if (i == 48 || i == 49 || i == 50 || i == 51 || i == 52 || i == 53 || i == 54 || i == 55) {
                int width = i -48;
                int height = 6;
                width++;
                board.add(new Pawn(i, i, WHITE,width,height));

            }
            for (int q = 0; q<board.size();q++){

            }

        }
        return board;
    }

    public List<Tail> getTailsWithoutBlackFigure(List<Tail> tailsWithAllFigures){
        List<Tail> tailsWithoutBlackFigure = new ArrayList<>();
        for (Tail tail:tailsWithAllFigures){
            if (tail.getFigure()==null || tail.getFigure().getId()<48){
                tailsWithoutBlackFigure.add(tail);
            }
        }
        return tailsWithoutBlackFigure;
    }

    public List<Tail> getTailsWithoutWhiteFigure(List<Tail> tailsWithAllFigures) {
        List<Tail> tailsWithoutWhiteFigure = new ArrayList<>();
        for (Tail tail : tailsWithAllFigures) {
            if (tail.getFigure() == null || !(tail.getFigure().getId() > 0 && tail.getFigure().getId() < 16)) {
                tailsWithoutWhiteFigure.add(tail);
            }
        }
        return tailsWithoutWhiteFigure;
    }

    public List<Figure> getWhiteFigures(List<Figure> figures) {
        List<Figure> whiteFigures = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getColor() == WHITE) {
                whiteFigures.add(figure);
            }
        }
        return whiteFigures;
    }

    public List<Figure> getBlackFigures(List<Figure> figures) {
        List<Figure> blackFigures = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getColor() == WHITE) {
                blackFigures.add(figure);
            }
        }
        return blackFigures;
    }

    public Figure getRandomFigure() {
        Random random = new Random();
        List<Figure> list;
        Figure figure;
        if (tern % 2 == 0) {
            list = getWhiteFigures(figures);
            figure = list.get(random.nextInt(list.size()));
        }
        else {
            list = getBlackFigures(figures);
            figure = list.get(random.nextInt(list.size()));
        }
        return figure;
    }

    public void move(List<Tail> tails) {
        Figure figure = getRandomFigure();
        List<Tail> bordWithoutTailWithoutSimilarColorFigures;
        if (tern % 2 == 0) { bordWithoutTailWithoutSimilarColorFigures = getTailsWithoutWhiteFigure(tails);}
        else { bordWithoutTailWithoutSimilarColorFigures = getTailsWithoutBlackFigure(tails);}
        tern++;
        List<List<Integer>> moves = figure.possibleMoves();


    }


}
