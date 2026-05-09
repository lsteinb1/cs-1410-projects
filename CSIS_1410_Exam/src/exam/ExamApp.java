package exam;

/**
 * Class to host main() and to test the classes set up in this project.
 * 
 * @author Lydia
 */
public class ExamApp {

	public static void main(String[] args) {
		WordPowerPlant[] plants = {
				new WordPowerPlant(100),
				new SolarWordPlant(200),
				new HydroWordPlant(900, true)
		};

		for (WordPowerPlant p : plants) {
			System.out.println(p.toString());
			System.out.println(p.generatesElectricity());
			System.out.println(p.transform("Hi_ho"));
			System.out.println(p.countLetters("Moehren"));
			if (p instanceof HydroWordPlant) {
				System.out.println(((HydroWordPlant)p).hasDam());
			}
			System.out.println();
		}
	}

}
