package edu.nyu.cs.algorithm.sort;

import edu.nyu.cs.algorithm.util.Utility;

public class SelectionSort {
    
    private SelectionSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a) {
        int smallest = 0;
        for (int i = 0; i < a.length; i++) {
            smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[smallest]) {
                    smallest = j;
                }
            }
            Utility.exchange(a, i, smallest);
        }
    }
    
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int smallest = 0;
        for (int i = 0; i < a.length; i++) {
            smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[smallest]) < 0) {
                    smallest = j;
                }
            }
            Utility.exchange(a, i, smallest);
        }
    }

}
