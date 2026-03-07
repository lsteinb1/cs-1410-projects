package codingBatExercises;

import java.util.ArrayList;

public class String2Exercises {

	public static void main(String[] args) {
		// System.out.println(plusOut("12xy34", "xy"));
		System.out.println(plusOut("aaxxxxbb", "xx"));
		
		// System.out.println("OneTwo: " + oneTwo("1234567890"));
		
		// System.out.println(xyzMiddle("AAAxyzBB")); // should be false
		// System.out.println(xyzMiddle("xyzAxyzBBB")); // should be true
		// System.out.println(xyzMiddle("xyzxyzxyzBxyzxyz")); // should be true
	}
	
	public static String plusOut(String str, String word) {
		if (str.contains(word)){
			// String[] strArray = str.split("(?=" + word + ")");
			// String[] strArray = str.split("");
			ArrayList<Integer> protectedIndexes = new ArrayList<Integer>();
			int i = 0;
			while (str.indexOf(word, i) != -1) {
				for (int j = 0; j < word.length(); j++) {
					protectedIndexes.add(str.indexOf(word, i) + j); // adds for each char in word. This outputs a mess but hey, it works. I'd fix it if I had time
				}
				//i += str.indexOf(word, i);
				i++;
			}
			System.out.println(protectedIndexes);
			StringBuilder sb = new StringBuilder(); 
			for (i = 0; i < str.length(); i++){ // resets i for reuse
				System.out.println(i + " " + word);
				if (protectedIndexes.contains(i)){
					sb.append(str.charAt(i));
				}
				else{
					sb.append("+");
				}
			}
			return new String(sb);
		}
		else {
			return str;
		}
	}
	
	public static String oneTwo(String str) {
		if (str.length() > 3){ // (str.length() % 3 == 0)
	    	StringBuilder tempSb = new StringBuilder(str);
	    	StringBuilder returnValue = new StringBuilder();
	      /*
	      for (int i = 0; i + 3 <= str.length(); i += 2){
	    	  System.out.println(str.substring(i, i + 3));
	        returnValue.append(oneTwo(str.substring(i, i + 3)));
	      }*/
	      
	      
	      for (int i = 0; i + 3 <= str.length(); i += 3){
	    	  char toMove = str.charAt(i);
	    	  // System.out.println(tempSb);
	    	  tempSb.deleteCharAt(i);
	    	  // System.out.println(tempSb);
	    	  tempSb.insert(i + 2, toMove);
	    	  // System.out.printf("i substring: %s, tempSb: %s %n", str.substring(i, i + 3), tempSb);
	    	  while (tempSb.length() % 3 != 0){ // while not evenly divisible by 3
	  	        tempSb.deleteCharAt(tempSb.length() - 1);
	  	      }
	        returnValue = tempSb;
	      }
	      return new String(returnValue); // hocolctea or 231564897
	    }
		else if (str.length() == 3){
			StringBuilder sb = new StringBuilder(str);
		    char toMove = sb.charAt(0);
		    sb.deleteCharAt(0);
		    sb.insert(2, toMove);
		    return new String(sb);
		  }
		else{
				return "";
		    }
	}
	
	
	/* rethinking:
	* -most useful if I have a marginOfError int that can be changed (in this case it's 1)
	* check index of y is within 3 indexes of half of the width, to find center xyz?
	* then test numbers of chars on each side of that with marginOfError
	*/

	public static boolean xyzMiddle(String str) {
	  int marginOfError = 1;
	  if (str.contains("xyz")){
	    if (str.length() > 3){
	      // find instance of "xyz" nearest the center
	      /* int centerIndex = str.length() / 2;
	      if (str.charAt(centerIndex) == 'y' || str.charAt(centerIndex + 1) == 'y' || str.charAt(centerIndex - 1) == 'y'){
	        /* StringBuilder xyzLocations = new StringBuilder(); // using indexOf solution. A StringBuilder (for editing purposes) of the indexes where xyz is present
	        for (int i = 0; str.indexOf("xyz", i) != -1; i++){
	          xyzLocations.append(str.indexOf("xyz", i));
	        }*/
	        
	        /*
	        StringBuilder xyzLocations = new StringBuilder(); // using indexOf solution
	        for (int i = 0; str.indexOf("xyz", i) != -1; i++){
	          xyzLocations.append(str.indexOf("xyz", i));
	        }*/
	        /* if (strArray.length > 2){ // if ((str.indexOf("xyz") != 0) || (str.indexOf("xyz") != str.length())){
	          if (Math.abs(strArray[0].length() - strArray[2].length()) <= 1){
	            return true;
	          }
	          else{
	            return false;
	          }
	        }
	      }*/
	    	int firstXyz = str.indexOf("xyz");
	       int lastXyz = str.lastIndexOf("xyz");
	       // find instance of "xyz" nearest the center
	       // int[] firstXyzIndexes = {firstXyz, (firstXyz + 1), (firstXyz + 2)}; // the indexes of the first xyz
	       int[] lastXyzIndexes = {lastXyz, (lastXyz + 1), (lastXyz + 2)};
	       if (firstXyz == lastXyz) { // one xyz case
		        int otherFirstChars = str.substring(0, firstXyz + 1).length() - 1; // correcting for exclusive end
		        int otherLastChars = str.substring(lastXyzIndexes[2], str.length()).length() - 1;
		        //System.out.printf("Last xyz: %d, FirstChars: %d, LastChars: %d%n", lastXyz, otherFirstChars, otherLastChars);
		        if (Math.abs(otherFirstChars - otherLastChars) <= marginOfError) {
		        	return true;
		        }
	        }
	        else { // multiple xyz case. All the numbers are important even though I don't always fully know why
	        	int centerIndex = (str.length() / 2);
	        	int middleXyz = str.indexOf("xyz", centerIndex - 2);
	        	int[] middleXyzIndexes = {middleXyz, (middleXyz + 1), (middleXyz + 2)};
	        	// System.out.printf("%d, %d%n", centerIndex, middleXyz);
		        int otherFirstChars = str.substring(0, middleXyzIndexes[0]).length(); // correcting for exclusive end
		        int otherLastChars = str.substring(middleXyzIndexes[2] + 1, str.length()).length();
		        // System.out.printf("Last xyz: %d, FirstChars: %d, LastChars: %d%n", lastXyz, otherFirstChars, otherLastChars);
		        if (Math.abs(otherFirstChars - otherLastChars) <= marginOfError) {
		        	return true;
		        }
	        }
	    } else{ // just "xyz" case
	      return true;
	    }
	  }
	  else{ // no xyz
	    return false;
	  }
	  return false; // wouldn't run without this?
	}
}
