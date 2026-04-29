package labCollection;

import java.awt.Color;
import java.util.Objects;

/**
 * 
 * 
 * @author Lydia
 */
public class Couch {
	// a class creates a new data type
	
	java.awt.Color color;
	Material material;
	
	/**
	 * 
	 * This is a "parameterized constructor that initializes the fields"
	 * @param color
	 * @param material
	 */
	public Couch(Color color, Material material) {
		this.color = color;
		this.material = material;
	}

	/**
	 * @return the color
	 */
	public java.awt.Color getColor() {
		return color;
	}

	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, material);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couch other = (Couch) obj;
		return Objects.equals(color, other.color) && material == other.material;
	}

	@Override
	public String toString() {
		// found hex format that worked here: https://stackoverflow.com/questions/3607858/convert-a-rgb-color-value-to-a-hexadecimal-string
		return "Couch: " + String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue()) + " " + material.toString().toLowerCase();
	}
}
