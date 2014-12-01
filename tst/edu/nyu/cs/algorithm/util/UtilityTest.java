package edu.nyu.cs.algorithm.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Utility#exchange(byte[], int, int)}.
     */
    @Test
    public void testExchangeByteArrayIntInt() {
        byte[] a = {1,2,3,4,5};
        int i = 1;
        int j = 3;
        Utility.exchange(a, i, j);
        assertEquals((byte) 4, a[i]);
        assertEquals((byte) 2, a[j]);
    }

    /**
     * Test method for {@link edu.nyu.cs.algorithm.util.Utility#exchange(T[], int, int)}.
     */
    @Test
    public void testExchangeTArrayIntInt() {
        String[] a = {"amy", "eleven", "tom", "sheldon", "leonard", "howard"};
        int i = 3;
        int j = 2;
        Utility.exchange(a, i, j);
        assertEquals("tom", a[i]);
        assertEquals("sheldon", a[j]);
    }

}
