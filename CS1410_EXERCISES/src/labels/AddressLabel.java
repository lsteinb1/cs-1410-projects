package labels;

/**
 * Arranges an address label from the address and relevant information.
 * Includes the addressee's first name, last name, US address, city, state, and ZIP code.
 * @author CS + Lydia
 * ("represents an address label" is a good way to put it)
 */
public class AddressLabel {
	private String firstName;
	private String lastName;
	private Address address;
	
	/**
	 * Constructor of class AddressLabel.
	 * 
	 * @param firstName  first name of the addressee
	 * @param lastName  last name of the addressee
	 * @param address  US address of the addressee
	 */
	public AddressLabel(String firstName, String lastName, Address address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	/**
	 * Prints an address label on three consecutive lines, </br>including firstName, lastName, address, city, state, and zip code.</br>
	 * (could also have described the format)
	 */
	public void printLabel() {
		System.out.printf("%s %s\n", firstName, lastName);
		System.out.printf("%s\n", address.getStreet());
		System.out.printf("%s, %s %d\n", address.getCity(), address.getState(), address.getZip()); // ohhh, of the instance!
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressLabel [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
}
