package edu.nyu.cs.structure.extend.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.structure.impl.Stack;

public class QueueByTwoStacks<E> implements Iterable<E> {
    private Stack<E> s1;
    private Stack<E> s2;
    
    public QueueByTwoStacks() {
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }
    
    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (s1.isEmpty()) {
            return s2.pop();
        } else {
            return s1.pop();
        }
    }
    
    public boolean enQueue(E e) {
        if (e == null) {
            return false;
        }
        
        if (isEmpty()) {
            s1.push(e);
        } else if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s2.push(e);
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(e);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return true;
    }
    
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public E peek() {
        if (isEmpty()) {
            return null;
        } else if (s1.isEmpty()) {
            return s2.peek();
        } else {
            return s1.peek();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> iter1 = s1.iterator();
            Iterator<E> iter2 = s2.iterator();

            @Override
            public boolean hasNext() {
                if (isEmpty()) {
                    return false;
                } else if (s1.isEmpty()) {
                    return iter2.hasNext();
                } else {
                    return iter1.hasNext();
                }
            }

            @Override
            public E next() {
                if (isEmpty()) {
                    throw new NoSuchElementException();
                } else if (s1.isEmpty()) {
                    return iter2.next();
                } else {
                    return iter1.next();
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }
    
}
