package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Demonstrates how to iterate through a collection using the method forEach
 * and lambda expressions.
 * 
 * @author Lydia + MargretP
 */
public class DemoForEach {

	public static void main(String[] args) {
		// demoForEachWithListOfStrings();
		
		Random rand = new Random();
		
		demoForEachWithListAndSet(rand);
	}

	private static void demoForEachWithListAndSet(Random rand) {
		List<Integer> numberList = new ArrayList<>();
		for(int i = 0; i < 15; i++) {
			// another way to generate random numbers, which doesn't need an import:
			// int randomNumber = (int) Math.floor(Math.random() * 10);
			numberList.add(rand.nextInt(10));
		}
		System.out.print("numberList: ");
		numberList.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// lambdas can take any Consumer - a method that takes a value and does not return a value
		List<Integer> numberList2 = new ArrayList<>();
		numberList.forEach(n -> numberList2.add(10 * n));
		System.out.println("numberList2: " + numberList2);
		
		Set<Integer> numberSet = new HashSet<>();
		numberSet.addAll(numberList2); // in interface Collection, not Collections. similar terms, but a bit different
		System.out.println("numberSet: " + numberSet); // all duplicates removed in set
		// elements in a set don't typically have positions, and they include no duplicates
		
		System.out.print("numberSet: ");
		numberSet.forEach(n -> System.out.print(n + " "));
		System.out.println();
	}

	@SuppressWarnings("unused")
	private static void demoForEachWithListOfStrings() {
		List<String> instruments = new ArrayList<>();
		Collections.addAll(instruments, "Bongo", "Bugle", "Cello",
				"Chime", "Flute", "Piano", "Taiko", "Viola");
		System.out.println("instruments: " + instruments);
		// Collection interface extends Iterable
		// Iterables have a forEach() method
		
		System.out.print("instruments: ");
		for(String el : instruments) {
			System.out.print("[" + el + "] ");
		}
		System.out.println();
		
		System.out.print("instruments: ");
		instruments.forEach(el -> System.out.print("[" + el + "] "));
		System.out.println();
		
		System.out.print("instruments: ");
		instruments.forEach(el -> System.out.print("[" + el.toLowerCase() + "] "));
		System.out.println();
		
		// separated by vertical bars
		System.out.print("instruments: ");
		instruments.forEach(el -> System.out.print(el + "|" + el + " "));
		System.out.println();
	}

}