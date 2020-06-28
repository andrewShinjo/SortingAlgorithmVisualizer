package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	    JFrame f = new JFrame("Sorting Algorithm Visualizer");
	    Display d = new Display();
	    f.add(d);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    f.setVisible(true);
    }
}
