package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
	    JFrame f = new JFrame("Sorting Algorithm Visualizer");
	    f.setLayout(new BorderLayout());
	    CanvasPanel panel = new CanvasPanel();
	    JPanel buttonPanel = new JPanel(new GridLayout(1, 0));
	    JButton insertionSortButton = new JButton("Insertion Sort");
	    JButton bubbleSortButton = new JButton("Bubble Sort");
	    JButton selectionSortButton = new JButton("Selection Sort");
	    JButton heapSortButton = new JButton("Heap Sort");
	    JButton shuffleButton = new JButton("Shuffle");
	    JButton mergeSortButton = new JButton("Merge Sort");
	    buttonPanel.add(insertionSortButton);
	    buttonPanel.add(bubbleSortButton);
	    buttonPanel.add(selectionSortButton);
	    buttonPanel.add(shuffleButton);
	    buttonPanel.add(heapSortButton);
	    buttonPanel.add(mergeSortButton);
	    f.add(panel, BorderLayout.CENTER);
	    f.add(buttonPanel, BorderLayout.SOUTH);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setVisible(true);

	    insertionSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getSorter().insertionSort(panel.getArray());
			}
		});

		shuffleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getSorter().shuffle(panel.getArray());
			}
		});

		bubbleSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getSorter().bubbleSort(panel.getArray());
			}
		});

		selectionSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getSorter().selectionSort(panel.getArray());
			}
		});

		heapSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getSorter().heapSort(panel.getArray());
			}
		});

		mergeSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getSorter().mergeSort(panel.getArray(), 0, panel.getArray().length - 1);
			}
		});
    }
}
