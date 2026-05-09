package phones;

/**
 * A DeskPhone that has buttons you can push to enter phone numbers to call.
 * 
 * @author Lydia
 * 
 */

public class PushButtonPhone extends DeskPhone {
	/**
	 * @param model
	 * @param dimensions
	 * @param voltage
	 * @param connected
	 */
	public PushButtonPhone(String model, Dimension dimensions, Voltage voltage) {
		super(model, dimensions, voltage);
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public String call(long number) {
		return "Pushing buttons to call " + number;
	}
}
