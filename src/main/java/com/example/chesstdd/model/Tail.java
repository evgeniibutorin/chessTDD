package com.example.chesstdd.model;


import com.example.chesstdd.model.figure.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Tail {

    int Id;
    @Getter
    @Setter
    private int tailWidth;
    @Getter
    @Setter
    private int tailHeight;

    @Getter
    @Setter
    Figure figure;

    public Tail(int id, Figure figure) {
        Id = id;
        this.figure = figure;
    }

}
