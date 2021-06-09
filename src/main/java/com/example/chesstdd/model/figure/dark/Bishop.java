package com.example.chesstdd.model.figure.dark;

import com.example.chesstdd.model.Color;
import com.example.chesstdd.model.figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Bishop implements Figure {

    @Getter
    private int id;
    @Getter
    @Setter
    private int position;
    @Getter
    Color color;

    public List<Integer> canMove(){
        List<Integer> steps = Arrays.asList(9,18,27,36,45,54,63,7,14,21,28,35,42,49,-9,-18,-27,-36,-45,-54,-63,-7,-14,-21,-28,-35,-42,-49);
        return steps;
    }

}
