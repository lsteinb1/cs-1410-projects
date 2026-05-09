package mPrep;

/**
 * 
 */
public class House extends Dwelling {
	private boolean hasPool;
	private Leed leed;
	
	/**
	 * 
	 * @param numberOfRooms
	 * @param hasPool
	 * @param leed
	 */
	public House(int numberOfRooms, boolean hasPool, Leed leed) {
		super(numberOfRooms);
		this.hasPool = hasPool;
		this.leed = leed;
	}

	/**
	 * @return hasPool: true or false
	 */
	public boolean hasPool() {
		return hasPool;
	}
	
	/**
	 * 
	 */
	public void poolParty() {
		// TODO
	}
	
	/**
	 * 
	 */
	public void heat() {
		// TODO
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "House [hasPool=" + hasPool + ", leed=" + leed + "]";
	}
}
