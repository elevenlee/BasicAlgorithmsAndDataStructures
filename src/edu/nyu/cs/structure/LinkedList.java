package edu.nyu.cs.structure;

public interface LinkedList<E> extends Iterable<E> {

    public boolean add(E e);
    public void add(int index, E element);
    public void clear();
    public boolean contains(Object o);
    public E get(int index);
    public int indexOf(Object o);
    public boolean isEmpty();
    public E remove(int index);
    public boolean remove(Object o);
    public void reverse();
    public int size();
    
}
