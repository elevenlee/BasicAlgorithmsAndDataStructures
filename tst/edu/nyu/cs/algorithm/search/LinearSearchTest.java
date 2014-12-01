package edu.nyu.cs.algorithm.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinearSearchTest {
    private final byte[] a = {2,4,1,5,7,9,0,3,2,7,8,1,9,6};
    private final String[] s =
        {"amy", "eleven", "tom", "sheldon", "leonard", "tom", "howard", "rajesh"};

    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(byte[], byte)}.
     */
    @Test
    public void testSearchByteArrayByteNotFound() {
        assertEquals(-1, LinearSearch.search(a, (byte) 10));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(byte[], byte)}.
     */
    @Test
    public void testSearchByteArrayByteFoundAtFirst() {
        assertEquals(0, LinearSearch.search(a, (byte) 2));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(byte[], byte)}.
     */
    @Test
    public void testSearchByteArrayByteFoundAtMiddle() {
        assertEquals(5, LinearSearch.search(a, (byte) 9));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(byte[], byte)}.
     */
    @Test
    public void testSearchByteArrayByteFoundAtLast() {
        assertEquals(a.length - 1, LinearSearch.search(a, (byte) 6));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(byte[], byte)}.
     */
    @Test
    public void testSearchByteArrayByteFoundDuplicate() {
        assertEquals(4, LinearSearch.search(a, (byte) 7));
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchTArrayTNotFound() {
        assertEquals(-1, LinearSearch.search(s, "jack"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchTArrayTFoundAtFirst() {
        assertEquals(0, LinearSearch.search(s, "amy"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchTArrayTFoundAtMiddle() {
        assertEquals(3, LinearSearch.search(s, "sheldon"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchTArrayTFoundAtLast() {
        assertEquals(s.length - 1, LinearSearch.search(s, "rajesh"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.search.LinearSearch#search(T[], java.lang.Comparable)}.
     */
    @Test
    public void testSearchTArrayTFoundDuplicate() {
        assertEquals(2, LinearSearch.search(s, "tom"));
    }

}
