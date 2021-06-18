package com.example.chesstdd.model.figure;

import com.example.chesstdd.model.Color;

import java.util.Arrays;
import java.util.List;


public class Pawn extends Figures {


//    public Pawn(int id, Color color, int widthPosition, int heightPosition, String logo) {
//        this.id = id;
//        this.color = color;
//        this.widthPosition = widthPosition;
//        this.heightPosition = heightPosition;
//        this.logo = logo;
//        this.figureMoves = figureMovesSender();
//    }

    List<List<Integer>> figureMoves;

    public Pawn(int id, Color color, int widthPosition, int heightPosition, String logo) {
        super(id, color, widthPosition, heightPosition, logo);
        this.figureMoves = figureMovesSender();
    }

    public List<List<Integer>> figureMovesSender(){
        List<List<Integer>> figureMoves = null;
        if (super.getColor().equals(Color.WHITE)){
            figureMoves = Arrays.asList(Arrays.asList(0, 2),
                    Arrays.asList(0,1),
                    Arrays.asList(1,1),
                    Arrays.asList(-1,1));

        }
        if (super.getColor().equals(Color.DARK)){
            figureMoves = Arrays.asList(Arrays.asList(0, -2),
                    Arrays.asList(0,-1),
                    Arrays.asList(1,-1),
                    Arrays.asList(-1,-1));

        }
            return figureMoves;
    }

    @Override
    public List<List<Integer>> getFigureMoves() {
        return figureMoves;
    }


}
