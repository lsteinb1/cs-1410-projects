package phones;

import java.util.Random; // for takePicture()

/**
 * A type of phone that can do a variety of things in addition to calling,
 * such as browsing and taking pictures.
 * 
 * @author Lydia
 * 
 */
public class SmartPhone extends Phone {
	private int storage;

	/**
	 * @param model
	 * @param dimension
	 * @param storage
	 */
	public SmartPhone(String model, Dimension dimensions, int storage) {
		super(model, dimensions);
		this.storage = storage;
		
		if (storage < 1) {
			throw new IllegalArgumentException("Storage needs to be assigned a positive value.");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public String call(long number) {
		return "Calling " + number + " by selecting the number";
	}
	
	/**
	 * 
	 * @return
	 */
	public String browse() {
		return "Browsing the web";
	}
	
	/**
	 * 
	 * @return
	 */
	public String takePicture() {
		Random rand = new Random();
		int randValue = rand.nextInt(2);
		
		if (randValue == 0) {
			return "Taking a horizontal picture";
		}
		else {
			return "Taking a vertical picture";
		}
	}

	@Override
	public String toString() {
		return this.getModel() + " " + this.getDimensions() + " " + storage + "GB";
	}
}
