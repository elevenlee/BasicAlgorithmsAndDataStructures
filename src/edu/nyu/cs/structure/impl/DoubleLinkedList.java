package edu.nyu.cs.structure.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.algorithm.util.Check;
import edu.nyu.cs.structure.LinkedList;

public class DoubleLinkedList<E> implements LinkedList<E> {
    private Element<E> head;
    
    private static class Element<E> {
        private final E key;
        private Element<E> prev;
        private Element<E> next;
        
        Element(E key, Element<E> prev, Element<E> next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoubleLinkedList() {
        head = null;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            return false;
        }
        Element<E> element = new Element<E>(e, null, head);
        if (head != null) {
            head.prev = element;
        }
        head = element;
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
        if (curr != null) {
            Element<E> e = new Element<E>(element, curr.prev, curr);
            if (curr.prev != null) {
                curr.prev.next = e;
            } else {
                head = e;
            }
            curr.prev = e;
        } else if (prev != null){
            prev.next = new Element<E>(element, prev, null);
        } else {
            head = new Element<E>(element, null, null);
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
            key = (E) o;
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
        if (index < 0 || index > this.size() - 1) {
            return null;
        }
        Element<E> node = head;
        for (int i = 0; i < index; i++) {
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
        Element<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        if (curr.prev != null) {
            curr.prev.next = curr.next; 
        } else {
            head = curr.next;
        }
        if (curr.next != null) {
            curr.next.prev = curr.prev; 
        }
        curr.prev = curr.next = null;
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
        
        for (Element<E> curr = head; curr != null; curr = curr.next) {
            if (key.equals(curr.key)) {
                if (curr.prev != null) {
                    curr.prev.next = curr.next; 
                } else {
                    head = curr.next;
                }
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                curr.prev = curr.next = null;
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
            curr.prev = next;
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
