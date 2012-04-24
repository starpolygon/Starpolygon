public class PointOnCircle {
	public void PointOnCircle(float angleInDegrees, int c)
    {
        float x = (float)(X + r * Math.Cos(angleInDegrees * Math.PI / 180 + Math.PI * 3/2));
        float y = (float)(Y + r * Math.Sin(angleInDegrees * Math.PI / 180 + Math.PI * 3/2));
        Point(x, y);
        float  xc[c] = x;
        float []yc[c] = y;
    }
}
