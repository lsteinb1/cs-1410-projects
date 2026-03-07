package quiz_exercises;

public class QuizExercises {
	private static String printReverse (String str)
	{
		char[] reverseChars = new char[str.length()];
		
		for (int i = str.length() - 1; i >= 0; i--)
		{
			// reverseChars[i] = str.charAt(i);
			System.out.print(str.charAt(i));
		}
		
		String reverse = new String(reverseChars);
		return reverse;
	}
	
	public static void main(String[] args)
	{
		String testWord = "reversed";
		String reversed = printReverse(testWord);
		
		System.out.println(reversed);
	}
}
