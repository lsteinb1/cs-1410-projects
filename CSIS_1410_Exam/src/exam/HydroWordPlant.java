package exam;

/**
 * HydroWordPlants can generate electricity from water, and they can optionally have a dam.
 * 
 * @author Lydia
 * 
 * "extends WordPowerPlant" wasn't actually specified in the exam instructions, but it was implied.
 */
public class HydroWordPlant extends WordPowerPlant{
	private boolean dam;

	/**
	 * Initializes instance of HydroWordPlant.
	 * @param dam
	 */
	public HydroWordPlant(int capacity, boolean dam) {
		super(capacity);
		this.dam = dam;
	}

	/**
	 * Returns whether the HydroWordPlant has a dam, true or false.
	 * @return boolean dam
	 */
	public boolean hasDam() {
		return dam;
	}
	
	/**
	 * Returns a message about generating electricity, and the method this instance uses for doing so.
	 */
	@Override
	public String generatesElectricity() {
		return super.generatesElectricity() + " from water";
	}
}