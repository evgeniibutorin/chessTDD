package com.example.chesstdd.service;

import com.example.chesstdd.model.Color;
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
            tail.setTailWidth(width);
            tail.setTailHeight(height);
        }
        return supplementedTileList;
    }

    public List<Figures> createFigure() {
        List<Figures> board = new ArrayList<>();
        board.add(new Rook(0, WHITE, 0, 0, "♖"));
        board.add(new Knight(1, WHITE, 1, 0, "♘"));
        board.add(new Bishop(2, WHITE, 2, 0, "♗"));
        board.add(new Queen(3, WHITE, 3, 0, "♕"));
        board.add(new King(4, WHITE, 4, 0, "♔"));
        board.add(new Bishop(5, WHITE, 5, 0, "♗"));
        board.add(new Knight(6, WHITE, 6, 0, "♘"));
        board.add(new Rook(7, WHITE, 7, 0, "♖"));
        for (int i = 8; i < 16; i++) {
            int width = i - 8;
            int height = 1;
            board.add(new Pawn(i, WHITE, width, height, "♙"));
        }
        for (int j = 48; j < 56; j++) {
            int width = j - 48;
            int height = 6;
            board.add(new Pawn(j, DARK, width, height, "♟"));
        }
        board.add(new Rook(56, DARK, 0, 7, "♜"));
        board.add(new Knight(57, DARK, 1, 7, "♞"));
        board.add(new Bishop(58, DARK, 2, 7, "♝"));
        board.add(new Queen(59, DARK, 3, 7, "♛"));
        board.add(new King(60, DARK, 4, 7, "♚"));
        board.add(new Bishop(61, DARK, 5, 7, "♝"));
        board.add(new Knight(62, DARK, 6, 7, "♞"));
        board.add(new Rook(63, DARK, 7, 7, "♜"));
        return board;
    }

    /**
     * @param tailsWithAllFigures Все клетки
     * @param currentColorFigures все фигуры в игре текущего цвета
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
     * @param figures список всех фигур в игре текущего цвета
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


    /**
     * @return List of tiles to be sent from the controller
     */
    public List<Tail> move() {
        List<Figures> figureWithOneColor = getCurrentColorFigures(allFigures, turnToMove.toggleAndGet());
        //random piece from among those who can move on their turn
        Figures randomFigure = getRandomFigure(canMoveFigures(figureWithOneColor));

        //убираем из списка клеток фигуру
        removeFigureFromOldTail(randomFigure);

        //Получаем координаты для хода выбранной случайной фигуры
        List<Integer> goalCoordinate = randomFigure.coordinateForTheMove();

        //Находим в списке игровых клеток клетку, куда доложен быть сделан ход.
        for (Tail tail : allTails) {
            if (tail.getTailWidth() == goalCoordinate.get(0) && tail.getTailHeight() == goalCoordinate.get(1)) {
                //Получаем значение фигуры которое есть в выбранной для хода клетке
                Figures oldFigure = tail.getFigure();
                //Если в клетке есть фигура то устанавливаем значение фигуры в клетке null, находим фигуру в списке играющих фигур и удаляем ее.
                if (oldFigure != null) {
                    tail.setFigure(null);
                    allFigures.remove(oldFigure);
                }
                randomFigure.setWidthPosition(goalCoordinate.get(0));
                randomFigure.setHeightPosition(goalCoordinate.get(1));
                tail.setFigure(randomFigure);
                break;
            }
        }
        return allTails;
    }

    private void removeFigureFromOldTail(Figures randomFigure) {
        for (Tail tail : allTails) {
            if (tail.getTailWidth() == randomFigure.getWidthPosition() && tail.getTailHeight() == randomFigure.getHeightPosition()) {
                tail.setFigure(null);
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



