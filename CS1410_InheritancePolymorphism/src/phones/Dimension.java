package phones;

/**
 * Stores the dimensions of an object (height, width, and depth).
 *
 * @author Lydia
 * 
 */
public class Dimension {
	private double height;
	private double width;
	private double depth;
	
	/**
	 * @param height
	 * @param width
	 * @param depth
	 */
	public Dimension(double height, double width, double depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
		
		if (height < 1 || width < 1 || depth < 1) {
			throw new IllegalArgumentException("The height, width, and depth of a dimension needs to be positive.");
		}
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String roundHeight = String.format("%.1f", height * 1.0);
		String roundWidth = String.format("%.1f", width * 1.0);
		String roundDepth = String.format("%.1f", depth * 1.0);
		// suitable rounding solution found here:
		// https://stackoverflow.com/questions/22186778/using-math-round-to-round-to-one-decimal-place
		
		return "(" + roundHeight + " x " + roundWidth + " x " + roundDepth + ")";
	}
}
