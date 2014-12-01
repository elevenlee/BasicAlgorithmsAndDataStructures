package edu.nyu.cs.structure.extend.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.nyu.cs.algorithm.util.Check;
import edu.nyu.cs.structure.impl.Queue;

public class StackByTwoQueues<E> implements Iterable<E> {
    private Queue<E> q1;
    private Queue<E> q2;
    
    public StackByTwoQueues() {
        q1 = new Queue<E>();
        q2 = new Queue<E>();
    }
    
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
    public E peek() {
        if (isEmpty()) {
            return null;
        } else if (q1.isEmpty()) {
            return q2.peek();
        } else {
            return q1.peek();
        }
    }
    
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (q1.isEmpty()) {
            return q2.deQueue();
        } else {
            return q1.deQueue();
        }
    }
    
    public E push(E item) {
        Check.nullCheck(item, "push item");
        
        if (isEmpty()) {
            q1.enQueue(item);
        } else if (q1.isEmpty()) {
            q1.enQueue(item);
            while (!q2.isEmpty()) {
                q1.enQueue(q2.deQueue());
            }
        } else {
            q2.enQueue(item);
            while (!q1.isEmpty()) {
                q2.enQueue(q1.deQueue());
            }
        }
        return peek();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Iterator<E> iter1 = q1.iterator();
            private Iterator<E> iter2 = q2.iterator();

            @Override
            public boolean hasNext() {
                if (isEmpty()) {
                    return false;
                } else if (q1.isEmpty()) {
                    return iter2.hasNext();
                } else {
                    return iter1.hasNext();
                }
            }

            @Override
            public E next() {
                if (isEmpty()) {
                    throw new NoSuchElementException();
                } else if (q1.isEmpty()) {
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
