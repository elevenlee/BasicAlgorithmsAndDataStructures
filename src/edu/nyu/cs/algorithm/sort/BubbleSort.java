package edu.nyu.cs.algorithm.sort;

import edu.nyu.cs.algorithm.util.Utility;

public class BubbleSort {
    
    private BubbleSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    Utility.exchange(a, j, j - 1);
                }
            }
        }
    }
    
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    Utility.exchange(a, j, j - 1);
                }
            }
        }
    }

}
