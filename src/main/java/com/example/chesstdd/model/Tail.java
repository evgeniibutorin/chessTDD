package com.example.chesstdd.model;


import com.example.chesstdd.model.figure.Figures;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Tail {

    @Getter
    int id;

    @Getter
    @Setter
    @JsonIgnore
    Coordinates coordinates;

    @Getter
    @Setter
    Figures figure;

    public Tail(int id, Figures figure) {
        this.id = id;
        this.figure = figure;
    }

}
