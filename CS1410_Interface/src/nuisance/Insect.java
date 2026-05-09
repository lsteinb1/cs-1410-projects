package nuisance;

/**
 * 
 * 
 * @author Lydia, based on CSIS UML Class Diagram
 * 
 */
public class Insect {
	private String species;

	/**
	 * @param species
	 */
	public Insect(String species) {
		this.species = species;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @return a string in this format: {className}: {species}
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + species;
	}
}
