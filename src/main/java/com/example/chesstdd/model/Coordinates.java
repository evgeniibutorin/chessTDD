package com.example.chesstdd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {

    @Getter
    @Setter
    private int widthPosition;

    @Getter
    @Setter
    private int heightPosition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return widthPosition == that.widthPosition && heightPosition == that.heightPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthPosition, heightPosition);
    }
}
