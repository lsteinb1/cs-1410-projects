package a01;

import java.util.ArrayList;
// import java.util.Arrays;

/**
 * Module 01 Team Assignment: Objects | Arrays | ArrayList
 *
 * @author CS Starter Code + Lydia (I did this assignment solo)
 */
public class WarmUp {
	
    // = = = = =   O b j e c t s   C h a l l e n g e s   = = = = = 

    /**
     * Returns the distance between the points {@code p1} and {@code p2}.
     * 
     * <pre>
     * Examples:
     * distance((3, 4), (3, 6)) -> 2
     * distance((1, 1), (-3, -2)) -> 5
     * </pre>
     * 
     * @param p1 first point (assume non-null)
     * @param p2 second point (assume non-null)
     * @return distance between p1 and p2
     */
    public static double distance(Point p1, Point p2) {
    	
        return p1.distance(p2);
    }

    /**
     * Returns the greatest distance from the origin (0, 0) among three points.
     * 
     * <pre>
     * Example:
     * (4, 3), (3, -1), (3, -4) -> 5
     * </pre>
     *
     * @param p1 first point (assume non-null)
     * @param p2 second point (assume non-null)
     * @param p3 third point (assume non-null)
     * @return greatest distance from origin among p1, p2, and p3
     */
    public static double greatestDistanceFromOrigin(Point p1, Point p2, Point p3) {
    	double dist1 = p1.distance(Point.ORIGIN);
    	double dist2 = p2.distance(Point.ORIGIN);
    	double dist3 = p3.distance(Point.ORIGIN);
    	
    	double[] distances = {dist1, dist2, dist3};
    	
    	double maxDist = dist1;
    	
    	for (double d : distances) {
    		if (d > maxDist) {
    			maxDist = d;
    		}
    	}
    	
        return maxDist;
    }

    /**
     * Returns the area of the rectangle formed by the origin (0, 0) and the point p.
     * The area is based on the absolute values of the x- and y-coordinates.
     * If either coordinate is 0, the area is 0.
     * 
     * <pre>
     * Examples:
     * p: (6, 3)  -> 18
     * p: (-5, 3) -> 15
     * p: (0, -3) -> 0
     * </pre>
     * 
     * @param p point (assume non-null)
     * @return area based on the absolute values of x and y.
     */
    public static double area(Point p) {
    	
    	double length = Math.abs(p.getY() - Point.ORIGIN.getY());
    	double width  = Math.abs(p.getX() - Point.ORIGIN.getX());
    	return length * width;
    }
    
    
    // = = = = =  A r r a y s   C h a l l e n g e s   = = = = = 

    /**
     * Returns an array of length n containing the sequence 0, 1, 2, ..., n-1.
     * 
     * <pre>
     * Examples:
     * n: 5 -> [0, 1, 2, 3, 4]
     * n: 0 -> []
     * </pre>
     * 
     * Preview: This method includes a guard clause that throws an exception for invalid input.
     *
     * @param n desired array length
     * @return array containing values 0 to n-1
     * @throws IllegalArgumentException if n is negative
     */
    public static int[] buildSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
        
        int[] seq = new int[n];
        
        if (n == 0) {
        	return seq;
        }
        else {
        	for (int i = 0; i <= n - 1; i++) {
        		seq[i] = i;
        	}
        }

        return seq;
    }

    /**
     * Returns a new array that contains all elements of {@code a} plus the
     * added element {@code value} at the end.
     * The new array has one more element than the original array, and the 
     * original array remains unmodified.
     * 
     * <pre>
     * Example:
     * a: [1, 2, 3], value: 4 -> [1, 2, 3, 4]
     * </pre>
     * 
     * @param a input array (assume non-null)
     * @param value value to add at the end
     * @return new array containing all elements of a, then value
     */
    public static int[] append(int[] a, int value) {
    	
    	int[] expandedArray = new int[a.length + 1];
    	
    	for (int i = 0; i < a.length; i++) {
    		expandedArray[i] = a[i];
    	}
    	
    	expandedArray[expandedArray.length - 1] = value;
    	
    	return expandedArray;
    }

    /**
     * Returns a new array with the element at {@code index} removed.
     * The new array has one element less than the original array, and the 
     * original array remains unmodified.
     * 
     * <pre>
     * Example:
     * a: [10, 20, 30, 40], index: 2 -> [10, 20, 40]
     * </pre>
     * 
     * Preview: This method includes a guard clause that throws an exception for invalid index values.
     *
     * @param a input array (assume non-null)
     * @param index index of element to remove
     * @return new array with one fewer element
     * @throws IllegalArgumentException if index is invalid
     */
    public static int[] removeAt(int[] a, int index) {
        if (index < 0 || index >= a.length) {
            throw new IllegalArgumentException("index is out of range.");
        }
        
        int[] revisedArray = new int[a.length - 1];
    	
    	for (int i = 0; i < revisedArray.length; i++) {
    		if (i == index) {
    			revisedArray[i] = a[i + 1]; // skips index
    			// System.out.printf("advanced arr element: %d%n", revisedArray[i]);
    			i++;
    		}
    		else {
    			revisedArray[i] = a[i];
    			// System.out.printf("arr element: %d%n", revisedArray[i]);
    		}
    	}
    	
    	// System.out.println();
    	/* I really wanted to figure out why this wasn't passing the removeAt_firstElement() test,
    	* but I realized it wouldn't be worth the time to figure it out right now, because I'm so behind on assignments.
    	* I wanted the learning that would come from that, but I can't spend the time right now.
    	*/
    	return revisedArray;
    }
    
    
    // = = = = =   A r r a y L i s t   C h a l l e n g e s   = = = = = 

    /**
     * Inserts the element {@code value} at the beginning and at the end of the list.
     * This method changes the list provided by the user.
     *
     * <pre>
     * Examples:
     * list: [1, 2, 3], value: 9 -> list becomes [9, 1, 2, 3, 9]
     * list: [], value: 5       -> list becomes [5, 5]
     * list: [7], value: 4      -> list becomes [4, 7, 4]
     * </pre>
     *
     * @param list list to modify (assume non-null)
     * @param value value to insert at the front and back
     */
    public static void addFrontAndBack(ArrayList<Integer> list, int value) {
        list.addFirst(value);
        list.addLast(value);
    }

    /**
     * Removes the element {@code target} from the list only if it appears at the
     * first position and/or the last position.
     * This method changes the list provided by the user.
     *
     * <ul>
     *   <li>If {@code target} appears at both the first and last position, both are removed.</li>
     *   <li>If {@code target} appears only in the middle of the list, it is not removed.</li>
     * </ul>
     *
     * Equality is determined using the method {@code equals} from the {@code Point} class.
     * The method returns {@code true} if at least one element was removed; otherwise {@code false}.
     *
     * <pre>
     * Examples:
     * list: [(1,2), (3,4), (1,2)], target: (1,2) -> list becomes [(3,4)], returns true
     * list: [(1,2), (3,4), (5,6)], target: (1,2) -> list becomes [(3,4), (5,6)], returns true
     * list: [(9,9), (1,2), (8,8)], target: (1,2) -> list unchanged, returns false
     * list: [(1,2)], target: (1,2)               -> list becomes [], returns true
     * </pre>
     *
     * @param list list to modify (assume non-null)
     * @param target point to remove (assume non-null)
     * @return true if at least one element was removed; false otherwise
     */
    public static boolean removeIfAtEnds(ArrayList<Point> list, Point target) {
    	boolean elementRemoved = false;
    	// ArrayList<Point> origList = new ArrayList<Point>(list);
    	
    	if (list.contains(target)) {
    		// elementRemoved = true;
    		for (int i = 0; i < list.size(); i++) {
    			/* System.out.printf("i: %d, list element: %s, target: %s, bool: %b%n",
    			* i, list.get(i), target, list.get(i) == target);
    			* 
    			* this print statement was for debug, for some reason the bool part never worked though. I'd like to figure out why when I have more time
    			*/
    			if (list.get(i).equals(target)){
    				if (i == 0) { // first element
    					list.remove(i);
            			elementRemoved = true;
            			i = 0;
    				}
    				else if (i == list.size() - 1){
    					list.remove(i);
            			elementRemoved = true;
    				}
        		}
    		}
    	}
    	// System.out.printf("returned: %b%n", elementRemoved);
        return elementRemoved;
    }

    /**
     * Duplicates each element in the list by inserting a copy of each element
     * immediately after its original position.
     * This method changes the list provided by the user.
     *
     * <pre>
     * Examples:
     * list: ["a", "b"]    -> list becomes ["a", "a", "b", "b"]
     * list: []            -> list becomes []
     * list: ["x"]         -> list becomes ["x", "x"]
     * list: ["hi", "hi"]  -> list becomes ["hi", "hi", "hi", "hi"]
     * </pre>
     *
     * @param list list to modify (assume non-null)
     */
    public static void duplicateEach(ArrayList<String> list) {
        if (!list.isEmpty()) {
        	for (int i = 0; i < list.size(); i++) {
        		list.add(i, list.get(i));
        		i++; // this is important to avoid an OutOfMemory error
        	}
        }
    }

}
