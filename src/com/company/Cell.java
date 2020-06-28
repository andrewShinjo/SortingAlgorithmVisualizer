package com.company;

import java.awt.*;

public class Cell extends Rectangle implements Comparable {
    private int value;

    public Cell(int x, int y, int width, int height, int value) {
        super(x, y, width, height);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(Object o) {
        Cell otherCell = (Cell) o;
        return this.value - otherCell.value;
    }
}
