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

    /** Constructor for CanvasPanel. The CanvasPanel class draws the array that gets sorted.
     *
     */
    public CanvasPanel() {
        arr = new Integer[SIZE];
        for(int i = 0; i < SIZE; i++) {
            arr[i] = i * 5;
        }

        sorter = new Sorter(this);
    }

    /** Returns the sorter, which has all the sorting algorithms that
     * can be applied to the array.
     *
     * @return sorter = the sorter
     */
    public Sorter getSorter() {
        return sorter;
    }

    /** Returns the array that gets sorted.
     *
     * @return array = the array that gets sorted
     */
    public Integer[] getArray() {
        return arr;
    }

    /** Updates the graphics on the panel.
     *
     */
    public void modelChanged() {
        revalidate();
        repaint();
    }


    /** Visually displays the state of the array in terms of a group of rectangles.
     *
     * @param g = the graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < arr.length; i++) {
            g.fillRect(PADDING + i * 10, getHeight() - arr[i] - PADDING, 10, arr[i]);
        }
    }
}
