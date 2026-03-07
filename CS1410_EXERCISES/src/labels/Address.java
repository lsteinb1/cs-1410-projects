package labels;

/**
 * US address that is not a PO box.
 * 
 * @author CS + Lydia
 * 
 */
public class Address {
	private String street;
	private String city;
	private State state; //this is what the empty spot was for
	private int zip;
	
	/**
	 * Constructor initializes the field.
	 * 
	 * @param street  street address 
	 * @param city
	 * @param state  US State
	 * @param zip  5-digit zip code
	 */
	public Address(String street, String city, State state, int zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * Returns the street address.
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Returns the city of the address. // or town
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Returns the US State of the address. // specify the two-letter abbreviation!
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * Returns the 5-digit ZIP code of the address.
	 * @return the zip code
	 */
	public int getZip() {
		return zip;
	}
	
}
