import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	//form variables
	public JLabel textlabel1;
	public JLabel textlabel2;
	public JLabel textlabel3;
	// variables
	int r = 100;
	int X = 220;
	int Y = 170;
	int place = 0;
	float[] xc;
	float[] yc;
	float[] linex;
	float[] liney;

	public void circle() {
		float angles;
		
		
	}

	public void PointOnCircle(float angleInDegrees, int c) {

	}

	public void Point(float x, float y) {

	}

	public void lines(/*Int32 steps*/) {

	}

	public Frame() {
		super("Star Polygon Project");
		setLayout(new FlowLayout());

		// Dots field
		JLabel textlabel1 = new JLabel("Enter Number of dots:", JLabel.LEFT);
		textlabel1.setToolTipText("Enter the number of dots you would like to have appear in a circle");
		add(textlabel1);
		TextField numdots = new TextField(10);
		add(numdots);

		// Milliseconds field
		// stuff
		JLabel textlabel2 = new JLabel("Speed in Milliseconds:", JLabel.LEFT);
		add(textlabel2);
		TextField speed = new TextField(10);
		add(speed);

		// Steps field
		JLabel textlabel3 = new JLabel("Enter number of Steps:", JLabel.LEFT);
		add(textlabel3);
		TextField steps = new TextField(10);
		add(steps);

	}

}
