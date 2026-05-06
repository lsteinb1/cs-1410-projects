package labFileInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in data records from the csv file and prints the lakes.
 * 
 * @author Lydia
 *
 */
public class LakeApp {
	public static void main(String[] args) {
		List<Lake> lakes = new ArrayList<>();
		try(Scanner input = new Scanner(LakeApp.class.getResourceAsStream("Lakes.csv"))){
			while(input.hasNextLine()) {
				Lake currentLake = getLake(input.nextLine());
				if(currentLake != null) {
					lakes.add(currentLake);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Huh, that's unexpected. How did you get an " + e + "?");
		}
		lakes.forEach(lake -> System.out.println(lake));
	}

	/**
	* Creates a Lake object based on the data record passed as an argument.
	* The data record is expected to be of the following format: <br/>
	* {name of the lake},{depth},{has marina}<br/>
	* <p>
	* If the argument <code>line</code> doesn't match the expected format 
	* and the instance of Lake cannot be created, then the string "Error: " 
	* followed by the line should be printed to the standard error stream 
	* (<code>System.err</code>) and the method should return null.
	* 
	* @param line a line from a csv file that includes data about a lake
	* @return Lake object corresponding to the argument <code>line</code> 
	* or null if <code>line</code> didn't match the expected format.
	*/
	private static Lake getLake(String line) {
		try{
			String[] lineParts = line.split(",");
			String name = lineParts[0];
			int depth = Integer.parseInt(lineParts[1]);
			boolean hasMarina = Boolean.parseBoolean(lineParts[2]);
			
			return new Lake(name, depth, hasMarina); // can all be initialized on this line
		}
		catch(Exception e){ // more info on options: https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html
			System.err.println("Error: " + line);
			return null;
		}
		
	}
}
