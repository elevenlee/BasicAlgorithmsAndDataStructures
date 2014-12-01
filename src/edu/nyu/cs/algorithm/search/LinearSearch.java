package edu.nyu.cs.algorithm.search;

public class LinearSearch {
    
    private LinearSearch() {
        throw new AssertionError();
    }
    
    public static int search(byte[] a, byte key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public static <T extends Comparable<? super T>> int search(T[] a, T key) {
        for (int i  = 0; i < a.length; i++) {
            if (a[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
    
}
