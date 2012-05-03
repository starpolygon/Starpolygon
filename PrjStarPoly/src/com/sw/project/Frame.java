package com.sw.project;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Frame extends JApplet implements Runnable {

	private static final long serialVersionUID = 1L;
	// form variables
	JLabel textlabel1;
	JLabel textlabel2;
	JLabel textlabel3;
	JLabel label5;
	TextField steps;
	JPanel panel1;

	// variables
	int r = 100;
	int X = 220;
	int Y = 170;
	int place = 0;
	public float[] xc;
	public float[] yc;
	public float[][] linex = new float[100][2];
	public float[][] liney = new float[100][2];
	public TextField numdots;
	public TextField speed;
	public String Time;
	private boolean running = false;
	private Thread thread;

	// sets up the form
	public Frame() {
		super();
		setLayout(new FlowLayout());

		// panel
		panel1 = new JPanel(new BorderLayout());
		add(panel1);

		// label5

		// Dots field
		textlabel1 = new JLabel("Enter Number of dots:", JLabel.LEFT);
		textlabel1
				.setToolTipText("Enter the number of dots you would like to have appear in a circle");
		add(textlabel1);
		numdots = new TextField(10);
		add(numdots);

		// Milliseconds field
		textlabel2 = new JLabel("Speed in Milliseconds:", JLabel.LEFT);
		add(textlabel2);
		 speed = new TextField(10);
		add(speed);
		

		// Steps field
		textlabel3 = new JLabel("Enter number of Steps:", JLabel.LEFT);
		add(textlabel3);
		steps = new TextField(10);
		add(steps);

		// buttons
		JButton button1 = new JButton("Start");
		add(button1);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Time = speed.getText();
				try {
					circle();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				// System.out.println("you pressed the Start button");
				
			}
		});

		JButton button2 = new JButton("Back");
		add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (place >= 0) {
					Graphics g = panel1.getGraphics();
					int x0 = (int) linex[place][0];
					int y0 = (int) liney[place][0];
					int x1 = (int) linex[place][1];
					int y1 = (int) liney[place][1];
					g.drawLine(x0, y0, x1, y1);
					g.fillRect(x0 - 1, y0 - 1, 3, 3);
					g.fillRect(x1 - 1, y1 - 1, 3, 3);
					place--;
					g.dispose();
				}
				// System.out.println("you pressed the Back button");
			}
		});

		JButton button3 = new JButton("Forward");
		add(button3);

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dots = numdots.getText();

				if (place < Integer.parseInt(dots) - 1) {
					place++;

					int x0 = (int) linex[place][0];
					int y0 = (int) liney[place][0];
					int x1 = (int) linex[place][1];
					int y1 = (int) liney[place][1];
					Graphics g = panel1.getGraphics();
					g.drawLine(x0, y0, x1, y1);
					g.dispose();
				}

			}
		});

	}

	public synchronized void start() {

		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

		System.out.println("Working");
	}

	public synchronized void stop() {
		if (!running)
			running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	public void lines(int steps) throws InterruptedException {
	//	try {
			int c = 0;
			Graphics g = panel1.getGraphics();
			int x = 0;
			int x0 = (int) xc[x];
			int y0 = (int) yc[x];
			int x1 = (int) xc[x + steps];
			int y1 = (int) yc[x + steps];
			int time;
			String Time = speed.getText();
			time = Integer.parseInt(Time);
			if (x + steps < xc.length) {

				g.drawLine(x0 + 1, y0 + 1, x1 + 1, y1 + 1);
				linex[c][0] = xc[x] + 1;
				linex[c][1] = xc[x + steps] + 1;
				liney[c][0] = yc[x] + 1;
				liney[c][1] = yc[x + steps] + 1;
				c++;
				x = x + steps;
				Thread.sleep(time);

			}
			if (x + steps >= xc.length) {
				g.drawLine(x0 + 1, y0 + 1, x1 % xc.length + 1, y1 % xc.length
						+ 1);
				linex[c][0] = xc[x] + 1;
				linex[c][1] = xc[(x + steps) % xc.length] + 1;
				liney[c][0] = yc[x] + 1;
				liney[c][1] = yc[(x + steps) % xc.length] + 1;
				c++;
				x = (x + steps) % xc.length;
				Thread.sleep(time);
			}

			while (x != 0) {
				if (x + steps < xc.length) {
					g.drawLine(x0 + 1, y0 + 1, x1 + 1, y1 + 1);
					linex[c][0] = xc[x] + 1;
					linex[c][1] = xc[x + steps] + 1;
					liney[c][0] = yc[x] + 1;
					liney[c][1] = yc[x + steps] + 1;
					x = x + steps;
					c++;
					Thread.sleep(time);
				} else if (x + steps >= xc.length) {
					g.drawLine(x0 + 1, y0 + 1, x1 % xc.length + 1, y1
							% xc.length + 1);
					linex[c][0] = xc[x] + 1;
					linex[c][1] = xc[(x + steps) % xc.length] + 1;
					liney[c][0] = yc[x] + 1;
					liney[c][1] = yc[(x + steps) % xc.length] + 1;
					c++;
					x = (x + steps) % xc.length;
					Thread.sleep(time);
				}

			}
			g.dispose();
			 speed.setText(Integer.toString(c));
			place = c - 1;
		//} catch (NumberFormatException ignored) {} catch (NullPointerException ignored) {}
	}// end of lines

	public void Point(int x, int y) throws InterruptedException {
		Graphics g = panel1.getGraphics();
		g.fillRect(x, y, 3, 3);
		Thread.sleep(100);
		g.dispose();
	}

	public void PointOnCircle(float angleInDegrees, int c)
			throws InterruptedException {
		int x = (int) (X + r
				* Math.cos(angleInDegrees * Math.PI / 180 + Math.PI * 3 / 2));
		int y = (int) (Y + r
				* Math.sin(angleInDegrees * Math.PI / 180 + Math.PI * 3 / 2));
		Point(x, y);
		xc[c] = (float) x;
		yc[c] = (float) y;
	}

	public void circle() throws InterruptedException {
		float angle;
		String dot = numdots.getText();
		String ste = steps.getText();
		int dots = Integer.parseInt(dot);
		int step = Integer.parseInt(ste);
		angle = 360 / dots;
		float Angle = angle;
		xc = new float[dots];
		yc = new float[dots];
		for (int x = 0; x < dots; x++) {
			PointOnCircle(angle, x);
			angle = angle + Angle;
		}
		lines(step);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
