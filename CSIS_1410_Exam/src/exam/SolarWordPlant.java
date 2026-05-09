package exam;

/**
 * SolarWordPlants can generate electricity from the sun.
 * 
 * @author Lydia
 */
public class SolarWordPlant extends WordPowerPlant {

	/**
	 * Initializes instance of SolarWordPlant.
	 * @param capacity
	 */
	public SolarWordPlant(int capacity) {
		super(capacity);
	}
	
	/**
	 * Returns a message about generating electricity, and the method this instance uses for doing so.
	 */
	@Override
	public String generatesElectricity() {
		return super.generatesElectricity() + " from the sun";
	}
}