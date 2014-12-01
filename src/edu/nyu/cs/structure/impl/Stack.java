package edu.nyu.cs.structure.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.algorithm.util.Check;

public class Stack<E> implements Iterable<E> {
    private Element<E> top;
    
    private static class Element<E> {
        private final E key;
        private Element<E> next;
        
        Element(E key, Element<E> next) {
            this.key = key;
            this.next = next;
        }
        
    }
    
    public Stack() {
        top = null;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public E peek() {
        return top == null ? null : top.key;
    }
    
    public E pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        Element<E> node = top;
        top = top.next;
        return node.key;
    }
    
    public E push(E item) {
        Check.nullCheck(item, "push item");
        
        top = new Element<E>(item, top);
        return top.key;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Element<E> curr = null;
            private Element<E> next = top;

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
