package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
	static ArrayList<JButton> buttons = new ArrayList<>();

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
				for(JButton button : buttons) {
					button.setEnabled(false);
				}
				panel.getSorter().insertionSort(panel.getArray());
				try {
					Thread.sleep(1);
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
				for(JButton button : buttons) {
					button.setEnabled(true);
				}
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
    }

    public static void disableAllButtons() {
    	for(JButton button : buttons) {
    		button.setEnabled(false);
		}
	}

	public static void enableAllButtons() {
    	for(JButton button : buttons) {
    		button.setEnabled(true);
		}
	}
}
