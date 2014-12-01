package edu.nyu.cs.algorithm.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountingSortTest {
    private final byte[] byteAfterSorting =
        { 2,  5,  7,  7,  7,   7,  10,  10,  23,
         31, 31, 40, 41, 55,  55,  55,  62,  64,
         70, 88, 89, 90, 94, 101, 105, 126, 126};
    private final byte k = 126;
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.CountingSort#sort(byte[], byte[], byte)}.
     */
    @Test
    public void testSortWithSingleElement() {
        byte[] a = {9};
        byte[] b = new byte[1];
        byte[] result = {9};
        CountingSort.sort(a, b, (byte) 9);
        for (int i = 0; i < b.length; i++) {
            assertEquals(result[i], b[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.CountingSort#sort(byte[], byte[], byte)}.
     */
    @Test
    public void testSortWithIncreaseOrderElements() {
        byte[] a = 
            { 2,  5,  7,  7,  7,   7,  10,  10,  23,
             31, 31, 40, 41, 55,  55,  55,  62,  64,
             70, 88, 89, 90, 94, 101, 105, 126, 126};
        byte[] b = new byte[27];
        CountingSort.sort(a, b, k);
        for (int i = 0; i < b.length; i++) {
            assertEquals(byteAfterSorting[i], b[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.CountingSort#sort(byte[], byte[], byte)}.
     */
    @Test
    public void testSortWithDecreaseOrderElements() {
        byte[] a = 
            {126, 126, 105, 101, 94, 90, 89, 88, 70,
              64,  62,  55,  55, 55, 41, 40, 31, 31,
              23,  10,  10,   7,  7,  7,  7,  5,  2};
        byte[] b = new byte[27];
        CountingSort.sort(a, b, k);
        for (int i = 0; i < b.length; i++) {
            assertEquals(byteAfterSorting[i], b[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.CountingSort#sort(byte[], byte[], byte)}.
     */
    @Test
    public void testSortWithRandomOrderElements() {
        byte[] a =
            {41, 101,  70,  7,  7, 23, 55, 64, 126,
             55,   7,   2, 90, 89, 31, 40, 10,  31,
             94, 105, 126, 88, 55, 10,  5,  7,  62};
        byte[] b = new byte[27];
        CountingSort.sort(a, b, k);
        for (int i = 0; i < b.length; i++) {
            assertEquals(byteAfterSorting[i], b[i]);
        }
    }

}
