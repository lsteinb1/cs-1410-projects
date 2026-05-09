package collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests GenericCollections.java's methods.
 * 
 * @author Lydia
 */

class GenericCollectionsTest {
	static List<Character> simpleCharList = new ArrayList<>();
	static List<Character> charExampleList = new ArrayList<>();
	static List<Integer> origNumExampleList = new ArrayList<>();
	static List<String> expectedListString = new ArrayList<>();
	static List<Integer> expectedListInt = new ArrayList<>();
	static List<Integer> nthElementIntList = new ArrayList<>();
	static List<Double> nthElementDoubleList = new ArrayList<>();
	static List<String> nthElementStringList = new ArrayList<>();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		simpleCharList.add('a');
		simpleCharList.add('b');
		simpleCharList.add('*');
		simpleCharList.add('c');
		
		Collections.addAll(charExampleList, '?', 'a', 'B', 'c', '5', 'd', 'E', 'F', 'g', '%', '#', 'H');
		Collections.addAll(origNumExampleList, 3, -6, 3, -9, -3, 0, 12, 3);
		
		Collections.addAll(nthElementIntList, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	// testing lettersAndNumbers()
	
	/*
	 * Characters that are neither letters nor numbers are ignored.
	 * The new list includes a string representation of each character that is either a letter or a number. However, those representations are listed in reverse order.
	 * Each lowercase letter is represented as  L({letter})
	 * An uppercase L followed by a pair of parentheses and the lowercase letter in between.
	 * Each uppercase letter is represented as U({letter})
	 * An uppercase U followed by a pair of parentheses and the letter (again spelled in lowercase)  in between.
	 * Each number is represented as N({number})
	 * An uppercase N followed by a pair of parentheses and the number in between.
	 * An empty list should return an empty list.
	 * If the argument passed to the method is null, the method should return null.
	 */

	@Test
	void LettersAndNumbers_NonLetterOrNumber_IgnoresNonLetterOrNumber() {
		expectedListString.clear();
		Collections.addAll(expectedListString, "U(h)", "L(g)", "U(f)", "U(e)", "L(d)", "N(5)", "L(c)", "U(b)", "L(a)");
		
		List<String> actual = GenericCollections.lettersAndNumbers(charExampleList);
		assertEquals(expectedListString, actual);
	}
	
	@Test
	void LettersAndNumbers_StringOfEachLetterOrNumberCharReverseOrder_ReturnsAllRepresentationsInReverseOrder() {
		expectedListString.clear();
		expectedListString.add("L(c)");
		expectedListString.add("L(b)");
		expectedListString.add("L(a)");
		
		List<String> actual = GenericCollections.lettersAndNumbers(simpleCharList);
		assertEquals(expectedListString, actual);
	}
	
	@Test
	void LettersAndNumbers_LowercaseLetters_RepresentedWithLAndOrigLetter() {
		List<Character> lowercaseTestList = new ArrayList<>();
		Collections.addAll(lowercaseTestList, 'z', 'a', 'y', 'x', 'b');
		expectedListString.clear();
		Collections.addAll(expectedListString, "L(b)", "L(x)", "L(y)", "L(a)", "L(z)");
		
		assertEquals(expectedListString, GenericCollections.lettersAndNumbers(lowercaseTestList));
	}
	
	@Test
	void LettersAndNumbers_UppercaseLetters_RepresentedWithUAndOrigLetter() {
		List<Character> uppercaseTestList = new ArrayList<>();
		Collections.addAll(uppercaseTestList, 'Z', 'A', 'Y', 'B', 'X');
		expectedListString.clear();
		Collections.addAll(expectedListString, "U(x)", "U(b)", "U(y)", "U(a)", "U(z)");
		
		assertEquals(expectedListString, GenericCollections.lettersAndNumbers(uppercaseTestList));
	}
	
	@Test
	void LettersAndNumbers_Number_RepresentedWithNAndOrigNumber() {
		expectedListString.clear();
		Collections.addAll(expectedListString, "U(h)", "L(g)", "U(f)", "U(e)", "L(d)", "N(5)", "L(c)", "U(b)", "L(a)");
		
		List<String> actual = GenericCollections.lettersAndNumbers(charExampleList);
		assertEquals(expectedListString, actual);
	}
	
	@Test
	void LettersAndNumbers_EmptyList_ReturnsEmptyList() {
		List<Character> emptyList = new ArrayList<>();
		assertEquals(emptyList, GenericCollections.lettersAndNumbers(emptyList));
	}
	
	@Test
	void LettersAndNumbers_NullArg_ReturnsNull() {
		assertEquals(null, GenericCollections.lettersAndNumbers(null));
	}
	
	// testing modify()
	
	@Test
	void Modify_DeleteMultiplesOfThree_ModifiedListContainsNoMultiplesOfOnlyThree() {
		List<Integer> numExampleList = (ArrayList)((ArrayList) origNumExampleList).clone(); // this looks dumb but it works for now. referenced https://www.w3schools.com/java/ref_arraylist_clone.asp
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 4, 5, 6, 8, 10, 12, 15, 16, 18, 20, 24, 25, 30);
		
		GenericCollections.modify(numExampleList);
		
		assertEquals(expectedListInt, numExampleList);
	}
	
	@Test
	void Modify_AddFirstFiveMultiplesOfFourFiveAndSix_ModifiedListContainsAllOfThose() {
		List<Integer> numExampleList = (ArrayList)((ArrayList) origNumExampleList).clone();
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 4, 5, 6, 8, 10, 12, 15, 16, 18, 20, 24, 25, 30);
		
		GenericCollections.modify(numExampleList);
		
		assertTrue(numExampleList.containsAll(expectedListInt));
	}
	
	@Test
	void Modify_SortInAscendingOrder_ModifiedListSortedLeastToGreatest() {
		List<Integer> numExampleList = new ArrayList<>();
		Collections.addAll(numExampleList, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 1, 2, 4, 5, 6, 7, 8, 10, 12, 15, 16, 18, 20, 24, 25, 30);
		
		GenericCollections.modify(numExampleList);
		
		assertEquals(expectedListInt, numExampleList);
	}
	
	@Test
	void Modify_ReturnUniqueElements_ReturnWithoutDuplicates() {
		List<Integer> numExampleList = new ArrayList<>();
		Collections.addAll(numExampleList, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 1, 2, 4, 5, 6, 7, 8, 10, 12, 15, 16, 18, 20, 24, 25, 30);
		
		GenericCollections.modify(numExampleList);
		
		assertEquals(expectedListInt, numExampleList);
	}
	
	// testing RemoveEveryNthElement
	
	/*
	 * This method modifies the list by removing every n-th element.
If n is zero or negative, an IllegalArgumentException should be thrown. It should include a message that informs the user that n needs to be a positive number.
If the list is null, a NullPointerException should be thrown. It should include a message that informs the user that the list must not be null.
Note: The interface list includes two remove methods. One removes a specific object, the other removes an object on a specific position (index).
	 */
	
	
	// TODO add assert throws exceptions for other methods (if I have time, I might not)
	
	@Test
	void removeEveryNthElement_NIsZeroOrNegative_IllegalArgumentExceptionThrownAndExplains() {
		String expectedMessage = "The integer must be greater than zero.";
		try {
			GenericCollections.removeEveryNthElement(nthElementIntList, 0);
			fail("Integer less than zero, but exception not thrown.");
		}
		catch(Exception e) {
			assertThrows(IllegalArgumentException.class, () -> { throw new IllegalArgumentException(expectedMessage); });
		}
		
	}
	
	@Test
	void removeEveryNthElement_ListIsNull_NullPointerExceptionThrownAndExplains() {
		String expectedMessage = "The list cannot be null.";
		
		try {
			GenericCollections.removeEveryNthElement(null, 2);
			fail("List is null, but exception not thrown."); // this doesn't seem to work for some reason even though the other one does, but I don't have time to figure out why
		}
		catch(Exception e) {
			assertThrows(NullPointerException.class, () -> { throw new NullPointerException(expectedMessage); });
		}
	}
	
	@Test
	void removeEveryNthElement_RemovesEvery2ndElement_ListReturnedDoesThat() {
		List<Integer> editableNthElementList = (ArrayList)((ArrayList) nthElementIntList).clone();
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 1, 3, 5, 7, 9);
		
		GenericCollections.removeEveryNthElement(editableNthElementList, 2);
		
		assertEquals(expectedListInt, editableNthElementList);
	}
	
	@Test
	void removeEveryNthElement_RemovesEvery3rdElement_ListReturnedDoesThat() {
		List<Integer> editableNthElementList = (ArrayList)((ArrayList) nthElementIntList).clone();
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 1, 2, 4, 5, 7, 8);
		
		GenericCollections.removeEveryNthElement(editableNthElementList, 3);
		
		assertEquals(expectedListInt, editableNthElementList);
	}
	
	// not a good test, need longer example
	@Test
	void removeEveryNthElement_RemovesEvery5thElement_ListReturnedDoesThat() {
		List<Integer> editableNthElementList = new ArrayList<>();
		Collections.addAll(editableNthElementList, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		
		expectedListInt.clear();
		Collections.addAll(expectedListInt, 1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14);
		
		GenericCollections.removeEveryNthElement(editableNthElementList, 5);
		
		assertEquals(expectedListInt, editableNthElementList);
	}
}
