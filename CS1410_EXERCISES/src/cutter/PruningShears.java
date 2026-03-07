package cutter;

/**
 * PruningShears are cutters that are used to prune plants.
 *
 * @author MargretP + Lydia
 * 
 */
public class PruningShears extends Cutter {

	/**
	 * Initializes the field called size of the superclass Cutter.
	 * @param size
	 */
	public PruningShears(int size) {
		super(size);
	}

	/**
	 * Returns the string "pruning" to indicate the way pruning shears cut.
	 */
	@Override
	public String cut() {
		return "pruning";
	}
}
