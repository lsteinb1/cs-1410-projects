package wrapperClass;

import java.util.Arrays;
import java.util.Random;

/**
 * Demonstrates some usages for wrapper classes.
 * 
 * @author Lydia + a small utility method from GeeksForGeeks
 * 
 */
public class DemoWrapperClass {
	
	public final static Random rand = new Random();
	public final static String letters = "abcdefghijklmnopqrstuvwxyz"; // used in charProperties and getRandomLetter
	
	/**
	 * Returns a string with the min and max values for each number type.
	 * 
	 * @return in a format with 7-spaced left justify spacing, and both values for each number type contained in square brackets [ , ].
	 */
	public static String minMax() {
		// final String[] numberTypes = {"Byte", "Short", "Integer", "Long", "Float", "Double"};
		StringBuilder output = new StringBuilder();
		
		output.append(String.format("%-7s: [%d , %d]%n", "Byte", Byte.MIN_VALUE, Byte.MAX_VALUE));
		output.append(String.format("%-7s: [%d , %d]%n", "Short", Short.MIN_VALUE, Short.MAX_VALUE));
		output.append(String.format("%-7s: [%d , %d]%n", "Integer", Integer.MIN_VALUE, Integer.MAX_VALUE));
		output.append(String.format("%-7s: [%d, %d]%n", "Long", Long.MIN_VALUE, Long.MAX_VALUE));
		output.append(String.format("%-7s: [%e , %e]%n", "Float", Float.MIN_VALUE, Float.MAX_VALUE));
		output.append(String.format("%-7s: [%e , %e]", "Double", Double.MIN_VALUE, Double.MAX_VALUE));
		// found solution with %e from: https://www.w3schools.com/java/ref_string_format.asp
		
		return new String(output);
	}
	
	/**
	 * Converts the given number to the destination base (dBase) from the sourceBase (name edited from sBase). Code borrowed from the following site:
	 * https://www.geeksforgeeks.org/java/base-conversion-in-java/
	 * @author GeeksForGeeks
	 * 
	 * @param number as a string
	 * @param sourceBase
	 * @param dBase - destination base
	 * @return a string of the number converted to the destination base that was passed as an argument.
	 */
	public static String baseConversion(String number, int sourceBase, int dBase)
    {
        // Parse the number with source radix
        // and return in specified radix(base)
        return Integer.toString(
            Integer.parseInt(number, sourceBase), dBase);
    }
	
	/**
	 * Represents the given number in base 10, base 16, base 8, and base 2, with 7-spaced left-justify spacing.
	 * @return a long formatted string
	 */
	public static String numberRepresentations(int num) {
		StringBuilder output = new StringBuilder();
		
		int sourceBase = 10;
		
        output.append(String.format("%-7s ", baseConversion(Integer.toString(num), sourceBase, 10)));
        output.append(String.format("%-7s ", baseConversion(Integer.toString(num), sourceBase, 16)));
        output.append(String.format("%-7s ", baseConversion(Integer.toString(num), sourceBase, 8)));
        output.append(String.format("%s", baseConversion(Integer.toString(num), sourceBase, 2)));
        
        return new String(output);
	}
	
	/**
	 * Identifies the given char as a number, a upper or lowercase letter, whitespace, or none of the above and prints what it is if it is any of those options.
	 * @return char charType
	 */
	public static String charProperties(char chargument) {
		String numbers = "0123456789";
		char whiteSpace = ' ';
		StringBuilder output = new StringBuilder();
		output.append(chargument);
		
		String charString = Character.toString(chargument);
		
		if (numbers.contains(charString)) {
			output.append(" number");
		}
		else if (letters.contains(charString)) {
			output.append(" lowercase letter");
		}
		else if (letters.toUpperCase().contains(charString)) {
			output.append(" uppercase letter");
		}
		else if (whiteSpace == chargument) {
			output.append(" white space");
		}
		
		return new String(output);
	}
	
	/**
	 * Parses the sum of the elements of a given array. The array must be null, empty, or consisting only of numbers (integers or doubles).
	 * @return the sum as a double
	 */
	public static double parseSum(String[] array) {
		if (array == null || array.length == 0) {
			return 0.0;
		}
		
		double sum = 0.0;
		
		for (String e : array) {
			if (e == null) {
				sum += 0;
			}
			else {
				double elemDouble = Double.parseDouble(e);
				sum += elemDouble;
			}
		}
		return sum;
	}
	
	/**
	 * Returns a random three digit number, from 100 to 999.
	 * @return the random three digit number
	 */
	public static int getRandomThreeDigitNumber() {
		int threeDigitNumber = rand.nextInt(100, 1000);
		return threeDigitNumber;
	}
	
	/**
	 * Returns a random lowercase or uppercase English letter.
	 * @return the random letter
	 */
	public static char getRandomLetter() {
		String upperLetters = letters.toUpperCase();
		String allLetters = letters + upperLetters;
		char[] allLettersArr = allLetters.toCharArray();
		
		// number of lowercase letters: 26, so number of letters either lowercase or uppercase: 52. Zero is also a valid index, so exclusive 52 is what we want.
		int randomLetter = rand.nextInt(52);
		
		return allLettersArr[randomLetter];
	}
	
	
	/**
	* Demonstrates the functionality provided in class DemoWrapperClass.
	*
	*/
	public static void main(String[] args) {
		Random rand = new Random();
	
		// Method minMax:
		System.out.println(minMax());
		System.out.println();
	
	
		// Method numberRepresentations:
		int[] numbers = { 9, 17, getRandomThreeDigitNumber(), 9876, 12345};
	
		System.out.printf("%-7s %-7s %-6s %s%n", "Base 10", "Base 16", "Base 8", "Base 2");
		System.out.printf("%-7s %-7s %-6s %s%n", "-------", "-------", "------", "------");
		for(int n : numbers) {
			System.out.println(numberRepresentations(n));
		}
		System.out.println();
	
		// Method charProperties:
		char[] characters = {'8', ' ', '#', 'a', 'M', getRandomLetter()};
	
		for(char c : characters) {
		System.out.println(charProperties(c));
		}
		System.out.println();
	
		// Method parse:
		String[] numberArray = {"1.1", "2.5", "3.14","40.04", "5.325", "63.5"};
	
		String[] wholeNumbers = new String[10];
		for(int i = 0; i < wholeNumbers.length; i++) {
		wholeNumbers[i] = "" + (rand.nextInt(90) + 10);
		}
	
		System.out.println(Arrays.deepToString(numberArray)
		+ " .. sum = " + parseSum(numberArray));
	
	}
}
