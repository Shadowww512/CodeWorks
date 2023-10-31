package labs.lab2;

/**
 * Represents a quadrilateral, given coordinates of its four corners.
 * Determines the shape of the quadrilateral ("Square", "Rectangle",
 * "Parallelogram", "Trapezoid", "Rhombus" or "None")
 */
public class Quadrilateral {

	// ADD INSTANCE VARIABLES EHRE

	
	/**
	 * Constructs a new Quadrilateral given the coordinates of its four corners 
	 * in the order they appear in a clockwise direction
	 * 
	 * @param ax	x-coordinate of the first vertex (A)
	 * @param ay	y-coordinate of the first vertex (A)
	 * @param bx	x-coordinate of the second vertex (B)
	 * @param by	y-coordinate of the second vertex (B)
	 * @param cx	x-coordinate of the third vertex (C)
	 * @param cy	y-coordinate of the third vertex (C)
	 * @param dx	x-coordinate of the fourth vertex (D)
	 * @param dy	y-coordinate of the fourth vertex (D)
	 */
	public Quadrilateral(double ax, double ay, double bx, double by, double cx, double cy, double dx, double dy) {
		// FILL IN
	}


	/**
	 * Gets the type of shape this quadrilateral is ("Square", "Rhombus, "Rectangle", 
	 * "Parallelogram", "Trapezoid", or "None"). When a shape falls in multiple
	 * categories, use the order of precedence just listed.
	 * 
	 * @return	"Square", "Rhombus, "Rectangle", "Parallelogram", "Trapezoid", or "None"
	 */
	public String getShapeType() {
		return ""; // FIX ME
	}
}
