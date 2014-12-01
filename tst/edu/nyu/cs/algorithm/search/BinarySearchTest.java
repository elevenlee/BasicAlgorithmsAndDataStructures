package edu.nyu.cs.algorithm.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {
    private final byte[] a = {1, 3, 5, 7, 9, 11, 15, 31, 39, 45, 51, 63, 70, 72, 81, 90, 123, 125};
    private final String[] s =
        {"amy", "bob", "david", "eleven", "frank", "howard", "leonard", "rajesh", "sheldon"};

    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchRecursive(byte[], byte)}.
     */
    @Test
    public void testSearchRecursiveByteArrayByteNotFound() {
        byte[] testData = {
                -10, 2, 4, 6, 8, 10, 13, 20, 36, 40, 50, 56, 65, 71, 78, 88, 100, 124, 127};
        for (int i = 0; i < testData.length; i++) {
            assertEquals(-1, BinarySearch.searchRecursive(a, testData[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchRecursive(byte[], byte)}.
     */
    @Test
    public void testSearchRecursiveByteArrayByteFound() {
        for (int i = 0; i < a.length; i++) {
            assertEquals(i, BinarySearch.searchRecursive(a, a[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchIterative(byte[], byte)}.
     */
    @Test
    public void testSearchIterativeByteArrayByteNotFound() {
        byte[] testData = {
                -10, 2, 4, 6, 8, 10, 13, 20, 36, 40, 50, 56, 65, 71, 78, 88, 100, 124, 127};
        for (int i = 0; i < testData.length; i++) {
            assertEquals(-1, BinarySearch.searchIterative(a, testData[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchIterative(byte[], byte)}.
     */
    @Test
    public void testSearchIterativeByteArrayByteFound() {
        for (int i = 0; i < a.length; i++) {
            assertEquals(i, BinarySearch.searchIterative(a, a[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchRecursive(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchRecursiveTArrayTNotFound() {
        String[] testData =
            {"aa", "back", "carton", "edward", "fauk", "george", "jack", "penny", "saha", "zack"};
        for (int i = 0; i < testData.length; i++) {
            assertEquals(-1, BinarySearch.searchRecursive(s, testData[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchRecursive(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchRecursiveTArrayTFound() {
        for (int i = 0; i < s.length; i++) {
            assertEquals(i, BinarySearch.searchRecursive(s, s[i]));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchIterative(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchIterativeTArrayTNotFound() {
        String[] testData =
            {"aa", "back", "carton", "edward", "fauk", "george", "jack", "penny", "saha", "zack"};
        for (int i = 0; i < testData.length; i++) {
            assertEquals(-1, BinarySearch.searchIterative(s, testData[i]));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.BinarySearch#searchIterative(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchIterativeTArrayTFound() {
        for (int i = 0; i < s.length; i++) {
            assertEquals(i, BinarySearch.searchIterative(s, s[i]));
        }
    }

}
