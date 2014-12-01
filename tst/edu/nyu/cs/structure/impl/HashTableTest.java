package edu.nyu.cs.structure.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
    private HashTable<String> notEmptyTable;
    private HashTable<String> emptyTable;
    private List<String> elements;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        emptyTable = new HashTable<String>();
        notEmptyTable = new HashTable<String>();
        elements = Arrays.asList(
                "Java", "C", "C++", "Python",
                "PHP", "Javascript", "Shell", "HTML/CSS",
                "Scala", "Perl", "SQL", "Ruby",
                "MySQL", "Linux", "Windows", "CGI",
                "HTTP", "TCP/IP", "RTSP/RTP", "Mac",
                "Vim", "Eclipse", "JUnit", "CUnit",
                "Git", "Subversion", "Flex & Bison",
                "Hadoop", "Qt", "Object C", "R",
                "JSP", "jQuery", "Microsoft Word");
        for (String s : elements) {
            notEmptyTable.put(s);
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#HashTable()}.
     */
    @Test
    public void testHashTable() {
        HashTable<Integer> table = new HashTable<Integer>();
        assertTrue(table.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#HashTable(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testHashTableIntWithNegativeCapacity() {
        @SuppressWarnings("unused")
        HashTable<Double> table = new HashTable<Double>(-7);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#HashTable(int)}.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testHashTableIntWithZeroCapacity() {
        @SuppressWarnings("unused")
        HashTable<Boolean> table = new HashTable<Boolean>(0);
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#HashTable(int)}.
     */
    @Test
    public void testHashTableIntPositiveCapacity() {
        HashTable<Float> table = new HashTable<Float>(68);
        assertTrue(table.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#clear()}.
     */
    @Test
    public void testClear() {
        assertTrue(emptyTable.isEmpty());
        emptyTable.clear();
        assertTrue(emptyTable.isEmpty());
        assertFalse(notEmptyTable.isEmpty());
        notEmptyTable.clear();
        assertTrue(emptyTable.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsKey(java.lang.Object)}.
     */
    @Test
    public void testContainsKeyWithNullObject() {
        assertFalse(emptyTable.containsKey(null));
        assertFalse(notEmptyTable.containsKey(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsKey(java.lang.Object)}.
     */
    @Test
    public void testContainsKeyWithNotIntegerObject() {
        assertFalse(emptyTable.containsKey("Leonard"));
        assertFalse(notEmptyTable.containsKey("Sheldon"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsKey(java.lang.Object)}.
     */
    @Test
    public void testContainsKeyWithNoKeyExist() {
        assertFalse(emptyTable.containsKey(65));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsKey(java.lang.Object)}.
     */
    @Test
    public void testContainsKeyWithKeyExist() {
        assertTrue(notEmptyTable.containsKey(5));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsValue(java.lang.Object)}.
     */
    @Test
    public void testContainsValueWithNullObject() {
        assertFalse(emptyTable.containsValue(null));
        assertFalse(notEmptyTable.containsValue(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsValue(java.lang.Object)}.
     */
    @Test
    public void testContainsValueWithNotEObject() {
        assertFalse(emptyTable.containsValue(12));
        assertFalse(notEmptyTable.containsValue(90.3));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsValue(java.lang.Object)}.
     */
    @Test
    public void testContainsValueWithNoValueExist() {
        String[] items = {
                "Amy", "Sheldon", "Penny", "Leonard",
                "Bernie", "Howard", "Lucy", "Rajesh",
                "Zack", "Stuart", "Alex", "Barry"};
        for (String s : items) {
            assertFalse(emptyTable.containsValue(s));
            assertFalse(notEmptyTable.containsValue(s));
        }
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#containsValue(java.lang.Object)}.
     */
    @Test
    public void testContainsValueWithValueExist() {
        for (String s : elements) {
            assertTrue(notEmptyTable.containsValue(s));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#get(java.lang.Object)}.
     */
    @Test
    public void testGetWithNullObject() {
        assertEquals(null, emptyTable.get(null));
        assertEquals(null, notEmptyTable.get(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#get(java.lang.Object)}.
     */
    @Test
    public void testGetWithNotIntegerObject() {
        assertEquals(null, emptyTable.get("Test"));
        assertEquals(null, notEmptyTable.get("Test"));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#get(java.lang.Object)}.
     */
    @Test
    public void testGetWithNoKeyExist() {
        assertEquals(null, emptyTable.get(80));
        assertEquals(null, notEmptyTable.get(20));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#get(java.lang.Object)}.
     */
    @Test
    public void testGetWithKeyExist() {
        assertEquals(0, emptyTable.get(2).size());
        notEmptyTable.get(9);
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(emptyTable.isEmpty());
        assertFalse(notEmptyTable.isEmpty());
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#put(java.lang.Object)}.
     */
    @Test
    public void testPutWithNullObject() {
        assertEquals(null, emptyTable.put(null));
        assertEquals(null, notEmptyTable.put(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#put(java.lang.Object)}.
     */
    @Test
    public void testPutWithDuplicateObject() {
        String s = "PHP";
        assertEquals(null, notEmptyTable.put(s));
        assertEquals(elements.size(), notEmptyTable.size());
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#put(java.lang.Object)}.
     */
    @Test
    public void testPutWithLegalObject() {
        String s = "Amy";
        assertFalse(emptyTable.containsValue(s));
        assertEquals(s, emptyTable.put(s));
        assertEquals(1, emptyTable.size());
        assertTrue(emptyTable.containsValue(s));
        assertFalse(notEmptyTable.containsValue(s));
        assertEquals(s, notEmptyTable.put(s));
        assertEquals(elements.size() + 1, notEmptyTable.size());
        assertTrue(notEmptyTable.containsValue(s));
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveWithNullObject() {
        assertEquals(null, emptyTable.remove(null));
        assertEquals(null, notEmptyTable.remove(null));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveWithNotEObject() {
        assertEquals(null, emptyTable.remove(123));
        assertEquals(null, notEmptyTable.remove(34.89));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveWithNoValueExist() {
        String s = "Amy";
        assertEquals(null, emptyTable.remove(s));
        assertEquals(null, notEmptyTable.remove(s));
    }
    
    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveWithValueExist() {
        for (String s : elements) {
            assertEquals(s, notEmptyTable.remove(s));
        }
    }

    /**
     * Test method for {@link edu.nyu.cs.structure.impl.HashTable#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(0, emptyTable.size());
        assertEquals(elements.size(), notEmptyTable.size());
    }

}
