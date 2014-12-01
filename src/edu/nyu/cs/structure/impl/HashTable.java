package edu.nyu.cs.structure.impl;

import java.util.ArrayList;
import java.util.List;

public class HashTable<V> {
    private static final int CAPACITY = 16;
    private final List<V>[] table;
    private final int capacity;

    public HashTable() {
        this(CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("table initial capacity should be positive");
        }
        
        this.capacity = capacity;
        table = (List<V>[]) new List[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<V>();
        }
    }
    
    public void clear() {
        for (List<V> values : table) {
            values.clear();
        }
    }
    
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        if (! (key instanceof Integer)) {
            return false;
        }
        int i = ((Integer) key).intValue();
        return i >= 0 && i < capacity;
    }
    
    @SuppressWarnings("unchecked")
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        V item = null;
        try {
            item = (V) value;
        } catch (ClassCastException e) {
            return false;
        }
        List<V> values = table[hashFunc(item)];
        for (V v : values) {
            if (v.equals(item)) {
                return true;
            }
        }
        return false;
    }
    
    public List<V> get(Object key) {
        if (key == null) {
            return null;
        }
        if (!(key instanceof Integer)) {
            return null;
        }
        Integer i = (Integer) key;
        if (i < 0 || i >= capacity) {
            return null;
        }
        return table[i];
    }
    
    public boolean isEmpty() {
        for (List<V> values : table) {
            if (values.size() != 0) {
                return false;
            }
        }
        return true;
    }
    
    public V put(V value) {
        if (value == null) {
            return null;
        }
        List<V> values = table[hashFunc(value)];
        if (values.contains(value)) {
            return null;
        } else {
            values.add(value);
            return value;
        }
    }
    
    @SuppressWarnings("unchecked")
    public V remove(Object value) {
        if (value == null) {
            return null;
        }
        V item = null;
        try {
            item = (V) value;
        } catch (ClassCastException e) {
            return null;
        }
        List<V> values = table[hashFunc(item)];
        if (values.contains(item)) {
            values.remove(item);
            return item;
        }
        return null;
    }
    
    public int size() {
        int size = 0;
        for (List<V> values : table) {
            size += values.size();
        }
        return size;
    }
    
    private int hashFunc(V value) {
        assert value != null;
        
        int result = value.hashCode() % capacity;
        return result < 0 ? result + capacity : result;
    }
    
}
