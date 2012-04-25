import java.awt.*;



public class Point {
	// point class, figures out where the points are in the circle
	public void Point(float x, float y) {
		
				
		SolidBrush sb = new SolidBrush(Color.Black);
        Graphics g = panel1.CreateGraphics();
        g.FillRectangle(sb, x, y, 3, 3);
        Thread.sleep(3000);
        
	}
}
