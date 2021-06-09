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
public class Rook implements Figure {

    @Getter
    private int id;
    @Getter
    @Setter
    private int position;
    @Getter
    Color color;

    public List<Integer> canMove(){
        List<Integer> steps = Arrays.asList(1,2,3,4,5,6,7,8,16,24,32,40,48,56,-1,-2,-3,-4,-5,-6,-7,-8,-16,-24,-32,-40,-48,-56);
        return steps;
    }
}
