import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	
	private JLabel textlabel;
	
	public Frame (){
		super("Star Polygon Project");
		setLayout(new FlowLayout());
		
		textlabel = new JLabel("Enter Number of dots");
		textlabel.setToolTipText("Enter the number of dots you would like to have appear in a circle");
		add(textlabel);
		TextField numdots = new TextField(15); 
		add(numdots);
		textlabel = new JLabel("Speed in Milliseconds");
		add(textlabel);
		TextField speed = new TextField(15); 
		add(speed);
		
		
		
	}
	
	
}
