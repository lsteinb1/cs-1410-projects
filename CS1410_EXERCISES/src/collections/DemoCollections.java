package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoCollections {
	
	public static List<Integer> shiftElements(List<Integer> list, int repeatTimes) {
		int firstNum = list.removeFirst();
		list.add(firstNum);
		
		if (repeatTimes > 0) { // if the shift should be repeated
			shiftElements(list, repeatTimes - 1); // calls recursively until repeatTimes is passed as 0
		}
		
		return list;
	}

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Collections.addAll(numbers, 10, 20, 30, 40, 50, 60, 70);
		System.out.println("Original list: " + numbers); // added Original list: from sample solution
		System.out.println();
		
		shiftElements(numbers, 2); // aw frick, Collections already has rotate(). Coulda just done Collections.rotate(numbers, -3);
		System.out.println("Shifted list: " + numbers);
		System.out.println();
		
		Collections.swap(numbers, 1, numbers.size() - 2); // heck yeah, I did this one right the first time
		System.out.println("Swapped list: " + numbers);
		System.out.println();
		
		System.out.println("Unsorted binarySearch: " + Collections.binarySearch(numbers, 50)); // this would've been more useful: System.out.printf("Number 50 is on index %d%n", result); 
		// this returns -3, which counts as undefined bc indices can't be negative (in Java)
		System.out.println();
		
		Collections.sort(numbers);
		System.out.println("Sorted list: " + numbers);
		System.out.printf("Number %d is at index %d.%n", 50, Collections.binarySearch(numbers, 50)); // should've included %n here at first
		System.out.println();
		
		Collections.shuffle(numbers);
		System.out.println("Shuffled list: " + numbers);
		System.out.println();
	}

}
