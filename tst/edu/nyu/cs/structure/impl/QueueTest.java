package edu.nyu.cs.structure.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    private Queue<String> emptyQueue;
    private Queue<String> notEmptyQueue;
    private List<String> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyQueue = new Queue<String>();
        notEmptyQueue = new Queue<String>();
        elements = Arrays.asList(
                "Java", "C", "C++", "Python",
                "PHP", "Javascript", "Shell", "HTML/CSS",
                "Scala", "Perl", "SQL", "Ruby");
        for (String s : elements) {
            notEmptyQueue.enQueue(s);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#Queue()}.
     */
    @Test
    public void testQueue() {
        Queue<String> q = new Queue<String>();
        assertTrue(q.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#deQueue()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testDeQueueInEmptyQueue() {
        emptyQueue.deQueue();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#deQueue()}.
     */
    @Test
    public void testDeQueueInNotEmptyQueue() {
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(elements.get(i), notEmptyQueue.deQueue());
        }
        assertTrue(notEmptyQueue.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#enQueue(java.lang.Object)}.
     */
    @Test
    public void testEnQueueWithNullObject() {
        assertFalse(emptyQueue.enQueue(null));
        assertFalse(notEmptyQueue.enQueue(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#enQueue(java.lang.Object)}.
     */
    @Test
    public void testEnQueueWithLegalObject() {
        String s = "Vim";
        assertTrue(emptyQueue.enQueue(s));
        assertEquals(1, emptyQueue.size());
        assertEquals(s, emptyQueue.peek());
        int length = notEmptyQueue.size();
        assertTrue(notEmptyQueue.enQueue(s));
        assertEquals(length + 1, notEmptyQueue.size());
        Iterator<String> iter = notEmptyQueue.iterator();
        for (int i = 0; i < elements.size(); i++) {
            iter.next();
        }
        assertEquals(s, iter.next());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyQueue.isEmpty());
        assertFalse(notEmptyQueue.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#peek()}.
     */
    @Test
    public void testPeekInEmptyQueue() {
        assertTrue(emptyQueue.isEmpty());
        assertEquals(null, emptyQueue.peek());
        assertTrue(emptyQueue.isEmpty());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#peek()}.
     */
    @Test
    public void testPeekInNotEmptyQueue() {
        assertEquals(elements.get(0), notEmptyQueue.peek());
        assertEquals(elements.get(0), notEmptyQueue.peek());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(0, emptyQueue.size());
        assertEquals(elements.size(), notEmptyQueue.size());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterator() {
        Iterator<String> iter = notEmptyQueue.iterator();
        int i = 0;
        while (iter.hasNext()) {
            assertEquals(elements.get(i), iter.next());
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterable() {
        int i = 0;
        for (String s : notEmptyQueue) {
            assertEquals(elements.get(i), s);
            i++;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test
    public void testIteratorContiguousHasNext() {
        Iterator<String> iterEmpty = emptyQueue.iterator();
        assertFalse(iterEmpty.hasNext());
        assertFalse(iterEmpty.hasNext());
        Iterator<String> iterNotEmpty = notEmptyQueue.iterator();
        assertTrue(iterNotEmpty.hasNext());
        assertTrue(iterNotEmpty.hasNext());
        assertEquals(elements.get(0), iterNotEmpty.next());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test
    public void testIteratorContiguousNext() {
        Iterator<String> iter = notEmptyQueue.iterator();
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(elements.get(i), iter.next());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorEmptyQueue() {
        Iterator<String> iter = emptyQueue.iterator();
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorNotEmptyQueue() {
        Iterator<String> iter = notEmptyQueue.iterator();
        for (int i = 0; i < elements.size(); i++) {
            iter.next();
        }
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.Queue#iterator()}.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Iterator<String> iter = notEmptyQueue.iterator();
        iter.remove();
    }

}
