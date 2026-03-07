package docComments;

/**
 * Gives information (eg, fuel consumption) relevant to trip planning using departure and arrival locations,
 * 		the distance in miles between them, and what kind of car is being used on the trip.
 * Takes String departure, String arrival, int distance, and Car car.
 * 
 * @author Lydia
 */
public class TripPlanner {
	String departure;
	String arrival;
	int distance;
	Car car;
	
	/**
	 * @param departure location
	 * @param arrival location
	 * @param distance in miles
	 * @param car for trip travel
	 */
	public TripPlanner(String departure, String arrival, int distance, Car car) {
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
		this.car = car;
	}
	
	/**
	 * @returns the fuel consumed when traveling the trip distance
	 */
	public double fuelConsumption() {
		double fuelConsumed = distance / (double) car.getMpg();
		return fuelConsumed;
	}

	@Override
	public String toString() {
		return "TripPlanner [departure=" + departure + ", arrival=" + arrival + ", distance=" + distance + ", car="
				+ car.getModel() + "]";
	}
}