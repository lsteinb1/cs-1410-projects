package labCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author Lydia
 */
public class Warmup {

	public static void main(String[] args) {
		numbersListOperations();
	}

	private static void numbersListOperations() {
		List<Integer> numbers = new ArrayList<>(); // incl "programming to an interface"
		for(int i = 2; i <= 50; i += 2) {
			numbers.add(i);
		}
		
		printNumbers(numbers);
		
		System.out.println("Removing multiples of three...");
		numbers.removeIf(x -> x % 3 == 0);
		printNumbers(numbers);
	}

	private static void printNumbers(List<Integer> numbers) {
		System.out.print("numbers: ");
		numbers.forEach(n -> System.out.print(n + " "));
		System.out.println();
	}

}
