package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Display<T extends Comparable<? super T>> extends JPanel {
    private Cell[] cells;
    private int[] values;
    private int columns = 1;
    private int rows = 10;
    private boolean cellsGenerated;
    private boolean repaintCalled;

    public Display() {
        cells = new Cell[columns * rows];
        values = new int[columns * rows];
        cellsGenerated = false;
        repaintCalled = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int cellWidth = getWidth() / columns;
        int cellHeight = getHeight() / rows;

        int xOffset = (getWidth() - (columns * cellWidth)) / 2;
        int yOffset = (getHeight() - (rows * cellHeight)) / 2;

        if(! cellsGenerated) {
            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < columns; c++) {
                    Random random = new Random();
                    int value = random.nextInt(101);
                    Cell cell = new Cell(xOffset + (c * cellWidth), yOffset + (r * cellHeight), cellWidth, cellHeight, value);
                    cells[r * 1 + c] = cell;
                    values[r * 1 + c] = cell.getValue();
                }
            }
            printArray();
            cellsGenerated = true;
        }

        g2d.setColor(Color.GRAY);
        for(int i = 0; i < cells.length; i++) {
            g2d.draw(cells[i]);
            g2d.drawString(String.valueOf(cells[i].getValue()), cells[i].x + cellWidth / 2, cells[i].y + cellHeight / 2);
        }
        if(! repaintCalled) {
            repaintCalled = true;
            insertionSort();
            repaint();
        }
    }

    public Cell[] getCells() {
        return cells;
    }


    public void insertionSort() {
        for(int j = 1; j < values.length; j++) {
            int key = values[j];
            int i = j - 1;

            while(i >= 0 && values[i] > key) {
                values[i + 1] = values[i];
                i--;
            }
            values[i + 1]= key;
            printArray();
        }
        updateValues();
    }

    public void updateValues() {
        for(int i = 0; i < values.length; i++) {
            cells[i].setValue(values[i]);
        }
    }

    public void printArray() {
        for(int i = 0; i <  columns * rows; i++) {
            System.out.print(cells[i].getValue() + " ");
        }
        System.out.println();
    }

}
