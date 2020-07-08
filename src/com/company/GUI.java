package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    ArrayList<JButton> buttons = new ArrayList<>();
    CanvasPanel panel;

    public GUI() {
        JFrame f = new JFrame("Sorting Algorithm Visualizer");
        f.setLayout(new BorderLayout());
        panel = new CanvasPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0));
        JButton insertionSortButton = new JButton("Insertion Sort");
        JButton bubbleSortButton = new JButton("Bubble Sort");
        JButton selectionSortButton = new JButton("Selection Sort");
        JButton heapSortButton = new JButton("Heap Sort");
        JButton shuffleButton = new JButton("Shuffle");
        buttons.add(insertionSortButton);
        buttons.add(bubbleSortButton);
        buttons.add(selectionSortButton);
        buttons.add(heapSortButton);
        buttons.add(shuffleButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(bubbleSortButton);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(heapSortButton);
        buttonPanel.add(shuffleButton);
        f.add(panel, BorderLayout.CENTER);
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);

        insertionSortButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               start();
           }
        });

        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        panel.getSorter().shuffle(panel.getArray());
                        return null;
                    }
                };
                worker.execute();
            }
        });

        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                    panel.getSorter().bubbleSort(panel.getArray());
                    return null;
                    }
                };
                worker.execute();
            }
        });

        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                    panel.getSorter().selectionSort(panel.getArray());
                    return null;
                    }
                };
                worker.execute();
            }
        });

        heapSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                    panel.getSorter().heapSort(panel.getArray());
                    return null;
                    }
                };
                worker.execute();
            }
        });
    }

    private void start() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                panel.getSorter().insertionSort(panel.getArray());
                return null;
            }
        };
        worker.execute();
    }
}