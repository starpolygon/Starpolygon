/* Created by James Foster, Gary Savoie, Gavin Lofland, Brendan Opalka, Lee Nguyen
 For Dr. Christine Von Renesse of the WSU Math Department
 As part of a project in Software Engineering course, May 9th 2012*/

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
	JPanel panel1, panel2, panel3;

	// variables
	int c = 0;
	int x = 0;
	int r = 100;
	int X = 220;
	int Y = 170;
	int place = 0;
	public float[] xc;
	public float[] yc;
	public float[][] linex;
	public float[][] liney;
	public TextField numdots;
	public TextField speed;
	int Time;
	private boolean running = false;
	private Thread thread;

	public Frame() {
		super();
		setLayout(new BorderLayout(10, 10));
		
		// Dots field
		textlabel1 = new JLabel("Enter Number of Dots:", JLabel.LEFT);

		numdots = new TextField(10);

		// Milliseconds field
		textlabel2 = new JLabel("Speed in Milliseconds:", JLabel.LEFT);

		speed = new TextField(10);

		// Steps field
		textlabel3 = new JLabel("Enter Number of Steps:", JLabel.LEFT);

		steps = new TextField(10);
		
		label5 = new JLabel();
		// start button
		JButton start = new JButton("Start");
		
		// listen for button click on start button
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = 0;
				c = 0;
				place = 0;
				Time = 0;
				int cccc = Integer.parseInt(numdots.getText());
				linex = new float[cccc][2];
				liney = new float[cccc][2];
				xc = new float[cccc];
				yc = new float[cccc];
				Time = Integer.parseInt(speed.getText());
				Graphics g = panel3.getGraphics();
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 1000, 1000);
				g.dispose();

				try {
					circle();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});
		// back button
		JButton back = new JButton("Back");
		// listen to button clicks for back button
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (place >= 0) {
					Graphics g = panel3.getGraphics();
					g.setColor(Color.WHITE);
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

			}
		});
		// forward button
		JButton forward = new JButton("Forward");
		// listen for button clicks of forward button
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dots = numdots.getText();

				if (place < Integer.parseInt(dots) - 1) {
					place++;

					int x0 = (int) linex[place][0];
					int y0 = (int) liney[place][0];
					int x1 = (int) linex[place][1];
					int y1 = (int) liney[place][1];
					Graphics g = panel3.getGraphics();
					g.setColor(Color.BLACK);
					g.drawLine(x0, y0, x1, y1);
					g.dispose();
				}

			}
		});
		// create panel 1, which displays numdots, steps and speed
		panel1 = new JPanel(new GridLayout(4, 2, 10, 10));
		panel1.add(textlabel1);
		panel1.add(numdots);
		panel1.add(textlabel3);
		panel1.add(steps);
		panel1.add(textlabel2);
		panel1.add(speed);
		panel1.add(label5);

		// set panel 1 size
		panel1.setPreferredSize(new Dimension(200, 100));
		add(panel1, BorderLayout.PAGE_START);
		//Tells you how many iterations
		//add(label5, BorderLayout.EAST);
		
		// set panel 2 size and add start, back and forward buttons to the panel
		panel2 = new JPanel(new GridLayout(1, 3, 10, 10));
		panel2.add(start);
		panel2.add(back);
		panel2.add(forward);

		// panel 2 which displays buttons
		panel2.setPreferredSize(new Dimension(20, 20));
		
		add(panel2, BorderLayout.PAGE_END);

		// panel 3 displays the star polgyon circle
		panel3 = new JPanel(new FlowLayout());

		panel3.setPreferredSize(new Dimension(200, 200));
		add(panel3, BorderLayout.CENTER);
		
		
	}

	// start method
	public synchronized void start() {

		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	// stop method
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

	// draws lines
	public void lines(int steps, int i) throws InterruptedException {

		Graphics g = panel3.getGraphics();
		g.setColor(Color.BLACK);
		x = i;
		if (x + steps < xc.length) {

			g.drawLine((int) xc[x] + 1, (int) yc[x] + 1,
					(int) xc[x + steps] + 1, (int) yc[x + steps] + 1);
			linex[c][0] = xc[x] + 1;
			linex[c][1] = xc[x + steps] + 1;
			liney[c][0] = yc[x] + 1;
			liney[c][1] = yc[x + steps] + 1;
			c++;
			x = x + steps;
			Thread.sleep(Time);

		}
		if (x + steps >= xc.length) {
			int spot = x + steps - xc.length;
			g.drawLine((int) xc[x] + 1, (int) yc[x] + 1, (int) xc[spot] + 1,
					(int) yc[spot] + 1);
			linex[c][0] = xc[x] + 1;
			linex[c][1] = xc[spot] + 1;
			liney[c][0] = yc[x] + 1;
			liney[c][1] = yc[spot] + 1;
			c++;
			x = spot;
			Thread.sleep(Time);

		}

		// i starts at 0, every time call lines method, i increments by 1
		while (x != i) {
			if (x + steps < xc.length) {
				g.drawLine((int) xc[x] + 1, (int) yc[x] + 1,
						(int) xc[x + steps] + 1, (int) yc[x + steps] + 1);
				linex[c][0] = xc[x] + 1;
				linex[c][1] = xc[x + steps] + 1;
				liney[c][0] = yc[x] + 1;
				liney[c][1] = yc[x + steps] + 1;
				x = x + steps;
				c++;
				Thread.sleep(Time);
			} else if (x + steps >= xc.length) {
				int spot = x + steps - xc.length;
				g.drawLine((int) xc[x] + 1, (int) yc[x] + 1,
						(int) xc[spot] + 1, (int) yc[spot] + 1);
				linex[c][0] = xc[x] + 1;
				linex[c][1] = xc[spot] + 1;
				liney[c][0] = yc[x] + 1;
				liney[c][1] = yc[spot] + 1;
				c++;
				x = spot;
				Thread.sleep(Time);
			}

		}

		g.dispose();

		place = c - 1;

	}// end of lines

	// point method
	public void Point(int x, int y) throws InterruptedException {
		Graphics g = panel3.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 3, 3);
		//Thread.sleep(Time);
		g.dispose();

	}

	// point on circle method
	public void PointOnCircle(float angleInDegrees, int c)
			throws InterruptedException {
		int x = (int) (X + r
				* Math.cos(angleInDegrees * Math.PI / 180 + Math.PI * 3 / 2));
		int y = (int) (Y + r
				* Math.sin(angleInDegrees * Math.PI / 180 + Math.PI * 3 / 2));
		Point(x*2, y*2);
		xc[c] = (float) x *2;
		yc[c] = (float) y *2;
	}

	// circle method
	public void circle() throws InterruptedException {
		float angle;
		String dot = numdots.getText();
		String ste = steps.getText();
		float dots = Integer.parseInt(dot);
		int step = Integer.parseInt(ste);
		angle = 360 / dots;
		float Angle = angle;
		xc = new float[(int) dots];
		yc = new float[(int) dots];
		for (int x = 0; x < dots; x++) {
			PointOnCircle(angle, x);
			angle = angle + Angle;
		}
		for (int i = 0; c < dots; i++) {
			lines(step, i);
			label5.setText(String.format("Number of Iterations: %d", i));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}