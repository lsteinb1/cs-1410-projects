package phones;

/**
 * A type of DeskPhone with a dial you rotate to enter numbers to call.
 * 
 * @author Lydia
 * 
 */
public class RotaryPhone extends DeskPhone {

	/**
	 * @param model
	 * @param dimensions
	 * @param voltage
	 * @param connected
	 */
	public RotaryPhone(String model, Dimension dimensions, Voltage voltage) {
		super(model, dimensions, voltage);
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public String call(long number) {
		return "Rotating the dial to call " + number;
	}
}
