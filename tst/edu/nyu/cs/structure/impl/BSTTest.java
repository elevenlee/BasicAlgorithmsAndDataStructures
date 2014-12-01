package edu.nyu.cs.structure.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    private BST<Integer> notEmptyBST;
    private BST<Integer> emptyBST;
    private List<Integer> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        notEmptyBST = new BST<Integer>();
        emptyBST = new BST<Integer>();
        elements = Arrays.asList(
                33, 22, 38, 42, 30, 18, 35, 45, 25, 20,
                 8,  2, 14, 34, 31, 29, 41,  6, 24, 43);
        for (Integer i : elements) {
            notEmptyBST.add(i);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#BST()}.
     */
    @Test
    public void testBST() {
        BST<String> bst = new BST<String>();
        assertTrue(bst.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#add(java.lang.Comparable)}.
     */
    @Test(expected=NullPointerException.class)
    public void testAddWithNullObject() {
        notEmptyBST.add(null);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#add(java.lang.Comparable)}.
     */
    @Test
    public void testAddInEmptyBST() {
        Integer i = 12;
        emptyBST.add(i);
        assertEquals(1, emptyBST.getSize());
        assertTrue(emptyBST.contains(i));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#add(java.lang.Comparable)}.
     */
    @Test
    public void testAddInNotEmptyBST() {
        Integer i = 32;
        int size = notEmptyBST.getSize();
        notEmptyBST.add(i);
        assertEquals(size + 1, notEmptyBST.getSize());
        assertTrue(notEmptyBST.contains(i));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#clear()}.
     */
    @Test
    public void testClear() {
        assertTrue(emptyBST.isEmpty());
        emptyBST.clear();
        assertTrue(emptyBST.isEmpty());
        assertFalse(notEmptyBST.isEmpty());
        notEmptyBST.clear();
        assertTrue(notEmptyBST.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNullObject() {
        assertFalse(emptyBST.contains(null));
        assertFalse(notEmptyBST.contains(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNotEObject() {
        Object o = new Object();
        assertFalse(emptyBST.contains(o));
        assertFalse(notEmptyBST.contains(o));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithContainedObject() {
        for (Integer i : elements) {
            assertTrue(notEmptyBST.contains(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#contains(java.lang.Object)}.
     */
    @Test
    public void testContainsWithNotContainedObject() {
        Integer i = 32;
        assertFalse(emptyBST.contains(i));
        assertFalse(notEmptyBST.contains(i));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#getSize()}.
     */
    @Test
    public void testGetSize() {
        assertEquals(0, emptyBST.getSize());
        assertEquals(elements.size(), notEmptyBST.getSize());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#keysInOrder()}.
     */
    @Test
    public void testKeysInOrder() {
        List<Integer> expect = Arrays.asList(
                 2,  6,  8, 14, 18, 20, 22, 24, 25, 29,
                30, 31, 33, 34, 35, 38, 41, 42, 43, 45);
        List<Integer> resultNotEmpty = notEmptyBST.keysInOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), resultNotEmpty.get(i));
        }
        List<Integer> resultEmpty = emptyBST.keysInOrder();
        assertTrue(resultEmpty.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#keysPostOrder()}.
     */
    @Test
    public void testKeysPostOrder() {
        List<Integer> expect = Arrays.asList(
                  6,  2, 14,  8, 20, 18, 24, 29, 25, 31,
                 30, 22, 34, 35, 41, 43, 45, 42, 38, 33);
        List<Integer> resultNotEmpty = notEmptyBST.keysPostOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), resultNotEmpty.get(i));
        }
        List<Integer> resultEmpty = emptyBST.keysPostOrder();
        assertTrue(resultEmpty.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#keysPreOrder()}.
     */
    @Test
    public void testKeysPreOrder() {
        List<Integer> expect = Arrays.asList(
                33, 22, 18,  8,  2,  6, 14, 20, 30, 25,
                24, 29, 31, 38, 35, 34, 42, 41, 45, 43);
        List<Integer> resultNotEmpty = notEmptyBST.keysPreOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), resultNotEmpty.get(i));
        }
        List<Integer> resultEmpty = emptyBST.keysPreOrder();
        assertTrue(resultEmpty.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyBST.isEmpty());
        assertFalse(notEmptyBST.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#max()}.
     */
    @Test
    public void testMaxInEmptyBST() {
        assertEquals(null, emptyBST.max());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#max()}.
     */
    @Test
    public void testMaxInNotEmptyBST() {
        assertEquals((Integer) 45, notEmptyBST.max());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#min()}.
     */
    @Test
    public void testMinInEmptyBST() {
        assertEquals(null, emptyBST.min());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#min()}.
     */
    @Test
    public void testMinInNotEmptyBST() {
        assertEquals((Integer) 2, notEmptyBST.min());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#predecessor(java.lang.Comparable)}.
     */
    @Test
    public void testPredecessorWithNullObject() {
        assertEquals(null, emptyBST.predecessor(null));
        assertEquals(null, notEmptyBST.predecessor(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#predecessor(java.lang.Comparable)}.
     */
    @Test
    public void testPredecessorNotContainedElement() {
        assertEquals(null, emptyBST.predecessor((Integer) 12));
        assertEquals(null, notEmptyBST.predecessor((Integer) 12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#predecessor(java.lang.Comparable)}.
     */
    @Test
    public void testPredecessorContainedElement() {
        List<Integer> expect = Arrays.asList(
                null,  2,  6,  8, 14, 18, 20, 22, 24, 25,
                  29, 30, 31, 33, 34, 35, 38, 41, 42, 43, 45);
        for (int i = 1; i < expect.size(); i++) {
            assertEquals(expect.get(i - 1), notEmptyBST.predecessor(expect.get(i)));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemoveWithNullObject() {
        assertFalse(notEmptyBST.remove(null));
        assertFalse(emptyBST.remove(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemoveNotContainedElement() {
        assertFalse(notEmptyBST.remove((Integer) 12));
        assertFalse(emptyBST.remove((Integer) 12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemoveContainedElementNoChild() {
        List<Integer> expect = Arrays.asList(
                 2,  6,  8, 14, 18, 20, 22, 24, 25,
                30, 31, 33, 34, 35, 38, 41, 42, 43, 45);
        assertTrue(notEmptyBST.remove((Integer) 29));
        List<Integer> result = notEmptyBST.keysInOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), result.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemoveContainedElementNoLeftChild() {
        List<Integer> expect = Arrays.asList(
                 6,  8, 14, 18, 20, 22, 24, 25, 29,
                30, 31, 33, 34, 35, 38, 41, 42, 43, 45);
        assertTrue(notEmptyBST.remove((Integer) 2));
        List<Integer> result = notEmptyBST.keysInOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), result.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemoveContainedElementNoRightChild() {
        List<Integer> expect = Arrays.asList(
                 2,  6,  8, 14, 18, 20, 22, 24, 25, 29,
                30, 31, 33, 34, 38, 41, 42, 43, 45);
        assertTrue(notEmptyBST.remove((Integer) 35));
        List<Integer> result = notEmptyBST.keysInOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), result.get(i));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#remove(java.lang.Comparable)}.
     */
    @Test
    public void testRemoveContainedElementBothChild() {
        List<Integer> expect = Arrays.asList(
                 2,  6,  8, 14, 18, 20, 22, 24, 25, 29,
                30, 31, 34, 35, 38, 41, 42, 43, 45);
        assertTrue(notEmptyBST.remove((Integer) 33));
        List<Integer> result = notEmptyBST.keysInOrder();
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), result.get(i));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#successor(java.lang.Comparable)}.
     */
    @Test
    public void testSuccessorWithNullObject() {
        assertEquals(null, notEmptyBST.successor(null));
        assertEquals(null, emptyBST.successor(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#successor(java.lang.Comparable)}.
     */
    @Test
    public void testSuccessorNotContainedElement() {
        assertEquals(null, notEmptyBST.successor((Integer) 12));
        assertEquals(null, emptyBST.successor((Integer) 12));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.BST#successor(java.lang.Comparable)}.
     */
    @Test
    public void testSuccessorContainedElement() {
        List<Integer> expect = Arrays.asList(
                2,  6,  8, 14, 18, 20, 22, 24, 25, 29,
               30, 31, 33, 34, 35, 38, 41, 42, 43, 45, null);
        for (int i = 0; i < expect.size() - 1; i++) {
            assertEquals(expect.get(i + 1), notEmptyBST.successor(expect.get(i)));
        }
    }

}
