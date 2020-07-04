package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CanvasPanel extends JPanel {
    private Integer[] arr;
    private static final int SIZE = 150;
    private static final int PADDING = 10;
    private InsertionSort insertionSort;

    public CanvasPanel() {
        arr = new Integer[SIZE];
        for(int i = 0; i < SIZE; i++) {
            arr[i] = i * 5;
        }

        insertionSort = new InsertionSort(this);
    }

    public InsertionSort getInsertionSort() {
        return insertionSort;
    }

    public Integer[] getArray() {
        return arr;
    }

    public void shuffleArray() {
        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
        modelChanged();
    }

    public void modelChanged() {
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
