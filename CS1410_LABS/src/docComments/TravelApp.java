package docComments;

/**
 * Tests the TripPlanner and Car classes.
 * 
 * @author Lydia
 */
public class TravelApp {

	public static void main(String[] args) {
		Car m4 = new Car("BMW", "M4", 25);
		Car civic = new Car("Honda", "Civic", 42);
		Car[] cars = {m4, civic};
		System.out.println("Cars:");
		
		for (Car car : cars){
			System.out.printf("%s %s %d mpg%n", car.getMake(), car.getModel(), car.getMpg());	
		}
		
		TripPlanner californiaTrip = new TripPlanner("San Francisco", "Los Angeles", 382, m4);
		TripPlanner floridaTrip = new TripPlanner("Tampa", "Miami", 280, civic);
		//TripPlanner[] trips = {californiaTrip, floridaTrip};
		
		System.out.println();
		System.out.println("California Trip:");
		System.out.println(californiaTrip.toString());
		System.out.printf("fuel consumption: %,.1f gallons%n", californiaTrip.fuelConsumption());
		System.out.println();
		
		System.out.println("Florida Trip:");
		System.out.println(floridaTrip.toString());
		System.out.printf("fuel consumption: %,.1f gallons", floridaTrip.fuelConsumption());
	}
}
