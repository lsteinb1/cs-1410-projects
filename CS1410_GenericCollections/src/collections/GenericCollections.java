package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Manipulates different types of ArrayLists in a few ways, including labeling letters and numbers, modifying a list of numbers in a few ways,
 * and removing every nth element as specified by the user (or the person that calls the method).
 * 
 * @author Lydia
 */

public class GenericCollections {
	public static List<String> lettersAndNumbers(List<Character> list){
		if (list == null) {
			return null;
		}
		else {
			List<String> returnList = new ArrayList<>();
			if (list.size() < 1) { // if empty list
				return returnList;
			}
			for (int i = list.size() - 1; i >= 0; i--) { // returns reversed
				char ch = list.get(i);
				if(Character.isLetter(ch)) {
					if(Character.isLowerCase(ch)) {
						returnList.add("L(" + ch + ")");
					}
					else {
						returnList.add("U(" + Character.toLowerCase(ch) + ")"); // uppercase
					}
				}
				if(Character.isDigit(ch)) {
					returnList.add("N(" + ch + ")");
				}
			}
			return returnList;
		}
	}
	
	public static int modify(List<Integer> list) {
		if (list == null) {
			throw new NullPointerException("List must not be null.");
		}
		else {
			list.removeIf(e -> (e % 3 == 0)); // if element is a multiple of three
			for(int i = 1; i <= 5; i++) {
				list.add(4 * i);
				list.add(5 * i);
				list.add(6 * i);
			}
			// list.sort(null);
		}
		
		Set<Integer> listToSet = Set.copyOf(list); // original solution that didn't scale to the test bc it's not sorted if it's a set
		list.clear();
		list.addAll(listToSet);
		list.sort(null);
		
		/*list = list.stream()
                .distinct()
                .collect(Collectors.toList());*/
		return listToSet.size();
	}
	
	public static void removeEveryNthElement(List<?> list, int n) {
		if (list == null) {
			throw new NullPointerException("The list cannot be null.");
		}
		else if (n < 1) {
			throw new IllegalArgumentException("The integer must be greater than zero.");
		}
		int counter = 1;
		for (int i = 1; i < list.size(); i++) {
			counter++;
			if (counter == n) {
				list.remove(i);
				counter = 1;
			}
		}
	}
}
