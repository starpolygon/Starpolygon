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
			//PointOnCircle(angle, x);
			angle = angle + Angle;
		}
		// line(steps);

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
		
	
		JButton button2 = new JButton("Back");
		add(button2);
		
		JButton button3 = new JButton("Forward");
		add(button3);
		
		
>>>>>>> branch 'master' of ssh://git@github.com/starpolygon/Starpolygon.git

	}

}
