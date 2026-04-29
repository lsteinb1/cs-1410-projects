package guitar;

public class GuitarApp {

	public static void main(String[] args) {
		Guitar guitar1 = new Guitar(true, 6);
		Guitar guitar2 = new Guitar(false, 12); // acoustic
		Guitar guitar3 = new Guitar(true, 6);
		
		Guitar[] guitars = {guitar1, guitar2, guitar3};
		for (Guitar g : guitars) {
			System.out.println(g.toString()); // automatically calls the toString method
		}
		System.out.println();
		
		System.out.println("guitar1 equals guitar2: " + guitar1.equals(guitar2));
		System.out.println("guitar1 equals guitar3: " + guitar1.equals(guitar3));
		System.out.println();
		
		System.out.println("guitar1 compared to guitar2: " + guitar1.compareTo(guitar2));
		System.out.println("guitar2 compared to guitar3: " + guitar2.compareTo(guitar3));
		System.out.println("guitar1 compared to guitar3: " + guitar1.compareTo(guitar3));
		System.out.println();
	}

}
