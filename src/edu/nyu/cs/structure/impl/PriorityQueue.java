package edu.nyu.cs.structure.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.algorithm.util.Check;
import edu.nyu.cs.algorithm.util.Utility;

public class PriorityQueue<E extends Comparable<? super E>> implements Iterable<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] elements;
    private int heapSize;
    
    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        elements = (E[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
        heapSize = 0;
    }
    
    @SuppressWarnings("unchecked")
    public PriorityQueue(int initialCapacity) {
        Check.rangeCheck(initialCapacity, Integer.MAX_VALUE, "initial capacity");
        
        elements = (E[]) new Comparable[initialCapacity];
        heapSize = 0;
    }
    
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        heapSize = 0;
    }
    
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        E key = null;
        try {
            key = (E) o;
        } catch (ClassCastException e) {
            return false;
        }
        for (int i = 0; i < heapSize; i++) {
            if (key.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmpty() {
        return heapSize == 0;
    }
    
    public boolean offer(E e) {
        if (e == null) {
            return false;
        }
        if (heapSize >= elements.length) {
            return false;
        }
        elements[heapSize] = e;
        int i = heapSize;
        while (i > 0 && e.compareTo(elements[(i - 1) / 2]) > 0) {
            elements[i] = elements[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        elements[i] = e;
        heapSize = heapSize + 1;
        return true;
    }
    
    public E peek() {
        if (heapSize == 0) {
            return null;
        }
        return elements[0];
    }
    
    public E poll() {
        if (heapSize == 0) {
            throw new NoSuchElementException();
        }
        E max = elements[0];
        heapSize = heapSize - 1;
        Utility.exchange(elements, 0, heapSize);
        maxHeapify(0);
        return max;
    }
    
    public E remove(int index) {
        if (index < 0 || index >= heapSize) {
            return null;
        }
        E element = elements[index];
        heapSize = heapSize - 1;
        Utility.exchange(elements, index, heapSize);
        if (index > 0 && elements[index].compareTo(elements[(index - 1) / 2]) > 0) {
            E e = elements[index];
            while (index > 0 && e.compareTo(elements[(index - 1) / 2]) > 0) {
                elements[index] = elements[(index - 1) / 2];
                index = (index - 1) / 2;
            }
            elements[index] = e;
        } else {
            maxHeapify(index);
        }
        return element;
    }
    
    public int size() {
        return heapSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < heapSize;
            }

            @Override
            public E next() {
                if (position >= heapSize) {
                    throw new NoSuchElementException();
                }
                return elements[position++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }
    
    private void maxHeapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && elements[left].compareTo(elements[largest]) > 0) {
            largest = left;
        }
        if (right < heapSize && elements[right].compareTo(elements[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            Utility.exchange(elements, largest, index);
            maxHeapify(largest);
        }
    }

}
