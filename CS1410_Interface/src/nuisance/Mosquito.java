package nuisance;

/**
 * 
 * 
 * @author Lydia, based on CSIS UML Class Diagram
 * 
 */
public class Mosquito extends Insect implements Nuisance {

	/**
	 * 
	 * @param species
	 */
	public Mosquito(String species) {
		super(species);
	}
	
	/**
	 * 
	 */
	@Override
	public String annoy() {
		return "buzz buzz buzz";
	}
	
	/**
	 * 
	 * @return
	 */
	public String buzz() {
		return this.getSpecies() + " buzzing around";
	}
}