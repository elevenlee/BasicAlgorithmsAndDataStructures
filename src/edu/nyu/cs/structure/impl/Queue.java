package edu.nyu.cs.structure.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E> {
    private Element<E> head;
    private Element<E> tail;
    
    private static class Element<E> {
        private final E key;
        private Element<E> next;
        
        Element(E key, Element<E> next) {
            this.key = key;
            this.next = next;
        }
        
    }
    
    public Queue() {
        head = tail = null;
    }
    
    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = head.key;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }
    
    public boolean enQueue(E e) {
        if (e == null) {
            return false;
        }
        if (isEmpty()) {
            head = tail = new Element<E>(e, null);
        } else {
            tail.next = new Element<E>(e, null);
            tail = tail.next;
        }
        return true;
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public E peek() {
        return isEmpty() ? null : head.key;
    }
    
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int length = 0;
        for (Element<E> curr = head; curr != tail.next; curr = curr.next) {
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
                return !(head == null && tail == null) && next != tail.next;
            }

            @Override
            public E next() {
                if ((head == null && tail == null) || next == tail.next) {
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
