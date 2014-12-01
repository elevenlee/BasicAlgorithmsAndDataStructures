package edu.nyu.cs.algorithm.util;

public class Utility {

    private Utility() {
        throw new AssertionError();
    }
    
    public static void exchange(byte[] a, final int i, final int j) {
        byte temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static <T> void exchange(T[] a, final int i, final int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
