package phones;

/**
 * A DeskPhone is an older style of phone that's meant to sit on a desk. They have to be plugged in to be used.
 * 
 * @author Lydia
 * 
 */

public abstract class DeskPhone extends Phone {
	private Voltage voltage;
	private boolean connected; // not initialized on construction
	
	/**
	 * @param model
	 * @param dimensions
	 * @param voltage
	 */
	protected DeskPhone(String model, Dimension dimensions, Voltage voltage) {
		super(model, dimensions);
		this.voltage = voltage;
	}
	
	public void plugIn() {
		connected = true;
	}
	
	public void unplug() {
		connected = false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isConnected() {
		return connected;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.getModel() + " " + this.getDimensions() + " " + voltage + " " + (this.isConnected() ? "connected" : "not connected");
	}
}
