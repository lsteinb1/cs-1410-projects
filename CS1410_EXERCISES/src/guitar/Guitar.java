package guitar;

import java.util.Objects;

/**
 * Guitar that is defined by its type (electric or acoustic)
 * and the number of strings.
 * 
 * @author Lydia & CSIS
 * 
 */
public class Guitar implements Comparable<Guitar>{
	private boolean electric;
	private int numberOfStrings;
	
	/**
	 * Initializes the fields based on the argument values.
	 * 
	 * @param electric
	 * @param numberOfStrings
	 */
	public Guitar(boolean electric, int numberOfStrings) {
		this.electric = electric;
		this.numberOfStrings = numberOfStrings;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(electric, numberOfStrings);
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	// original equals method compares references - whether they reference the same object
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guitar other = (Guitar) obj;
		return electric == other.electric && numberOfStrings == other.numberOfStrings;
	}

	/**
	 * Returns a string of the following format:
	 * {electric|acoustic} guitar with {numberOfStrings} strings
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (electric ? "electric" : "acoustic") + " guitar with " + numberOfStrings + " strings";
		//  ternary operator example from w3schools. Parentheses important
	}

	/**
	 * Compares this guitar with the other guitar based on the volume they can produce.
	 * Electric guitars are greater than their acoustic counterpart. If both guitars are
	 * of the same type, the number of strings decides the result of the comparison.
	 * More strings makes a guitar greater than one with less strings. If two guitars
	 * have the same type and the same number of strings, they are considered equal.
	 */
	// compareTo should be implemented with the same logic as equals(), as far as what's counted
	@Override
	public int compareTo(Guitar otherGuitar) {
		int guitarScore = 0;
		int otherScore = 0;
		
		if (this == otherGuitar)
			return 0;
		if (otherGuitar == null)
			return 1;
		else{
			// calculate comparison scores.
			// This could've been shorter if I'd just compared their electric values,
			// and if they were the same returned this.numberOfStrings - other.numberOfStrings
			// if (this.electric != other.electric)
				// return this.electric ? 1 : -1
			if (this.electric) {
				guitarScore++;
			}
			if (otherGuitar.electric) {
				otherScore++;
			}
			if (guitarScore == otherScore) { // if both same type
				guitarScore += this.numberOfStrings;
				otherScore += otherGuitar.numberOfStrings;
				return guitarScore - otherScore;
			}
			else {
				return guitarScore - otherScore; // these parts I did similarly to her
			}
		}
	}
}
