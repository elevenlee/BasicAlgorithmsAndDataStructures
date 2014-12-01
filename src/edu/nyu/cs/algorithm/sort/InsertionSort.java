package edu.nyu.cs.algorithm.sort;

public class InsertionSort {
    
    private InsertionSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a) {
        byte key = 0;
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }
    
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        T key = null;
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

}
