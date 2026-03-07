package cutter;

/**
 * Electric pruning shears are pruning shears that are powered by electricity.
 * 
 * @author MargretP + Lydia
 * 
 */
public class ElectricPruningShears extends PruningShears {
	private boolean power;

	/**
	 * Initializes the field size only. For new electric pruning shears
	 * the power is always off initially.
	 * @param size
	 * @param power
	 */
	public ElectricPruningShears(int size) {
		super(size);
		// this.power = power; // not needed, the power initially defaults to off
	}
	
	/**
	 * Gets the value (true or false) of the boolean called power.
	 * 
	 * @return the power boolean (whether or not the ElectricPruningShears are receiving power)
	 */
	public boolean isOn() {
		return power;
	}
	
	/**
	 * Toggles the boolean called power. (turns on if off, and off if on)
	 */
	public void onOff() {
		// easy way to do this: power = !power; (whatever it wasn't before)
		if (isOn()) {
			power = false;
		}
		else {
			power = true;
		}
	}
	
	/**
	 * Prints a statement about how it cuts (like PruningShears) if the power is on; otherwise, returns a string detailing the problem.
	 * 
	 * @return if power is on: PruningShears' cut(); else, returns a string about the problem
	 */
	@Override
	public String cut() {
		if(isOn()) {
			return super.cut();
		}
		else {
			return "The power is off, so the ElectricPruningShears can't cut."; // could be an empty string, as in the example
		}
	}
	
	/**
	 * Returns the superclass' toString as well as whether the power is on or off.
	 *
	 * @return Cutter's toString method's string + power={on|off}
	 */
	@Override
	public String toString() {
		String onOrOff;
		if (isOn()) {
			onOrOff = "on";
		}
		else {
			onOrOff = "off";
		}
		
		return super.toString() + " power=" + onOrOff;
		// easy way to do this: (power ? "on" : "off");
	}
}
