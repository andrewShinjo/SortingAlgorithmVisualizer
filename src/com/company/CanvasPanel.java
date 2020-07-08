package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CanvasPanel extends JPanel {
    private Integer[] arr;
    private static final int SIZE = 190;
    private static final int PADDING = 10;
    private Sorter sorter;

    public CanvasPanel() {
        arr = new Integer[SIZE];
        for(int i = 0; i < SIZE; i++) {
            arr[i] = i * 5;
        }

        sorter = new Sorter(this);
    }

    public Sorter getSorter() {
        return sorter;
    }

    public Integer[] getArray() {
        return arr;
    }

    public void modelChanged() {
        revalidate();
        repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < arr.length; i++) {
            g.fillRect(PADDING + i * 10, getHeight() - arr[i] - PADDING, 10, arr[i]);
        }
    }
}
