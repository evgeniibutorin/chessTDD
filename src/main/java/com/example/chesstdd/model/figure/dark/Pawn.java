package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
public class Pawn implements Figure {
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



    List<List<Integer>> figureMoves = figureMovesSender();

    public List<List<Integer>> figureMovesSender(){
        List<List<Integer>> figureMoves = null;
        if (color.equals(Color.WHITE)){
            figureMoves = Arrays.asList(Arrays.asList(0, 2),
                    Arrays.asList(0,1),
                    Arrays.asList(1,1),
                    Arrays.asList(-1,1));

        }
        if (color.equals(Color.DARK)){
            figureMoves = Arrays.asList(Arrays.asList(0, -2),
                    Arrays.asList(0,-1),
                    Arrays.asList(1,-1),
                    Arrays.asList(-1,-1));

        }
            return figureMoves;
    }

    public  List<List<Integer>> possibleMoves(int heightPosition, int widthPosition) {

        List<List<Integer>> possibleMoves = new ArrayList<>();
        for (int i = 0; i < figureMoves.size(); i++) {
            List<Integer> move = figureMoves.get(i);
            //todo: add method to check that tail is free
            if ((heightPosition+move.get(0)>=0)&(heightPosition+move.get(0)<8)
                    &(widthPosition+move.get(1)>=0)&(widthPosition+move.get(1)<8)){
                possibleMoves.add(move);
            }

        }
        return possibleMoves;
    }

    public List<Integer> coordinatesForTheMove(int heightPosition, int widthPosition){
        List<List<Integer>> possibleMoves = possibleMoves(heightPosition, widthPosition);
        Random rand = new Random();
        List<Integer> move = possibleMoves.get(rand.nextInt(possibleMoves.size()));
        return move;
    }



    @Override
    public List<List<Integer>> possibleMoves() {
        return null;
    }

    @Override
    public List<Integer> coordinatesForTheMove() {
        return null;
    }

    public Pawn(int id, int position, Color color, int widthPosition, int heightPosition) {
        this.id = id;
        this.position = position;
        this.color = color;
        this.widthPosition = widthPosition;
        this.heightPosition = heightPosition;
    }
}
