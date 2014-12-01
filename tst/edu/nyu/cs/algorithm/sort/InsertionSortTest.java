package edu.nyu.cs.algorithm.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSortTest {
    private final byte[] byteAfterSorting =
        { 2,  5,  7,  7,  7,   7,  10,  10,  23,
         31, 31, 40, 41, 55,  55,  55,  62,  64,
         70, 88, 89, 90, 94, 101, 105, 126, 126};
    private final String[] objectAfterSorting = 
        {    "amy",  "berny", "eleven",  "eleven",
          "eleven", "howard", "howard", "leonard",
            "lucy",  "penny", "rajesh", "sheldon",
         "sheldon", "stuart",   "zack",    "zack"};

    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(byte[])}.
     */
    @Test
    public void testSortByteArrayWithSingleElement() {
        byte[] a = {9};
        byte[] b = {9};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(b[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(byte[])}.
     */
    @Test
    public void testSortByteArrayWithIncreaseOrderElements() {
        byte[] a = 
            { 2,  5,  7,  7,  7,   7,  10,  10,  23,
             31, 31, 40, 41, 55,  55,  55,  62,  64,
             70, 88, 89, 90, 94, 101, 105, 126, 126};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(byteAfterSorting[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(byte[])}.
     */
    @Test
    public void testSortByteArrayWithDecreaseOrderElements() {
        byte[] a = 
            {126, 126, 105, 101, 94, 90, 89, 88, 70,
              64,  62,  55,  55, 55, 41, 40, 31, 31,
              23,  10,  10,   7,  7,  7,  7,  5,  2};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(byteAfterSorting[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(byte[])}.
     */
    @Test
    public void testSortByteArrayWithRandomOrderElements() {
        byte[] a =
            {41, 101,  70,  7,  7, 23, 55, 64, 126,
             55,   7,   2, 90, 89, 31, 40, 10,  31,
             94, 105, 126, 88, 55, 10,  5,  7,  62};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(byteAfterSorting[i], a[i]);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(T[])}.
     */
    @Test
    public void testSortTArrayWithSingleElement() {
        String[] a = {"amy"};
        String[] b = {"amy"};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(b[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(T[])}.
     */
    @Test
    public void testSortTArrayWithIncreaseOrderElements() {
        String[] a = 
            {   "amy",  "berny", "eleven",  "eleven",
             "eleven", "howard", "howard", "leonard",
               "lucy",  "penny", "rajesh", "sheldon",
            "sheldon", "stuart",   "zack",    "zack"};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(objectAfterSorting[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(T[])}.
     */
    @Test
    public void testSortTArrayWithDecreaseOrderElements() {
        String[] a =
            {   "zack",   "zack", "stuart", "sheldon",
             "sheldon", "rajesh",  "penny",    "lucy",
             "leonard", "howard", "howard",  "eleven",
              "eleven", "eleven",  "berny",     "amy"};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(objectAfterSorting[i], a[i]);
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.algorithm.sort.InsertionSort#sort(T[])}.
     */
    @Test
    public void testSortTArrayWithRandomOrderElements() {
        String[] a = 
            {"eleven", "leonard",  "penny", "stuart",
             "rajesh",    "lucy",  "berny", "eleven",
               "zack", "sheldon", "howard", "howard",
                "amy", "sheldon",   "zack", "eleven"};
        InsertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(objectAfterSorting[i], a[i]);
        }
    }

}
