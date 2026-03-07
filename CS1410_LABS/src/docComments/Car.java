package docComments;

/**
 * Initializes a car object, described by its make, model, and miles per gallon.
 * 
 * @author Lydia
 * 
 */
public class Car {
	String make;
	String model;
	int mpg;
	
	/**
	 * @param the make of the car
	 * @param the model of the car
	 * @param the miles per gallon of the car
	 */
	public Car(String make, String model, int mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}

	/**
	 * @return the make of the car
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model of the car
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the mpg of the car
	 */
	public int getMpg() {
		return mpg;
	}
}
