package recursion;

public class Recursion {
	
	/**
	 * "This method returns the sum of all the digits. Notice that the minus sign is ignored."
	 * @param n
	 * @return
	 */
	public static int sumOfDigits(int n)
	{
		String nString = Integer.toString(n);
		StringBuilder nStringBldr = new StringBuilder(nString);
		if (nString.contains("-")) { // remove negative symbol (assumes it's always the first character)
			nString = new String(nStringBldr.deleteCharAt(0));
		}
		
		String[] nStarray = nString.split("");
		
		if (nString.length() == 1)
		{
			return Integer.parseInt(nString); // a possible base case
		}
		else
		{
			int initSum = Integer.parseInt(nStarray[0]) + Integer.parseInt(nStarray[1]); // initial sum of first two digits
			nStringBldr.delete(0, 2); // removes digits that have already been added together
			nString = new String(nStringBldr);
			if (!nStringBldr.isEmpty()) {
				int sum = initSum + sumOfDigits(Integer.parseInt(nString));
				return sum;
			}
			else {
				return initSum;
			}
		}
	}
	
	/**
	 * "This method separates all characters by a space and changes all lowercase letters to uppercase letters."
	 * @param str
	 * @return
	 */
	public static String toUpper(String str, int i)
	{
		// adapted from my code for the allStar CodingBat exercise
		// split or use StringBuilder
		str = str.toUpperCase();
		StringBuilder sb = new StringBuilder(str);
		
		// this is much easier to do in a for loop (and works better)
		/*
		for (int j = 1; j < sb.length(); j++) {
			sb.insert(j, " ");
			j++;
		}
		
		if (new String(sb).contains("   ")){
			int threeSpaces = sb.indexOf("   ");
			sb.replace(threeSpaces, threeSpaces + 3, "  ");
		}
		
		return new String(sb);*/
		
		
		if (i == 0) {
			if (str.contains(" ")){
				sb.replace(str.indexOf(" "), str.indexOf(" ") + 1, "  ");
				i = 1;
			}
			else {
				i = 1;
			}
		}
		if (i < str.length()) {
			if (str.contains(" ")){
				if (str.indexOf(" ") != 1) {
					sb.insert(1, " ");
					return toUpper(new String(sb), i++);
				}
				else if (str.lastIndexOf(" ") == str.length() - 1){ // if last space is at index length - 1, return string
					// System.out.println("returning str: " + str);
					return str;
				}
				else{ // insert a space at lastIndexOf + 2
					sb.insert(str.lastIndexOf(" ") + 2, " ");
					// System.out.println("str: " + str);
					return toUpper(new String(sb), i++);
				}
			}
			else{
				// System.out.println("returning str: " + str);
				sb.insert(1, " ");
				return toUpper(new String(sb), i++);
			}
		}
		else {
			return new String(sb);
		}
		
		/*String[] strArr = str.split(" ");
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(str.split(" ")));
	  
		// if strArr.length() is 1, add a space between each character
		if (strArr.length == 1) {
			if (str.contains(" ")){
				if (str.lastIndexOf(" ") == strArr.length - 1){ // if last space is at index length - 1, return string
					System.out.println("returning str: " + str);
					return str;
				}
				else{ // if a space already in string: insert a space at lastIndexOf + 2
					sb.insert(str.lastIndexOf(" ") + 2, " ");
					System.out.println("str: " + str);
					return toUpper(new String(sb));
				}
			}
			else if(str.length() <= 1){
				System.out.println("returning str: " + str);
				return str;
			}
			else{ // else, insert a space at index 1
				sb.insert(1, " ");
				return toUpper(new String(sb));
			}
		}
		// if strArr.length() is more than 1, add a space/two spaces between each entry, then start adding spaces between each character in each element
		else if(strArr.length > 1){
			// strList.add(1, "  "); // maybe this should happen at the end somehow? hmm
			System.out.println("strList: " + strList);
			return toUpper(strList.get(0)) + "  " + toUpper(strList.get(1));
		}
		else{
			return null;
		}*/
	}
	
	public static double harmonic (int n) {
		   if (n == 0)
		      throw new IllegalArgumentException("The argument n can't be zero.");

		   if (n == 1)
		      return 1;
		   else if (n < 0)
		      return -1 * harmonic(-n);
		   else // n > 1
		      return 1.0/n + harmonic (n - 1);
	}
	
	public static void main(String[] args)
	{
		System.out.println("Sum of digits: " + sumOfDigits(-118));
		System.out.println(toUpper("hi there", 0));
	}
}
