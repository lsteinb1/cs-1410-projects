package keyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClient {

	public static void main(String[] args) {
		System.out.println("Part 1:");
		System.out.println("----------");
		
		KeyValuePair<String, Integer> city1 = new KeyValuePair<>("SLC", 189899);
		KeyValuePair<String, Integer> city2 = new KeyValuePair<>("NY", 8244910);
		System.out.println("city1: " + city1);
		System.out.println("city2: " + city2);
		System.out.println("city1 equals city2: " + city1.equals(city2));
		System.out.println();
		
		KeyValuePair<String, Integer> city3 = new KeyValuePair<>("NY", 8244910);
		System.out.println("city3: " + city3);
		System.out.println("city2 equals city3: " + city2.equals(city3));
		System.out.println("\n");
		
		System.out.println("Part 2:");
		System.out.println("----------");
		KeyValuePair<String, Integer> city4 = new KeyValuePair<>("LA", 3819702);
		KeyValuePair<String, Integer> city5 = new KeyValuePair<>("SF", 812826);
		List<KeyValuePair<String, Integer>> cities = new ArrayList<>();
		Collections.addAll(cities, city1, city2, city3, city4, city5);
		System.out.println("Original list:");
		cities.forEach(city -> System.out.println(city));
		System.out.println();
		
		cities.sort(null);
		System.out.println("Sorted list:");
		cities.forEach(city -> System.out.println(city));
		System.out.println("\n");
		
		System.out.println("Part 3:");
		System.out.println("----------");
		printWithMargin(cities, 5, "Cities");
		Set<KeyValuePair<String, Integer>> countryCodes = new HashSet<>();
		Collections.addAll(countryCodes, new KeyValuePair<>("Greece", 30), new KeyValuePair<>("France", 33), new KeyValuePair<>("Austria", 43));
		System.out.println();
		printWithMargin(countryCodes, 3, "Country codes");
	}

	static <T> void printWithMargin(Collection<T> collection, int indentation, String name) {
		System.out.printf("%s with margin %d:%n", name, indentation);
		collection.forEach(e -> System.out.print(" ".repeat(indentation) + e + "\n"));
		// learned repeat method from here: https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string
	}
}
