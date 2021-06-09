package com.example.chesstdd.service;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.Tail;
import com.example.chesstdd.model.figure.Figure;
import com.example.chesstdd.model.figure.dark.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.chesstdd.model.Color.DARK;
import static com.example.chesstdd.model.Color.WHITE;

public class ChessService {

    public List<Tail> boardCreator() {
        List<Tail> board = new ArrayList<>();
        for (int i = 1; i < 65; i++) {
            int b = 0;
            if (i<17||i>48){
                b=i;
            }
            board.add(new Tail(i,b));
        }
    return board;
    }

    public List<Figure> createFigure(){
        List<Figure> board = new ArrayList<>();
        for (int i = 1; i < 65; i++) {
            if (i==1||i==8){board.add(new Rook(i,i,WHITE));}
            else if (i==2||i==7){board.add(new Knight(i,i,WHITE));}
            else if (i==3||i==6){board.add(new Bishop(i,i,WHITE));}
            else if (i==4){board.add(new King(i,i,WHITE));}
            else if (i==5){board.add(new Queen(i,i,WHITE));}
            else if (i==9||i==10||i==11||i==12||i==13||i==14||i==15||i==16){board.add(new Queen(i,i,WHITE));}


            else if (i==57||i==64){board.add(new Rook(i,i,DARK));}
            else if (i==58||i==63){board.add(new Knight(i,i,DARK));}
            else if (i==59||i==62){board.add(new Bishop(i,i,DARK));}
            else if (i==60){board.add(new King(i,i,DARK));}
            else if (i==61){board.add(new Queen(i,i,DARK));}
            else if (i==49||i==50||i==51||i==52||i==53||i==54||i==55||i==56){board.add(new Queen(i,i,WHITE));}

        }
        return null;
    }

    public void makeMove(int i){
        int black id

    }

    public boolean canMove(){
        return false;
    }




}
