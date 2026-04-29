package abstractClass;

/**
 * 
 * @author Lydia + CS
 */
public class InkjetPrinter extends Printer {
	private int remainingCartridge;
	private String supplyType; /* something I added to make it easier to add more types of printers.
	* supplyType is toner for LaserPrinters and cartridge for InkjetPrinters.
	*/

	/**
	 * Initializes a new InkjetPrinter with model, sets supply to 100%, and sets supplyType.
	 * @param model
	 * @param remainingCartridge
	 */
	public InkjetPrinter(String model) {
		super(model);
		this.remainingCartridge = 100;
		this.supplyType = "cartridge";
	}
	
	/**
	 * @see original abstract method description: {@link #getRemainingSupply() Printer}
	 * @return the remainingCartridge
	 */
	@Override
	public int getRemainingSupply() {
		return remainingCartridge;
	}
	
	/**
	 * Extra method included for use in the JUnit Tests, because they don't include usage of supplyType nor getRemainingSupply().
	 * @return the remainingCartridge
	 */
	public int getRemainingCartridge() {
		return remainingCartridge;
	}
	
	/**
	 * Refills the ink cartridge to 100%.
	 */
	public void refillCartridge() {
		this.remainingCartridge = 100;
	}
	
	/**
	 * @return the supplyType
	 */
	@Override
	public String getSupplyType() {
		return supplyType;
	}
	
	/**
	 * Simulates trying to print using the Printer. If there is no ink in the cartridge,
	 * the console will print that it's empty. Otherwise, 'use up' 10% of the ink and print a message
	 * about the printing and the remaining ink.
	 */
	@Override
	public void print() {
		if (getRemainingSupply() == 0) {
			System.out.println("The " + supplyType + " is empty.");
		}
		else {
			remainingCartridge -= 10;
			System.out.println(this.getModel() +  " is printing. Remaining " + supplyType + ": " + this.getRemainingSupply() + "%");
		}
	}
}
