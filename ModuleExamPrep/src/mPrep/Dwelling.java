package mPrep;

/**
 * 
 */
public abstract class Dwelling {
	private int numberOfRooms;
	
	/**
	 * 
	 * @param numberOfRooms
	 */
	public Dwelling(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	
	/**
	 * 
	 * @return the numberOfRooms
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public abstract void heat();

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return "Dwelling [numberOfRooms=" + numberOfRooms + "]";
	}
}