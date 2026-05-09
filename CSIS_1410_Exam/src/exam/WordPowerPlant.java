package exam;

/**
 * A WordPowerPlant can generate electricity (the word), transform words, and countLetters with particular specifications on what counts as one letter.
 * 
 * @author Lydia
 */
public class WordPowerPlant {
	private int capacity;
	
	/**
	 * Initializes WordPowerPlant instance.
	 * @param capacity for power, in MW
	 */
	public WordPowerPlant(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Generates electricity.
	 */
	public String generatesElectricity() {
		return "generating electricity";
	}
	
	/**
	 * Transforms the given word in the following order:
	 * converts it to lowercase, removes the underscores,
	 * changes the case of its first or last letter if the first is a or the last is z,
	 * appends the word but reversed to the end of the word.
	 * If null or an empty string are passed in, they will be returned as-is.
	 * @param word
	 * @return transformed word
	 */
	public String transform(String word) {
		if (word == null) {
			return null;
		}
		else if (word.isEmpty()) {
			return "";
		}
		else {
			word = word.toLowerCase(); // easiest to do this as well as the StringBuilder for the startswith/endswith if statements, because StringBuilder doesn't have those methods
			StringBuilder sb = new StringBuilder(word.replace("_", "")); // starts with word without underscores
			if (word.startsWith("a")) {
				sb.replace(0, 1, "A"); // if the first letter wasn't guaranteed to be a, I'd need to get the first letter of the word, convert it to uppercase, and pass that in instead of "A"
			}
			else if (word.endsWith("z")) {
				sb.replace(sb.length() - 1, sb.length(), "Z");
			}
			StringBuilder reversed = new StringBuilder(sb.reverse()); // sb.reverse() will reverse sb as well
			sb.reverse(); // this will reverse it again, setting it back to its normal order
			sb.append(reversed);
			return new String(sb);
		}
	}
	
	/**
	 * Counts the letters in the given word, except that ae, oe, ue, or eu are all counted as one letter each.
	 * @throws IllegalArgumentException if the word is null.
	 * @param word to count the letters of
	 * @return count of letters
	 */
	public int countLetters(String word) {
		if (word == null) {
			throw new IllegalArgumentException("The word for letter counting cannot be null.");
		}
		else{
			int count = 0;
			word = word.toLowerCase(); // for ease of testing
			boolean combination = false;
			
			for (int i = 0; i < word.length(); i++) {
				// if the current combination of letters is any of the combinations to count as one letter
				// there are better ways of coding this if I had more time and wanted the code to be easier to expand/less hardcoded
				if (i + 1 < word.length()) {
					if (word.charAt(i) == 'a' && word.charAt(i + 1) == 'e') {
						combination = true;
						count += 1;
						i++; // skips next letter
					}
					else if (word.charAt(i) == 'o' && word.charAt(i + 1) == 'e') {
						combination = true;
						count += 1;
						i++; // skips next letter
					}
					else if (word.charAt(i) == 'u' && word.charAt(i + 1) == 'e') {
						combination = true;
						count += 1;
						i++; // skips next letter
					}
					else if (word.charAt(i) == 'e' && word.charAt(i + 1) == 'u') {
						combination = true;
						count += 1;
						i++; // skips next letter
					}
				}
				if (!combination) { // usual case, not dependent on i + 1
					count++;
				}
				combination = false;
			}
			
			return count;
		}
	}

	/**
	 * Returns a string in the following format: ClassName capacityMW
	 */
	@Override
	public final String toString() {
		return this.getClass().getSimpleName() + " " + capacity + "MW";
	}
}
