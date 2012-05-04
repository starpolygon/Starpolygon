package com.sw.project;

import javax.swing.*;

public class Driver {
	public static void main(String[] args) {

		Frame star = new Frame();

		//star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		star.setSize(300, 400);
		star.setVisible(true);
		star.add(star);
	}
}