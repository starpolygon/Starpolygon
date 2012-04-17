import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	
	public JLabel textlabel1;
	public JLabel textlabel2;
	public JLabel textlabel3;
	
	
	public Frame (){
		super("Star Polygon Project");
		setLayout(new FlowLayout());
		
		//Dots field
		JLabel textlabel1 = new JLabel("Enter Number of dots:",JLabel.LEFT);
		textlabel1.setToolTipText("Enter the number of dots you would like to have appear in a circle");
		add(textlabel1);
		TextField numdots = new TextField(10); 
		add(numdots);
		
		//Milliseconds field
		// stuff
		JLabel textlabel2 = new JLabel("Speed in Milliseconds:",JLabel.LEFT);
		add(textlabel2);
		TextField speed = new TextField(10); 
		add(speed);
		
		//Steps field 
		JLabel textlabel3 = new JLabel("Enter number of Steps:",JLabel.LEFT);
		add(textlabel3);
		TextField steps = new TextField(10); 
		add(steps);
		
		
		
	}

	
}
