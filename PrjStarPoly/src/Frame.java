import java.awt.*;
import javax.swing.*;

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

		int c = 0;
		int x = 0;
		// need to figure out how to get input from form
		// linex=Float.valueOf().floatValue();
		/*
		Pen pen = new Pen(Color.Black);
            Graphics g = panel1.CreateGraphics();
            int x = 0;
            int speed = Int32.Parse(textBox3.Text);
            if(x + steps < xc.Length)
            {
                g.DrawLine(pen, xc[x]+1, yc[x]+1, xc[x + steps]+1, yc[x + steps]+1);
                linex[c,0] = xc[x] + 1;
                linex[c,1] = xc[x + steps] + 1;
                liney[c,0] = yc[x] + 1;
                liney[c,1] = yc[x + steps] + 1;
                c++;
                x = x + steps;
                Thread.Sleep(speed);
            if (x + steps >= xc.Length)
            {
                g.DrawLine(pen, xc[x]+1, yc[x]+1, xc[(x + steps) % xc.Length]+1, yc[(x + steps) % xc.Length]+1);
                linex[c, 0] = xc[x] + 1;
                linex[c, 1] = xc[(x + steps) % xc.Length] + 1;
                liney[c, 0] = yc[x] + 1;
                liney[c, 1] = yc[(x + steps) % xc.Length] + 1;
                c++;  
                x = (x + steps) % xc.Length;
                Thread.Sleep(speed);
            }
            }
            while (x != 0)
            {
                if(x + steps < xc.Length)
                {
                    g.DrawLine(pen, xc[x]+1, yc[x]+1, xc[x + steps]+1, yc[x + steps]+1);
                    linex[c, 0] = xc[x] + 1;
                    linex[c, 1] = xc[x + steps] + 1;
                    liney[c, 0] = yc[x] + 1;
                    liney[c, 1] = yc[x + steps] + 1;
                    x = x + steps;
                    c++;
                    Thread.Sleep(speed);
                }
                else if (x + steps >= xc.Length)
                {
                    g.DrawLine(pen, xc[x]+1, yc[x]+1, xc[(x + steps) % xc.Length]+1, yc[(x + steps) % xc.Length]+1);
                    linex[c, 0] = xc[x] + 1;
                    linex[c, 1] = xc[(x + steps) % xc.Length] + 1;
                    liney[c, 0] = yc[x] + 1;
                    liney[c, 1] = yc[(x + steps) % xc.Length] + 1;
                    c++;
                    x = (x + steps) % xc.Length;
                    Thread.Sleep(speed);
                } 
            }
            g.Dispose();
            pen.Dispose();
            label5.Text = c.ToString();
            place = c-1;
        }
		
	
	*/
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

	}

}
