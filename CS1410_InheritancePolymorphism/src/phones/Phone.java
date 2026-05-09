package phones;

/**
 * An object that can make calls and has 3D dimensions (height, width, and depth).
 * 
 * @author Lydia
 * 
 */
public abstract class Phone {
	private String model;
	private Dimension dimensions;
	
	/**
	 * @param model
	 * @param dimension
	 */
	protected Phone(String model, Dimension dimensions) {
		this.model = model;
		this.dimensions = dimensions;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public abstract String call(long number);

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the dimensions
	 */
	public Dimension getDimensions() {
		return dimensions;
	}

	@Override
	public String toString() {
		return model + " " + dimensions;
	}
}
