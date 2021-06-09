package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public List<Integer> canMove(){
        List<Integer> steps = Arrays.asList(8,16,7,9);
        return steps;
    }
}
