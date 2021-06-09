package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Knight implements Figure {
    @Getter
    private int id;
    @Getter
    @Setter
    private int position;
    @Getter
    Color color;

    public List<Integer> canMove(){
        List<Integer> steps = Arrays.asList(6,10,15,17,-6,-10,-15,-17);
        return steps;
    }
}
