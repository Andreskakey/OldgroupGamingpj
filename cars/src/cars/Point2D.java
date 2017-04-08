package cars;
/*
 ** the point2D 
 */
public class Point2D {
/*
 * the x and y private which mean only access by his 
 * own class or inside the class Point2D
 */
	private int x;
	private int y;

/*
 * This part will be the implementation of the x and y for the point2D classes
 * @overload the class Point2D with the X and Y axis 
 */
	Point2D() {
		this.setX(0);
		this.setY(0);
	}

	Point2D(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
/*
 * @Override the the String
 * 
 */
	
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	/*
	 * Comparing the x and y axis else it will return -1
	 */
	public int compareTo(Point2D point2D) {
		if (point2D.getX() == this.getX() && point2D.getY() == this.getY())
			return 0;
		else
			return -1;
	}
/*
 * The main method 
 */
	public static void main(String[] arg) {
		/*
		 * Using two different way to approach the Point2D
		 */
		Point2D point2dF = new Point2D();
		Point2D point2dS = new Point2D(10, 5);

		point2dF.setX(35);
		point2dF.setY(30);

		System.out.println("The first point: " + point2dF);
		System.out.println("The second point: " + point2dS);

		/*
		 * comparing points one with points two
		 */
		if (point2dF.compareTo(point2dS) == 0)
			System.out.println("Comparing the two points");
		else
			System.out.println("Then this two points are different ");
		
		/*
		 * overwritten  the points x and point y.
		 */
		point2dS.setX(point2dS.getX());
		point2dS.setY(point2dS.getY());
		/*
		 * Doing the same comparison instead comparing points two with points one 
		 * 
		 */
		if (point2dS.compareTo(point2dS) == 0)
			System.out.println("Two points are the similar");
		else
			System.out.println("Two points are the opposited");
	}
}
