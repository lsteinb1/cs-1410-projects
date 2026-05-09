package Apr15;

import java.util.*;

public class Timed {

    // Function 1: Palindrome check
    public static Boolean isPalindrome(int x) {
        StringBuilder xStringBuilder = new StringBuilder(String.valueOf(x));
        String xStringOrig = new String(xStringBuilder);
        //xString.
        // ran out of time on line 9 with just xString.
        
        return null;
    }

    public static void main(String[] args) {

        // Test Cases for isPalindrome
        System.out.println("Palindrome 121: " + isPalindrome(121) + " -- Expected: True");
        System.out.println("Palindrome -121: " + isPalindrome(-121) + " -- Expected: False");
        System.out.println();


        // Uncomment to test merge_sorted_lists
        /*
        List<Integer> list1 = Arrays.asList(1,2,4);
        List<Integer> list2 = Arrays.asList(1,3,4);
        System.out.println(list1 + " and " + list2 + " = [1,1,2,3,4,4] got " + mergeSortedLists(list1, list2));

        List<Integer> list3 = Arrays.asList(0);
        List<Integer> list4 = new ArrayList<>();
        System.out.println(list3 + " and " + list4 + " = [0] got " + mergeSortedLists(list3, list4));

        List<Integer> list5 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();
        System.out.println(list5 + " and " + list6 + " = [] got " + mergeSortedLists(list5, list6));
        */


        // Uncomment to test Pascal's Triangle
        /*
        int rows = 5;
        List<List<Integer>> myTriangle = generatePascalsTriangle(rows);
        System.out.println(myTriangle);
        printTriangle(myTriangle);
        */
    }


    // Function 2: Merge Sorted Lists
    public static List<Integer> mergeSortedLists(List<Integer> listA, List<Integer> listB) {
        return new ArrayList<>();
    }


    // Function 3: Generate Pascal's Triangle
    public static List<List<Integer>> generatePascalsTriangle(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        return triangle;
    }


    // Function 4: Print Pascal's Triangle
    public static void printTriangle(List<List<Integer>> triangle) {
        // Your solution here
    }
}
