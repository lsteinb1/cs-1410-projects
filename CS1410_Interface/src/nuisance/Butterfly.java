package nuisance;

import java.util.List;

/**
 * An object representing a butterfly.
 * 
 * @author Lydia, based on CSIS UML Class Diagram
 * 
 */
public class Butterfly extends Insect {
	private List<String> colors; // keep in mind this is a mutable type
	private List<String> ogColors; // defensive copy. Short for "original colors"
	
	/**
	 * @param species
	 * @param colors
	 */
	public Butterfly(String species, List<String> colors) {
		super(species);
		ogColors = List.copyOf(colors); // using the defensive copy. Needs to use some kind of copyOf
		this.colors = ogColors;
		// video for help w/ defensive copies: https://youtu.be/40OvQLiNCP8?si=EmA_AZD4mEguJ5Od
	}
	
	public Butterfly(Butterfly butterfly) { // copy constructor
		// link for help w/ copy constructors: https://www.tutorialspoint.com/article/what-are-copy-constructors-in-java
		super(butterfly.getSpecies());
		ogColors = List.copyOf(butterfly.colors); // this is important here too
		this.colors = ogColors;
	}

	/**
	 * @return the colors
	 */
	public List<String> getColors() {
		return ogColors;
	}

	/**
	 * @return 
	 */
	@Override
	public String toString() {
		StringBuilder allColorsString = new StringBuilder(getSpecies() + " [");
		for (String color : ogColors) {
			if (ogColors.lastIndexOf(color) == ogColors.size() - 1) { // if last color in list
				allColorsString.append(color + "]");
			}
			else {
				allColorsString.append(color + ", ");
			}
		}
		return new String(allColorsString);
	}
}
