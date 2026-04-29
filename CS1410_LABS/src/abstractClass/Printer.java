package abstractClass;

/**
 * Simulates a console-based printer that can print and needs supply refills.
 * 
 * @author Lydia + CS
 */
public abstract class Printer {
	private String model;
	private static int count;
	private int serialNumber;
	//private String supplyType;
	/* something I added to make it easier to add more types of printers.
	* supplyType is toner for LaserPrinters and cartridge for InkjetPrinters.
	* I commented out this instance of supplyType because it never gets used,
	* and has to be defined in each subclass anyway.
	* 
	* I would be interested in learning about a better way to declare and initialize
	* a variable like this, that has to be defined for each subclass but isn't passed in
	* to the constructor when objects are instantiated.
	*/
	
	/**
	 * @param model
	 * @param serialNumber
	 */
	protected Printer(String model) {
		this.model = model;
		count = count + 1; // the use case for fully writing it out instead of += ?
		this.serialNumber = 12345 + count;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * A placeholder method to be filled in with each subclass, so that supplyType can be accessed from PrinterApp for each subclass.
	 * I made it abstract because each subclass doesn't seem to get the local (correct) supplyType unless this method is overridden,
	 * so it had to be filled out in each subclass anyway.
	 */
	public abstract String getSupplyType();
	
	/**
	 * Prints a message about the simulated printing and how much supply is left.
	 * With supplyType and getRemainingSupply, this probably doesn't have to be abstract?
	 * The code is already almost the same on each Printer type with my system.
	 */
	public abstract void print();
	
	/**
	 * A combined getRemaining method. Both types of Printers can use it, as long as they return the correct variable in their overridden method.
	 * This is so they can each use the same method call to get their respective supply variable.
	 */
	public abstract int getRemainingSupply();

	/**
	 * Returns a string in the following format:
	 * {className}: {model} #{serialNumber}
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + model + " #" + serialNumber;
	}
}
