package edu.nyu.cs.structure.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.nyu.cs.structure.LinkedList;

public class SingleLinkedListTest {
    private LinkedList<String> notEmptyList;
    private LinkedList<String> emptyList;
    private List<String> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        notEmptyList = new SingleLinkedList<String>();
        emptyList = new SingleLinkedList<String>();
        elements = Arrays.asList(
                "Java", "C", "C++", "Python",
                "PHP", "Javascript", "Shell", "HTML/CSS",
                "Scala", "Perl", "SQL", "Ruby");
        for (String s : elements) {
            notEmptyList.add(s);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#SingleLinkedList()}.
     */
    @Test
    public void testSingleLinkedList() {
        LinkedList<Integer> singleLinkedList = new SingleLinkedList<Integer>();
        assertTrue(singleLinkedList.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(java.lang.Object)}.
     */
    @Test
    public void testAddEWithNullObject() {
        assertFalse(emptyList.add(null));
        assertFalse(notEmptyList.add(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(java.lang.Object)}.
     */
    @Test
    public void testAddEWithLegalObject() {
        String s = "Vim";
        int length = notEmptyList.size();
        assertTrue(emptyList.add(s));
        assertEquals(1, emptyList.size());
        assertEquals(s, emptyList.get(0));
        assertTrue(notEmptyList.add(s));
        assertEquals(length + 1, notEmptyList.size());
        assertEquals(s, notEmptyList.get(0));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(int, java.lang.Object)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testAddIntEAtIllegalPositionBelowZero() {
        String s = "Vim";
        notEmptyList.add(-1, s);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(int, java.lang.Object)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testAddIntEAtIllegalPositionExceedLength() {
        String s = "Vim";
        notEmptyList.add(100, s);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(int, java.lang.Object)}.
     */
    @Test(expected=NullPointerException.class)
    public void testAddIntEWithIllegalObject() {
        notEmptyList.add(1, null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(int, java.lang.Object)}.
     */
    @Test
    public void testAddIntEAtFirstPosition() {
        String s = "Vim";
        int length = notEmptyList.size();
        emptyList.add(0, s);
        assertEquals(1, emptyList.size());
        assertEquals(s, emptyList.get(0));
        notEmptyList.add(0, s);
        assertEquals(length + 1, notEmptyList.size());
        assertEquals(s, notEmptyList.get(0));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(int, java.lang.Object)}.
     */
    @Test
    public void testAddIntEAtMiddlePosition() {
        String s = "Vim";
        int length = notEmptyList.size();
        int position = 3;
        notEmptyList.add(position, s);
        assertEquals(length + 1, notEmptyList.size());
        assertEquals(s, notEmptyList.get(position));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#add(int, java.lang.Object)}.
     */
    @Test
    public void testAddIntEAtLastPosition() {
        String s = "Vim";
        int length = notEmptyList.size();
        notEmptyList.add(length, s);
        assertEquals(length + 1, notEmptyList.size());
        assertEquals(s, notEmptyList.get(length));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#clear()}.
     */
    @Test
    public void testClear() {
        emptyList.clear();
        assertTrue(emptyList.isEmpty());
        assertFalse(notEmptyList.isEmpty());
        notEmptyList.clear();
        assertTrue(notEmptyList.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNullObject() {
        assertFalse(emptyList.contains(null));
        assertFalse(notEmptyList.contains(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNotEObject() {
        Double d = new Double(12.34);
        assertFalse(emptyList.contains(d));
        assertFalse(notEmptyList.contains(d));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithContainedObject() {
        String s = "PHP";
        assertTrue(notEmptyList.contains(s));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNotContainedObject() {
        String s = "Vim";
        assertFalse(emptyList.contains(s));
        assertFalse(notEmptyList.contains(s));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#get(int)}.
     */
    @Test
    public void testGetWithIllegalPositionBelowZero() {
        assertEquals(null, emptyList.get(-2));
        assertEquals(null, notEmptyList.get(-2));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#get(int)}.
     */
    @Test
    public void testGetWithIllegalPositionExceedLength() {
        assertEquals(null, emptyList.get(100));
        assertEquals(null, notEmptyList.get(100));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#get(int)}.
     */
    @Test
    public void testGetFirstElement() {
        assertEquals(elements.get(elements.size() - 1), notEmptyList.get(0));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#get(int)}.
     */
    @Test
    public void testGetMiddleElement() {
        assertEquals(elements.get(elements.size() - 8), notEmptyList.get(7));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#get(int)}.
     */
    @Test
    public void testGetLastElement() {
        assertEquals(elements.get(0), notEmptyList.get(notEmptyList.size() - 1));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#indexOf(java.lang.Object)}.
     */
    @Test
    public void testIndexOfWithNullObject() {
        assertEquals(-1, emptyList.indexOf(null));
        assertEquals(-1, notEmptyList.indexOf(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#indexOf(java.lang.Object)}.
     */
    @Test
    public void testIndexOfWithNotEObject() {
        Boolean b = new Boolean(true);
        assertEquals(-1, emptyList.indexOf(b));
        assertEquals(-1, notEmptyList.indexOf(b));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#indexOf(java.lang.Object)}.
     */
    @Test
    public void testIndexOfFirstElement() {
        assertEquals(0, notEmptyList.indexOf("Ruby"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#indexOf(java.lang.Object)}.
     */
    @Test
    public void testIndexOfMiddleElement() {
        assertEquals(3, notEmptyList.indexOf("Scala"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#indexOf(java.lang.Object)}.
     */
    @Test
    public void testIndexOfLastElement() {
        assertEquals(notEmptyList.size() - 1, notEmptyList.indexOf("Java"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#indexOf(java.lang.Object)}.
     */
    @Test
    public void testIndexOfNotInListElement() {
        String s = "Vim";
        assertEquals(-1, emptyList.indexOf(s));
        assertEquals(-1, notEmptyList.indexOf(s));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(notEmptyList.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(int)}.
     */
    @Test
    public void testRemoveIntWithIllegalPositionBelowZero() {
        assertEquals(null, emptyList.remove(-2));
        assertTrue(emptyList.isEmpty());
        int length = notEmptyList.size();
        assertEquals(null, notEmptyList.remove(-2));
        assertEquals(length, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(int)}.
     */
    @Test
    public void testRemoveIntWithIllegalPositionExceedLength() {
        assertEquals(null, emptyList.remove(100));
        assertTrue(emptyList.isEmpty());
        int length = notEmptyList.size();
        assertEquals(null, notEmptyList.remove(100));
        assertEquals(length, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(int)}.
     */
    @Test
    public void testRemoveIntFirstElement() {
        int length = notEmptyList.size();
        assertEquals(elements.get(elements.size() - 1), notEmptyList.remove(0));
        assertEquals(length - 1, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(int)}.
     */
    @Test
    public void testRemoveIntMiddleElement() {
        int length = notEmptyList.size();
        assertEquals(elements.get(elements.size() - 6), notEmptyList.remove(5));
        assertEquals(length - 1, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(int)}.
     */
    @Test
    public void testRemoveIntLastElement() {
        int length = notEmptyList.size();
        assertEquals(elements.get(0), notEmptyList.remove(length - 1));
        assertEquals(length - 1, notEmptyList.size());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveObjectWithNullObject() {
        assertFalse(emptyList.remove(null));
        assertTrue(emptyList.isEmpty());
        int length = notEmptyList.size();
        assertFalse(notEmptyList.remove(null));
        assertEquals(length, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveObjectWithNotEObject() {
        List<Integer> l = new ArrayList<Integer>();
        assertFalse(emptyList.remove(l));
        assertTrue(emptyList.isEmpty());
        int length = notEmptyList.size();
        assertFalse(notEmptyList.remove(l));
        assertEquals(length, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveObjectFirstElement() {
        int length = notEmptyList.size();
        assertTrue(notEmptyList.remove("Java"));
        assertEquals(length - 1, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveObjectMiddleElement() {
        int length = notEmptyList.size();
        assertTrue(notEmptyList.remove("C++"));
        assertEquals(length - 1, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveObjectLastElement() {
        int length = notEmptyList.size();
        assertTrue(notEmptyList.remove("Ruby"));
        assertEquals(length - 1, notEmptyList.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveObjectNotInListElement() {
        int length = notEmptyList.size();
        assertFalse(notEmptyList.remove("Vim"));
        assertEquals(length, notEmptyList.size());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#reverse()}.
     */
    @Test
    public void testReverse() {
        emptyList.reverse();
        assertTrue(emptyList.isEmpty());
        notEmptyList.reverse();
        for (int i = 0; i < elements.size(); i++) {
            assertEquals(elements.get(i), notEmptyList.get(i));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(0, emptyList.size());
        assertEquals(elements.size(), notEmptyList.size());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterator() {
        Iterator<String> iter = notEmptyList.iterator();
        int i = elements.size() - 1;
        while (iter.hasNext()) {
            assertEquals(elements.get(i), iter.next());
            i--;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test
    public void testIteratorHappyPathIterable() {
        int i = elements.size() - 1;
        for (String s : notEmptyList) {
            assertEquals(elements.get(i), s);
            i--;
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test
    public void testIteratorContiguousHasNext() {
        Iterator<String> iterEmpty = emptyList.iterator();
        assertFalse(iterEmpty.hasNext());
        assertFalse(iterEmpty.hasNext());
        Iterator<String> iterNotEmpty = notEmptyList.iterator();
        assertTrue(iterNotEmpty.hasNext());
        assertTrue(iterNotEmpty.hasNext());
        assertEquals(elements.get(elements.size() - 1), iterNotEmpty.next());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test
    public void testIteratorContiguousNext() {
        Iterator<String> iter = notEmptyList.iterator();
        for (int i = elements.size() - 1; i >= 0; i--) {
            assertEquals(elements.get(i), iter.next());
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorEmptyLinkedList() {
        Iterator<String> iter = emptyList.iterator();
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test(expected=NoSuchElementException.class)
    public void testIteratorNotEmptyLinkedList() {
        Iterator<String> iter = notEmptyList.iterator();
        for (int i = 0; i < elements.size(); i++) {
            iter.next();
        }
        iter.next();
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.SingleLinkedList#iterator()}.
     */
    @Test(expected=UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Iterator<String> iter = notEmptyList.iterator();
        iter.remove();
    }

}
