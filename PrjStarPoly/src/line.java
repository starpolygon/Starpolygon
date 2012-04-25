import javax.swing.JLabel;

public class line {
	// draws the lines
	
	
	
	numdots = frame.getNumdots();
	speed = frame.getSpeed();
	
	
	JLabel textlabel1;
	JLabel textlabel2;
	
	
	private float[] xc;
	private float[] yc;
	private float[][] linex;
	private float[][] liney;
	private String numdots;
	private String speed;

	
	public void lines(int steps)
	{
		
		Frame frame = new Frame();
		
		linex = new float[Integer.parseInt(numdots)][2];
		liney = new float[Integer.parseInt(speed)][2];
		int c = 0;
		Pen pen = new Pen(Color.Black);
		Graphics g = panel1.CreateGraphics();
		int x = 0;
		int speed = Integer.parseInt(textBox3.Text);
		if (x + steps < xc.length)
		{
			g.DrawLine(pen, xc[x] + 1, yc[x] + 1, xc[x + steps] + 1, yc[x + steps] + 1);
			linex[c][0] = xc[x] + 1;
			linex[c][1] = xc[x + steps] + 1;
			liney[c][0] = yc[x] + 1;
			liney[c][1] = yc[x + steps] + 1;
			c++;
			x = x + steps;
			Thread.sleep(speed);
		}
		if (x + steps >= xc.length)
		{
			g.DrawLine(pen, xc[x] + 1, yc[x] + 1, xc[(x + steps) % xc.length] + 1, yc[(x + steps) % xc.length] + 1);
			linex[c][0] = xc[x] + 1;
			linex[c][1] = xc[(x + steps) % xc.length] + 1;
			liney[c][0] = yc[x] + 1;
			liney[c][1] = yc[(x + steps) % xc.length] + 1;
			c++;
			x = (x + steps) % xc.length;
			Thread.sleep(speed);
		}
		
		while (x != 0)
		{
			if (x + steps < xc.length)
			{
				g.DrawLine(pen, xc[x] + 1, yc[x] + 1, xc[x + steps] + 1, yc[x + steps] + 1);
				linex[c][0] = xc[x] + 1;
				linex[c][1] = xc[x + steps] + 1;
				liney[c][0] = yc[x] + 1;
				liney[c][1] = yc[x + steps] + 1;
				x = x + steps;
				c++;
				Thread.sleep(speed);
			}
			else if (x + steps >= xc.length)
			{
				g.DrawLine(pen, xc[x] + 1, yc[x] + 1, xc[(x + steps) % xc.length] + 1, yc[(x + steps) % xc.length] + 1);
				linex[c][0] = xc[x] + 1;
				linex[c][1] = xc[(x + steps) % xc.length] + 1;
				liney[c][0] = yc[x] + 1;
				liney[c][1] = yc[(x + steps) % xc.length] + 1;
				c++;
				x = (x + steps) % xc.length;
				Thread.sleep(speed);
			}
		
	}
		g.dispose();
		pen.dispose();
		label5.Text = (new Integer(c)).toString();
		place = c - 1;
	}// end of lines
}//end of line class

