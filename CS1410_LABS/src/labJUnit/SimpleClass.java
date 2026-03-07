package labJUnit;

/**
 * Simple class to demonstrate automated testing with JUnit Jupiter (JUnit 5).
 *
 * @author Lydia
 */
public class SimpleClass {

   /**
    * Determines whether a given year is a leap year.
    *
    * @param year the year to evaluate
    * @return true if year is a leap year and false otherwise.
    * @throws IllegalArgumentException if year is not positive. 
    */
    public static boolean isLeapYear(int year) {
    	if(year < 0)
			throw new IllegalArgumentException("The year can't be negative.");
    	else if(year == 0)
			throw new IllegalArgumentException("The year can't be zero.");
    	
       return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0 && year % 4 == 0);
    }
}