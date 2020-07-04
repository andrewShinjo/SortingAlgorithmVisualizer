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
	    JButton shuffleButton = new JButton("Shuffle");
	    buttonPanel.add(insertionSortButton);
	    buttonPanel.add(shuffleButton);
	    f.add(panel, BorderLayout.CENTER);
	    f.add(buttonPanel, BorderLayout.SOUTH);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setVisible(true);

	    insertionSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.getInsertionSort().sort(panel.getArray());
			}
		});

		shuffleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.shuffleArray();
			}
		});
    }
}
