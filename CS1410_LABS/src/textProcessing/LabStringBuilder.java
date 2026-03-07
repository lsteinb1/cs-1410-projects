package textProcessing;

public class LabStringBuilder {
	
	public static void main (String[] args) {
		StringBuilder sb = new StringBuilder("Bats live");
		
		sb.replace(0, 1, "r"); // coulda used setCharAt()
		sb.append(" on ");
		System.out.println("sb: " + sb); // added "sb:" + retroactively
		
		// sb.replace(0, 1, "B"); // I misinterpreted 'original content' here
		// sb.delete(9, 13);
		
		StringBuilder bs = new StringBuilder(sb);
		sb.append(bs.reverse());
		System.out.println("sb: " + sb); // it's good practice to introduce what variable you're printing. implementing this retroactively now
		
		int doubleSpace = sb.indexOf("  ");
		sb.replace(doubleSpace, doubleSpace + 2, " "); // could also do delete(); or better, as in example, deleteCharAt()
		sb.replace(0, 1, "C").replace(sb.length(), sb.length() + 1, "."); // why didn't I just append for the period? Also, should've used setCharAt for the C
		System.out.println("sb: " + sb);
		
		sb.insert(0, '.');
		String lowercase = sb.toString().toLowerCase(); // better method: sb = new StringBuilder(sb.toString().toLowerCase());
		sb.replace(0, sb.length(), lowercase);
		
		for (int i = 0; i < sb.lastIndexOf(" "); i++) {
			int fromIndex = sb.indexOf(" ", i);
			sb.replace(fromIndex, fromIndex + 1, "");
		}
		
		bs.replace(0, bs.length(), sb.toString()); // using reversed version of sb, StringBuilder bs, from earlier
		bs.reverse();
		
		boolean isPalindrome = false; // one line version from example: boolean isPalindrome = sb.toString().equals(reversed.toString());
		if (sb == bs) {
			isPalindrome = true;
		}
		
		System.out.println("sb: " + sb + " sb is a palindrome: " + isPalindrome);
		
	}
}