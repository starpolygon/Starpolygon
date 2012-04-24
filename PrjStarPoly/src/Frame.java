import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class Frame extends JFrame {
	// form variables
	JLabel textlabel1;
	JLabel textlabel2;
	JLabel textlabel3;

	// variables
	int r = 100;
	int X = 220;
	int Y = 170;
	int place = 0;
	float[] xc;
	float[] yc;
	float[] linex;
	float[] liney;
	private JButton button;

	// comments

	public void circle() {
		float angle;
		int dots = Integer.parseInt(textlabel1.getText());
		angle = 360 / dots;
		float Angle = angle;
		xc = new float[dots];
		yc = new float[dots];
		for (int x = 0; x < dots; x++) {
			PointOnCircle(angle, x);
			angle = angle + Angle;
		}
		// line(steps);

	}

	public void PointOnCircle(float angleInDegrees, int c) {
		float x = (float) (X + r
				* Math.cos(angleInDegrees * Math.PI / 180 + Math.PI * 3 / 2));
		float y = (float) (Y + r
				* Math.sin(angleInDegrees * Math.PI / 180 + Math.PI * 3 / 2));
		Point(x, y);
		xc[c] = x;
		yc[c] = y;
	}

	// point class, figures out where the points are in the circle
	public void Point(float x, float y) {

	}

	// draws the lines
	public void lines() {

	}

	// sets up the form
	public Frame() {
		super("Star Polygon Project");
		setLayout(new FlowLayout());

		// Dots field
		JLabel textlabel1 = new JLabel("Enter Number of dots:", JLabel.LEFT);
		textlabel1
				.setToolTipText("Enter the number of dots you would like to have appear in a circle");
		add(textlabel1);
		TextField numdots = new TextField(10);
		add(numdots);

		// Milliseconds field
		JLabel textlabel2 = new JLabel("Speed in Milliseconds:", JLabel.LEFT);
		add(textlabel2);
		TextField speed = new TextField(10);
		add(speed);

		// Steps field
		JLabel textlabel3 = new JLabel("Enter number of Steps:", JLabel.LEFT);
		add(textlabel3);
		TextField steps = new TextField(10);
		add(steps);
		
		//buttons
		JButton button1 = new JButton("Start");
		add(button1);
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//the action after button1(start) is pressed
				System.out.println("you pressed the Start button");
				
			}
		});
			
		
	
		JButton button2 = new JButton("Back");
		add(button2);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//the action after button2(back) is pressed
				System.out.println("you pressed the Back button");
			}
		});
		
		JButton button3 = new JButton("Forward");
		add(button3);
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//the action after button3(forward) is pressed
				System.out.println("you pressed the Forward button");
			}
		});
		
		
	}

}
