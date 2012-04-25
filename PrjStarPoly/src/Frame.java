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
	public float[] xc;
	public float[] yc;
	public float[] linex;
	public float[] liney;
	private JButton button;
	private TextField numdots;
	private TextField speed;
	
	// comments

	
	public TextField getNumdots(){
		return numdots;
	}
	
	public TextField getSpeed(){
		return speed;
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
		numdots = new TextField(10);
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

		// buttons
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
