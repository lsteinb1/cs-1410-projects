package labels;

public class LabelApp {

	public static void main(String[] args) {
		Address address1 = new Address("137 James St", "Kent", State.WA, 98032);
		System.out.println("address1: " + address1.getStreet() + " " + address1.getCity() + " " + address1.getState() + " " + address1.getZip());
		Address address2 = new Address("139 James St", "Kent", State.WA, 98032);
		System.out.println("address2: " + address2);
		System.out.println();
		
		AddressLabel addressLabel1 = new AddressLabel("Dan", "Smith", address1);
		System.out.println("addressLabel: " + addressLabel1);
		System.out.println();
		addressLabel1.printLabel();
	}
}
