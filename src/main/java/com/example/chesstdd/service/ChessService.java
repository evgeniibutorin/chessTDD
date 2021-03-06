package com.example.chesstdd.service;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Coordinates;
import com.example.chesstdd.model.Tail;
import com.example.chesstdd.model.Turn;
import com.example.chesstdd.model.figure.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.chesstdd.model.Color.DARK;
import static com.example.chesstdd.model.Color.WHITE;

@Service
public class ChessService {


    private Turn turnToMove;

    private List<Figures> allFigures = createFigure();
    private List<Tail> allTails = setCoordinate(tailIdAndFigureIdCreator());

    public ChessService(Turn turnToMove) {
        this.turnToMove = turnToMove;
    }

    public List<Tail> tailIdAndFigureIdCreator() {
        List<Tail> board = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            Figures figures = null;
            if (i < 16 || i > 47) {
                for (Figures f : allFigures) {
                    if (f.getId() == i) {
                        figures = f;
                        break;
                    }
                }
            } else {
                figures = null;
            }
            board.add(new Tail(i, figures));
        }
        return board;
    }

    public List<Tail> setCoordinate(List<Tail> list) {
        List<Tail> supplementedTileList = list;
        for (int i = 0; i < supplementedTileList.size(); i++) {
            int width = i;
            int height = 0;
            if (i > 7 && i < 16) {
                height = 1;
                width = i - 8;
            }
            if (i > 15 && i < 24) {
                height = 2;
                width = i - 16;
            }
            if (i > 23 && i < 32) {
                height = 3;
                width = i - 24;
            }
            if (i > 31 && i < 40) {
                height = 4;
                width = i - 32;
            }
            if (i > 39 && i < 48) {
                height = 5;
                width = i - 40;
            }
            if (i > 47 && i < 56) {
                height = 6;
                width = i - 48;
            }
            if (i > 55 && i < 64) {
                height = 7;
                width = i - 56;
            }
            Tail tail = supplementedTileList.get(i);
            tail.setCoordinates(new Coordinates(width, height));
        }
        return supplementedTileList;
    }

    public List<Figures> createFigure() {
        List<Figures> board = new ArrayList<>();
        board.add(new Rook(0, WHITE, new Coordinates(0, 0), "???"));
        board.add(new Knight(1, WHITE, new Coordinates(1, 0), "???"));
        board.add(new Bishop(2, WHITE, new Coordinates(2, 0), "???"));
        board.add(new Queen(3, WHITE, new Coordinates(3, 0), "???"));
        board.add(new King(4, WHITE, new Coordinates(4, 0), "???"));
        board.add(new Bishop(5, WHITE, new Coordinates(5, 0), "???"));
        board.add(new Knight(6, WHITE, new Coordinates(6, 0), "???"));
        board.add(new Rook(7, WHITE, new Coordinates(7, 0), "???"));
        for (int i = 8; i < 16; i++) {
            int width = i - 8;
            int height = 1;
            board.add(new Pawn(i, WHITE, new Coordinates(width, height), "???"));
        }
        for (int j = 48; j < 56; j++) {
            int width = j - 48;
            int height = 6;
            board.add(new Pawn(j, DARK, new Coordinates(width, height), "???"));
        }
        board.add(new Rook(56, DARK, new Coordinates(0, 7), "???"));
        board.add(new Knight(57, DARK, new Coordinates(1, 7), "???"));
        board.add(new Bishop(58, DARK, new Coordinates(2, 7), "???"));
        board.add(new Queen(59, DARK, new Coordinates(3, 7), "???"));
        board.add(new King(60, DARK, new Coordinates(4, 7), "???"));
        board.add(new Bishop(61, DARK, new Coordinates(5, 7), "???"));
        board.add(new Knight(62, DARK, new Coordinates(6, 7), "???"));
        board.add(new Rook(63, DARK, new Coordinates(7, 7), "???"));
        return board;
    }

    /**
     * @param tailsWithAllFigures ?????? ????????????
     * @param currentColorFigures ?????? ???????????? ?? ???????? ???????????????? ??????????
     * @return
     */
    public List<Tail> getTailsWithoutCurrentColorFigure(List<Tail> tailsWithAllFigures, List<Figures> currentColorFigures) {
        List<Tail> tailsWithoutCurrentColorFigures = new ArrayList<>();
        for (Tail tail : tailsWithAllFigures) {
            if (tail.getFigure() == null || !currentColorFigures.contains(tail.getFigure())) {
                tailsWithoutCurrentColorFigures.add(tail);
            }
        }
        return tailsWithoutCurrentColorFigures;
    }

    public List<Figures> getCurrentColorFigures(List<Figures> figures, Color color) {
        List<Figures> currentColorFigures = new ArrayList<>();
        for (Figures figure : figures) {
            if (color.equals(figure.getColor())) {
                currentColorFigures.add(figure);
            }
        }
        return currentColorFigures;
    }

    /**
     * @param figures ???????????? ???????? ?????????? ?? ???????? ???????????????? ??????????
     * @return List of figures one color that can move.
     */
    public List<Figures> canMoveFigures(List<Figures> figures) {
        List<Figures> canMove = new ArrayList<>();
        List<Tail> tailsToCheck = getTailsWithoutCurrentColorFigure(allTails, figures);

        for (Figures figure : figures) {
            if (!figure.possibleMoves(tailsToCheck).isEmpty()) {
                canMove.add(figure);
            }
        }
        return canMove;
    }

    /**
     * @param listFiguresThatCanMove result canMoveFigures()
     * @return random figure
     */
    public Figures getRandomFigure(List<Figures> listFiguresThatCanMove) {
        Random random = new Random();
        return listFiguresThatCanMove.get(random.nextInt(listFiguresThatCanMove.size()));
    }

    public void changeGoalTail(Figures randomFigure, Coordinates goalCoordinate) {
        for (Tail tail : allTails) {
            if (tail.getCoordinates().equals(goalCoordinate)) {
                //???????????????? ???????????????? ???????????? ?????????????? ???????? ?? ?????????????????? ?????? ???????? ????????????
                Figures oldFigure = tail.getFigure();
                //???????? ?? ???????????? ???????? ???????????? ???? ?????????????????????????? ???????????????? ???????????? ?? ???????????? null, ?????????????? ???????????? ?? ???????????? ???????????????? ?????????? ?? ?????????????? ????.
                if (oldFigure != null) {
                    tail.setFigure(null);
                    allFigures.remove(oldFigure);
                }
                randomFigure.setCoordinates(goalCoordinate);
                tail.setFigure(randomFigure);
                break;
            }
        }
    }

    /**
     * @return List of tiles to be sent from the controller
     */
    public List<Tail> move() {
        List<Figures> figureWithOneColor = getCurrentColorFigures(allFigures, turnToMove.toggleAndGet());
        //random piece from among those who can move on their turn
        Figures randomFigure = getRandomFigure(canMoveFigures(figureWithOneColor));

        //?????????????? ???? ???????????? ???????????? ????????????
        removeFigureFromOldTail(randomFigure);

        //???????????????? ???????????????????? ?????? ???????? ?????????????????? ?????????????????? ????????????
        Coordinates goalCoordinate = randomFigure.coordinateForTheMove();

        //?????????????? ?? ???????????? ?????????????? ???????????? ????????????, ???????? ?????????????? ???????? ???????????? ??????.
        changeGoalTail(randomFigure, goalCoordinate);
        return allTails;
    }

    private void removeFigureFromOldTail(Figures randomFigure) {
        for (Tail tail : allTails) {
            if (tail.getCoordinates().equals(randomFigure.getCoordinates())) {
                tail.setFigure(null);
                break;
            }
        }
    }

    public List<Tail> restartGame() {
        allFigures.clear();
        allFigures = createFigure();
        allTails.clear();
        allTails = setCoordinate(tailIdAndFigureIdCreator());
        turnToMove.setFigureTurn();
        return allTails;
    }


}



