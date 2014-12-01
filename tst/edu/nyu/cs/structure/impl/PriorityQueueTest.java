package edu.nyu.cs.structure.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    private PriorityQueue<Integer> emptyPriorityQueue;
    private PriorityQueue<Integer> notEmptyPriorityQueue;
    private List<Integer> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyPriorityQueue = new PriorityQueue<Integer>();
        notEmptyPriorityQueue = new PriorityQueue<Integer>(32);
        elements = Arrays.asList(
                33, 22, 38, 42, 30, 18, 35, 45, 25, 20,
                 8,  2, 14, 34, 31, 29, 41,  6, 24, 43);
        for (Integer i : elements) {
            notEmptyPriorityQueue.offer(i);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#PriorityQueue()}.
     */
    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        assertTrue(pq.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#PriorityQueue(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testPriorityQueueIntWithIllegalCapacity() {
        @SuppressWarnings("unused")
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(-10);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#PriorityQueue(int)}.
     */
    @Test
    public void testPriorityQueueIntWithLegalCapacity() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(50);
        assertTrue(pq.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#clear()}.
     */
    @Test
    public void testClear() {
        assertTrue(emptyPriorityQueue.isEmpty());
        emptyPriorityQueue.clear();
        assertTrue(emptyPriorityQueue.isEmpty());
        assertFalse(notEmptyPriorityQueue.isEmpty());
        notEmptyPriorityQueue.clear();
        assertTrue(notEmptyPriorityQueue.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNullObject() {
        assertFalse(notEmptyPriorityQueue.contains(null));
        assertFalse(emptyPriorityQueue.contains(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNotEObject() {
        String s = "Vim";
        assertFalse(notEmptyPriorityQueue.contains(s));
        assertFalse(emptyPriorityQueue.contains(s));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithContainedObject() {
        assertTrue(notEmptyPriorityQueue.contains((Integer) 29));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNotContainedObject() {
        Integer i = 888;
        assertFalse(notEmptyPriorityQueue.contains(i));
        assertFalse(emptyPriorityQueue.contains(i));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(notEmptyPriorityQueue.isEmpty());
        assertTrue(emptyPriorityQueue.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#offer(java.lang.Comparable)}.
     */
    @Test
    public void testOfferWithNullObject() {
        assertFalse(notEmptyPriorityQueue.offer(null));
        assertFalse(emptyPriorityQueue.offer(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#offer(java.lang.Comparable)}.
     */
    @Test
    public void testOfferWithExceedCapacity() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1);
        assertTrue(pq.offer(12));
        assertFalse(pq.offer(22));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#offer(java.lang.Comparable)}.
     */
    @Test
    public void testOfferWithMaximumElement() {
        List<Integer> expectNotEmpty = Arrays.asList(
                50, 45, 35, 41, 43, 18, 34, 38, 25, 42,
                 8,  2, 14, 33, 31, 22, 29,  6, 24, 20, 30);
        assertTrue(notEmptyPriorityQueue.offer(50));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expectNotEmpty.get(i), integer);
            i++;
        }
        List<Integer> expectEmpty = Arrays.asList(50);
        emptyPriorityQueue.offer(50);
        int j = 0;
        for (Integer integer : emptyPriorityQueue) {
            assertEquals(expectEmpty.get(j), integer);
            j++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#offer(java.lang.Comparable)}.
     */
    @Test
    public void testOfferWithMiddleElement() {
        List<Integer> expectNotEmpty = Arrays.asList(
                45, 43, 35, 41, 42, 18, 34, 38, 25, 38,
                 8,  2, 14, 33, 31, 22, 29,  6, 24, 20, 30);
        assertTrue(notEmptyPriorityQueue.offer(38));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expectNotEmpty.get(i), integer);
            i++;
        }
        List<Integer> expectEmpty = Arrays.asList(38);
        emptyPriorityQueue.offer(38);
        int j = 0;
        for (Integer integer : emptyPriorityQueue) {
            assertEquals(expectEmpty.get(j), integer);
            j++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#offer(java.lang.Comparable)}.
     */
    @Test
    public void testOfferWithMinimumElement() {
        List<Integer> expectNotEmpty = Arrays.asList(
                45, 43, 35, 41, 42, 18, 34, 38, 25, 30,
                 8,  2, 14, 33, 31, 22, 29,  6, 24, 20, 1);
        assertTrue(notEmptyPriorityQueue.offer(1));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expectNotEmpty.get(i), integer);
            i++;
        }
        List<Integer> expectEmpty = Arrays.asList(1);
        emptyPriorityQueue.offer(1);
        int j = 0;
        for (Integer integer : emptyPriorityQueue) {
            assertEquals(expectEmpty.get(j), integer);
            j++;
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#peek()}.
     */
    @Test
    public void testPeekInEmptyPriorityQueue() {
        assertTrue(emptyPriorityQueue.isEmpty());
        assertEquals(null, emptyPriorityQueue.peek());
        assertTrue(emptyPriorityQueue.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#peek()}.
     */
    @Test
    public void testPeekInNotEmptyPriorityQueue() {
        assertEquals((Integer) 45, notEmptyPriorityQueue.peek());
        assertEquals((Integer) 45, notEmptyPriorityQueue.peek());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#poll()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testPollInEmptyPriorityQueue() {
        emptyPriorityQueue.poll();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#poll()}.
     */
    @Test
    public void testPollInNotEmptyPriorityQueue() {
        List<Integer> expect = Arrays.asList(
                45, 43, 42, 41, 38, 35, 34, 33, 31, 30,
                29, 25, 24, 22, 20, 18, 14,  8,  6,  2);
        for (Integer i : expect) {
            assertEquals(i, notEmptyPriorityQueue.poll());
        }
        assertTrue(notEmptyPriorityQueue.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#remove(int)}.
     */
    @Test
    public void testRemoveWithIllegalPositionBelowZero() {
        int length = notEmptyPriorityQueue.size();
        assertEquals(null, notEmptyPriorityQueue.remove(-4));
        assertEquals(length, notEmptyPriorityQueue.size());
        assertEquals(null, emptyPriorityQueue.remove(-4));
        assertTrue(emptyPriorityQueue.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#remove(int)}.
     */
    @Test
    public void testRemoveWithIllegalPositionExceedLength() {
        int length = notEmptyPriorityQueue.size();
        assertEquals(null, notEmptyPriorityQueue.remove(100));
        assertEquals(length, notEmptyPriorityQueue.size());
        assertEquals(null, emptyPriorityQueue.remove(100));
        assertTrue(emptyPriorityQueue.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#remove(int)}.
     */
    @Test
    public void testRemoveFirstElement() {
        List<Integer> expect = Arrays.asList(
                43, 42, 35, 41, 30, 18, 34, 38, 25, 20,
                 8,  2, 14, 33, 31, 22, 29,  6, 24);
        assertEquals((Integer) 45, notEmptyPriorityQueue.remove(0));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expect.get(i), integer);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#remove(int)}.
     */
    @Test
    public void testRemoveMiddleElementUp() {
        List<Integer> expect = Arrays.asList(
                45, 43, 35, 41, 42, 20, 34, 38, 25, 30,
                 8,  2, 18, 33, 31, 22, 29,  6, 24);
        assertEquals((Integer) 14, notEmptyPriorityQueue.remove(12));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expect.get(i), integer);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#remove(int)}.
     */
    @Test
    public void testRemoveMiddleElementDown() {
        List<Integer> expect = Arrays.asList(
                45, 43, 35, 41, 30, 18, 34, 38, 25, 20,
                 8,  2, 14, 33, 31, 22, 29,  6, 24);
        assertEquals((Integer) 42, notEmptyPriorityQueue.remove(4));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expect.get(i), integer);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#remove(int)}.
     */
    @Test
    public void testRemoveLastElement() {
        List<Integer> expect = Arrays.asList(
                45, 43, 35, 41, 42, 18, 34, 38, 25, 30,
                 8,  2, 14, 33, 31, 22, 29,  6, 24);
        assertEquals((Integer) 20, notEmptyPriorityQueue.remove(notEmptyPriorityQueue.size() - 1));
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expect.get(i), integer);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(elements.size(), notEmptyPriorityQueue.size());
        assertEquals(0, emptyPriorityQueue.size());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterator() {
        List<Integer> expect = Arrays.asList(
                45, 43, 35, 41, 42, 18, 34, 38, 25, 30,
                 8,  2, 14, 33, 31, 22, 29,  6, 24, 20);
        Iterator<Integer> iter = notEmptyPriorityQueue.iterator();
        int i = 0;
        while (iter.hasNext()) {
            assertEquals(expect.get(i), iter.next());
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterable() {
        List<Integer> expect = Arrays.asList(
                45, 43, 35, 41, 42, 18, 34, 38, 25, 30,
                 8,  2, 14, 33, 31, 22, 29,  6, 24, 20);
        int i = 0;
        for (Integer integer : notEmptyPriorityQueue) {
            assertEquals(expect.get(i), integer);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test
    public void testIteratorContiguousHasNext() {
        Iterator<Integer> emptyIter = emptyPriorityQueue.iterator();
        assertFalse(emptyIter.hasNext());
        assertFalse(emptyIter.hasNext());
        Iterator<Integer> notEmptyIter = notEmptyPriorityQueue.iterator();
        assertTrue(notEmptyIter.hasNext());
        assertTrue(notEmptyIter.hasNext());
        assertEquals((Integer) 45, notEmptyIter.next());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test
    public void testIteratorContiguousNext() {
        List<Integer> expect = Arrays.asList(
                45, 43, 35, 41, 42, 18, 34, 38, 25, 30,
                 8,  2, 14, 33, 31, 22, 29,  6, 24, 20);
        Iterator<Integer> iter = notEmptyPriorityQueue.iterator();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), iter.next());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorEmptyPriorityQueue() {
        Iterator<Integer> iter = emptyPriorityQueue.iterator();
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorNotEmptyPriorityQueue() {
        Iterator<Integer> iter = notEmptyPriorityQueue.iterator();
        for (int i = 0; i < elements.size(); i++) {
            iter.next();
        }
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.PriorityQueue#iterator()}.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Iterator<Integer> iter = notEmptyPriorityQueue.iterator();
        iter.remove();
    }

}
