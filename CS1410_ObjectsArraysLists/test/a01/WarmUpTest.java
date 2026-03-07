// WarmUpTest.java (comprehensive JUnit 5 test suite)
// One test method per test case, designed to catch common mistakes.

package a01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//= = = = = = =   D O  N O T   M O D I F Y   = = = = = = =

/**
* Tests for class WarmUp
* 
* @author CS Starter Code
*/
public class WarmUpTest {

    private static final double DELTA = 1e-9;

    //  = = = = =   Objects: distance  = = = = =  

    @Test
    void distance_typical_verticalLine() {
        assertEquals(2.0, WarmUp.distance(new Point(3, 4), new Point(3, 6)), DELTA);
    }

    @Test
    void distance_typical_withNegatives() {
        assertEquals(5.0, WarmUp.distance(new Point(1, 1), new Point(-3, -2)), DELTA);
    }

    @Test
    void distance_samePoint_isZero() {
        assertEquals(0.0, WarmUp.distance(new Point(7, -9), new Point(7, -9)), DELTA);
    }

    //  = = = = =   Objects: greatestDistanceFromOrigin  = = = = =  

    @Test
    void greatestDistanceFromOrigin_typical() {
        // (4,3)..5, (3,-1)..sqrt(10), (3,-4)..5
        assertEquals(5.0, WarmUp.greatestDistanceFromOrigin(
                new Point(4, 3), new Point(3, -1), new Point(3, -4)
        ), DELTA);
    }

    @Test
    void greatestDistanceFromOrigin_tie_returnsThatDistance() {
        assertEquals(5.0, WarmUp.greatestDistanceFromOrigin(
                new Point(4, 3), new Point(0, 0), new Point(3, -4)
        ), DELTA);
    }

    @Test
    void greatestDistanceFromOrigin_allSameDistance() {
        assertEquals(1.0, WarmUp.greatestDistanceFromOrigin(
                new Point(1, 0), new Point(-1, 0), new Point(0, -1)
        ), DELTA);
    }

    //  = = = = =   Objects: area  = = = = =  

    @Test
    void area_typical_positiveCoordinates() {
        assertEquals(18.0, WarmUp.area(new Point(6, 3)), DELTA);
    }

    @Test
    void area_usesAbsoluteValues_negativeX() {
        assertEquals(15.0, WarmUp.area(new Point(-5, 3)), DELTA);
    }

    @Test
    void area_usesAbsoluteValues_negativeY() {
        assertEquals(15.0, WarmUp.area(new Point(5, -3)), DELTA);
    }

    @Test
    void area_usesAbsoluteValues_bothNegative() {
        assertEquals(15.0, WarmUp.area(new Point(-5, -3)), DELTA);
    }

    @Test
    void area_pointOnAxis_returnsZero_xIsZero() {
        assertEquals(0.0, WarmUp.area(new Point(0, -3)), DELTA);
    }

    @Test
    void area_pointOnAxis_returnsZero_yIsZero() {
        assertEquals(0.0, WarmUp.area(new Point(7, 0)), DELTA);
    }

    
    //  = = = = =   Arrays: buildSequence  = = = = =  

    @Test
    void buildSequence_typical_nFive() {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, WarmUp.buildSequence(5));
    }

    @Test
    void buildSequence_empty_nZero() {
        assertArrayEquals(new int[]{}, WarmUp.buildSequence(0));
    }

    @Test
    void buildSequence_singleElement_nOne() {
        assertArrayEquals(new int[]{0}, WarmUp.buildSequence(1));
    }

    @Test
    void buildSequence_negative_throws() {
        assertThrows(IllegalArgumentException.class, () -> WarmUp.buildSequence(-1));
    }

    //  = = = = =   Arrays: append  = = = = =  

    @Test
    void append_typical() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, WarmUp.append(new int[]{1, 2, 3}, 4));
    }

    @Test
    void append_emptyArray() {
        assertArrayEquals(new int[]{99}, WarmUp.append(new int[]{}, 99));
    }

    @Test
    void append_singleElement() {
        assertArrayEquals(new int[]{7, -1}, WarmUp.append(new int[]{7}, -1));
    }

    @Test
    void append_doesNotModifyOriginal() {
        int[] original = {1, 2, 3};
        int[] before = original.clone();

        WarmUp.append(original, 4);

        assertArrayEquals(before, original);
    }

    @Test
    void append_returnsNewArrayReference() {
        int[] original = {1, 2, 3};
        int[] result = WarmUp.append(original, 4);

        assertNotSame(original, result);
    }

    //  = = = = =   Arrays: removeAt  = = = = =  

    @Test
    void removeAt_typical_middle() {
        assertArrayEquals(new int[]{10, 20, 40}, WarmUp.removeAt(new int[]{10, 20, 30, 40}, 2));
    }

    @Test
    void removeAt_firstElement() {
        assertArrayEquals(new int[]{20, 30, 40}, WarmUp.removeAt(new int[]{10, 20, 30, 40}, 0));
    }

    @Test
    void removeAt_lastElement() {
        assertArrayEquals(new int[]{10, 20, 30}, WarmUp.removeAt(new int[]{10, 20, 30, 40}, 3));
    }

    @Test
    void removeAt_singleElement_becomesEmpty() {
        assertArrayEquals(new int[]{}, WarmUp.removeAt(new int[]{7}, 0));
    }

    @Test
    void removeAt_invalidIndex_negative_throws() {
        assertThrows(IllegalArgumentException.class, () -> WarmUp.removeAt(new int[]{10, 20}, -1));
    }

    @Test
    void removeAt_invalidIndex_tooLarge_throws() {
        assertThrows(IllegalArgumentException.class, () -> WarmUp.removeAt(new int[]{10, 20}, 2));
    }

    @Test
    void removeAt_doesNotModifyOriginal() {
        int[] original = {10, 20, 30, 40};
        int[] before = original.clone();

        WarmUp.removeAt(original, 2);
        assertArrayEquals(before, original);
    }

    @Test
    void removeAt_returnsNewArrayReference() {
        int[] original = {10, 20, 30, 40};
        int[] result = WarmUp.removeAt(original, 2);

        assertNotSame(original, result);
    }

    
    // = = = = = = ArrayList: addFrontAndBack  = = = = = =

    @Test
    void addFrontAndBack_typical() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        WarmUp.addFrontAndBack(list, 9);
        assertEquals(Arrays.asList(9, 1, 2, 3, 9), list);
    }

    @Test
    void addFrontAndBack_emptyList_resultsInTwoElements() {
        ArrayList<Integer> list = new ArrayList<>();
        WarmUp.addFrontAndBack(list, 5);
        assertEquals(Arrays.asList(5, 5), list);
    }

    @Test
    void addFrontAndBack_singleElement() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7));
        WarmUp.addFrontAndBack(list, 4);
        assertEquals(Arrays.asList(4, 7, 4), list);
    }

    @Test
    void addFrontAndBack_negativeValueAllowed() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5));
        WarmUp.addFrontAndBack(list, -2);
        assertEquals(Arrays.asList(-2, 5, -2), list);
    }

    @Test
    void addFrontAndBack_doesNotLoseAnyOriginalElements() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        WarmUp.addFrontAndBack(list, 99);
        assertEquals(Arrays.asList(99, 10, 20, 30, 40, 99), list);
    }


    // = = = = = =   ArrayList: removeIfAtEnds   = = = = = =

    @Test
    void removeIfAtEnds_targetAtBothEnds_removesBoth_returnsTrue() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(1, 2));
        list.add(new Point(3, 4));
        list.add(new Point(1, 2)); // target at both ends

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(1, 2)); // different instance, equal coords

        assertTrue(removed);
        assertEquals(Arrays.asList(new Point(3, 4)), list);
    }

    @Test
    void removeIfAtEnds_targetAtFirstOnly_removesFirst_returnsTrue() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(1, 2)); // target at first
        list.add(new Point(3, 4));
        list.add(new Point(5, 6));

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(1, 2));

        assertTrue(removed);
        assertEquals(Arrays.asList(new Point(3, 4), new Point(5, 6)), list);
    }

    @Test
    void removeIfAtEnds_targetAtLastOnly_removesLast_returnsTrue() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(9, 9));
        list.add(new Point(3, 4));
        list.add(new Point(1, 2)); // target at last

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(1, 2));

        assertTrue(removed);
        assertEquals(Arrays.asList(new Point(9, 9), new Point(3, 4)), list);
    }

    @Test
    void removeIfAtEnds_targetOnlyInMiddle_doesNotRemove_returnsFalse_listUnchanged() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(9, 9));
        list.add(new Point(1, 2)); // target in middle
        list.add(new Point(8, 8));

        ArrayList<Point> before = new ArrayList<>(list);

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(1, 2));

        assertFalse(removed);
        assertEquals(before, list);
    }

    @Test
    void removeIfAtEnds_targetNotFound_returnsFalse_listUnchanged() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(1, 2));
        list.add(new Point(3, 4));

        ArrayList<Point> before = new ArrayList<>(list);

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(7, 7));

        assertFalse(removed);
        assertEquals(before, list);
    }

    @Test
    void removeIfAtEnds_emptyList_returnsFalse() {
        ArrayList<Point> list = new ArrayList<>();
        boolean removed = WarmUp.removeIfAtEnds(list, new Point(1, 2));
        assertFalse(removed);
        assertTrue(list.isEmpty());
    }

    @Test
    void removeIfAtEnds_singleElement_match_removesIt_returnsTrue() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(5, -6));

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(5, -6));

        assertTrue(removed);
        assertTrue(list.isEmpty());
    }

    @Test
    void removeIfAtEnds_singleElement_noMatch_returnsFalse() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(5, -6));

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(0, 0));

        assertFalse(removed);
        assertEquals(Arrays.asList(new Point(5, -6)), list);
    }

    @Test
    void removeIfAtEnds_targetAtBothEnds_withExtraMiddleTargets_onlyEndsRemoved() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(1, 2)); // first
        list.add(new Point(1, 2)); // middle (should remain)
        list.add(new Point(3, 4));
        list.add(new Point(1, 2)); // last

        boolean removed = WarmUp.removeIfAtEnds(list, new Point(1, 2));

        assertTrue(removed);
        assertEquals(Arrays.asList(new Point(1, 2), new Point(3, 4)), list);
    }


    // = = = = = =   ArrayList: duplicateEach   = = = = = =

    @Test
    void duplicateEach_typicalTwoElements() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b"));
        WarmUp.duplicateEach(list);
        assertEquals(Arrays.asList("a", "a", "b", "b"), list);
    }

    @Test
    void duplicateEach_emptyList_staysEmpty() {
        ArrayList<String> list = new ArrayList<>();
        WarmUp.duplicateEach(list);
        assertTrue(list.isEmpty());
    }

    @Test
    void duplicateEach_singleElement() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("x"));
        WarmUp.duplicateEach(list);
        assertEquals(Arrays.asList("x", "x"), list);
    }

    @Test
    void duplicateEach_preservesOrder_multipleElements() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        WarmUp.duplicateEach(list);
        assertEquals(Arrays.asList("a", "a", "b", "b", "c", "c"), list);
    }

    @Test
    void duplicateEach_elementsThatAreAlreadyEqual_eachInstanceDuplicated() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("hi", "hi"));
        WarmUp.duplicateEach(list);
        assertEquals(Arrays.asList("hi", "hi", "hi", "hi"), list);
    }

    @Test
    void duplicateEach_handlesEmptyString() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(""));
        WarmUp.duplicateEach(list);
        assertEquals(Arrays.asList("", ""), list);
    }

}
