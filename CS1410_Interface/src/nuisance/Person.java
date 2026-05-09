package nuisance;

/**
 * 
 * 
 * @author Lydia, based on CSIS UML Class Diagram
 * 
 */
public class Person {
	private String name;
	private int age;
	
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		if (age < 1 || age > 150) {
			throw new IllegalArgumentException("Age needs to be from the range [1, 150].");
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return a string of the format {name}({age}) 
	 */
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}

	/**
	 * 
	 */
	public boolean equals(Person otherPerson) {
		if (otherPerson == null) {
			return false;
		}
		else if (this == otherPerson) { // if referencing the same object twice
			return true;
		}
		else if (this.getName() == otherPerson.getName() && this.getAge() == otherPerson.getAge()) {
			return true; // if same name and age
		}
		else {
			return false;
		}
	}
}
