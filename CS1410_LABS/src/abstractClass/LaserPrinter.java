package abstractClass;

/**
 * A type of Printer that uses toner rather than an ink cartridge.
 * 
 * @author Lydia + CS
 */
public class LaserPrinter extends Printer {
	private int remainingToner;
	private String supplyType;

	/**
	 * Initializes a new LaserPrinter with model, sets supply to 100%, and sets supplyType.
	 * @param model
	 * @param serialNumber
	 * @param remainingToner
	 */
	public LaserPrinter(String model) {
		super(model);
		this.remainingToner = 100;
		this.supplyType = "toner";
	}
	
	/**
	 * @see original abstract method description: {@link #getRemainingSupply() Printer}
	 * @return the remainingToner
	 */
	@Override
	public int getRemainingSupply() {
		return remainingToner;
	}
	
	/**
	 * Extra method included for use in the JUnit Tests, because they don't include usage of supplyType nor getRemainingSupply().
	 * @return the remainingToner
	 */
	public int getRemainingToner() {
		return remainingToner;
	}
	
	/**
	 * Refills the Toner to 100%.
	 */
	public void refillToner() {
		this.remainingToner = 100;
	}
	
	/**
	 * 
	 * @return the supplyType
	 */
	@Override
	public String getSupplyType() {
		return supplyType;
	}
	
	/**
	 * Simulates trying to print using the Printer. If there is no toner in the cartridge,
	 * the console will print that it's empty. Otherwise, 'use up' 10% of the toner and print a message
	 * about the printing and the remaining toner.
	 */
	@Override
	public void print() {
		if (getRemainingSupply() == 0) {
			System.out.println("The " + supplyType + " is empty.");
		}
		else {
			remainingToner -= 10;
			System.out.println(this.getModel() +  " is printing. Remaining " + supplyType + ": " + this.getRemainingSupply() + "%");
		}
	}
}
