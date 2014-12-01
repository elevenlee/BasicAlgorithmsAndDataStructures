package edu.nyu.cs.algorithm.util;

import org.junit.Test;

public class CheckTest {

    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#rangeCheck(int, int, java.lang.String)}.
     */
    @Test
    public void testRangeCheckInRange() {
        Check.rangeCheck(2, 5, "Test Data");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#rangeCheck(int, int, java.lang.String)}.
     */
    @Test
    public void testRangeCheckOutOfRangeWithEqualMax() {
        Check.rangeCheck(5, 5, "Test Data");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#rangeCheck(int, int, java.lang.String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testRangeCheckOutOfRangeWithBelowZero() {
        Check.rangeCheck(-1, 5, "Test Data");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#rangeCheck(int, int, java.lang.String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testRangeCheckOutOfRangeWithExceedMax() {
        Check.rangeCheck(7, 5, "Test Data");
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#nullCheck(java.lang.Object, java.lang.String)}.
     */
    @Test
    public void testNullCheckWithNotNullObject() {
        Check.nullCheck(new Object(), "Test Data");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#nullCheck(java.lang.Object, java.lang.String)}.
     */
    @Test(expected=NullPointerException.class)
    public void testNullCheckWithNullObject() {
        Check.nullCheck(null, "Test Data");
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#emptyCheck(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testEmptyCheckWithNotEmptyString() {
        Check.emptyCheck("It is a string.", "Test Data");
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Check#emptyCheck(java.lang.String, java.lang.String)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testEmptyCheckWithEmptyString() {
        Check.emptyCheck("", "Test Data");
    }

}
