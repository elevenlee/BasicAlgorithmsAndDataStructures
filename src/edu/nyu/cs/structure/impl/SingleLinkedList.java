package edu.nyu.cs.structure.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.algorithm.util.Check;
import edu.nyu.cs.structure.LinkedList;

public class SingleLinkedList<E> implements LinkedList<E> {
    private Element<E> head;
    
    private static class Element<E> {
        private final E key;
        private Element<E> next;
        
        Element(E key, Element<E> next) {
            this.key = key;
            this.next = next;
        }
        
    }

    public SingleLinkedList() {
        head = null;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        head = new Element<E>(e, head);
        return true;
    }

    @Override
    public void add(int index, E element) {
        Check.rangeCheck(index, this.size(), "index");
        Check.nullCheck(element, "element");
        
        Element<E> curr = head;
        Element<E> prev = null;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            head = new Element<E>(element, curr);
        } else {
            prev.next = new Element<E>(element, curr);
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        E key = null;
        try {
            key= (E) o;
        } catch (ClassCastException e) {
            return false;
        }
        
        for (Element<E> node = head; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        Element<E> node = head;
        for (int i = 0 ; i < index; i++) {
            node = node.next;
        }
        return node.key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            return -1;
        }
        E key = null;
        try {
            key = (E) o;
        } catch (ClassCastException e) {
            return -1;
        }
        
        int index = 0;
        for (Element<E> node = head; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > this.size() - 1) {
            return null;
        }
        Element<E> prev = null;
        Element<E> curr = head;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;
        return curr.key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }
        E key = null;
        try {
            key = (E) o;
        } catch (ClassCastException e) {
            return false;
        }
        
        for (Element<E> curr = head, prev = null; curr != null; prev = curr, curr = curr.next) {
            if (key.equals(curr.key)) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void reverse() {
        Element<E> curr = head;
        Element<E> prev = null;
        Element<E> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    @Override
    public int size() {
        int length = 0;
        for (Element<E> node = head; node != null; node = node.next) {
            length++;
        }
        return length;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Element<E> curr = null;
            private Element<E> next = head;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public E next() {
                if (next == null) {
                    throw new NoSuchElementException();
                }
                curr = next;
                next = next.next;
                return curr.key;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

}
