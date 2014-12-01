package edu.nyu.cs.algorithm.sort;

import edu.nyu.cs.algorithm.util.Utility;

public class QuickSort {
    
    private QuickSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a) {
        sortHelper(a, 0, a.length - 1);
    }
    
    private static void sortHelper(byte[] a, int low, int high) {
        int q = 0;
        if (low < high) {
            q = partition(a, low, high);
            sortHelper(a, low, q - 1);
            sortHelper(a, q + 1, high);
        }
    }
    
    private static int partition(byte[] a, int low, int high) {
        byte key = a[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (a[i] <= key) {
                j = j + 1;
                Utility.exchange(a, i, j);
            }
        }
        Utility.exchange(a, j + 1, high);
        return j + 1;
    }
    
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sortHelper(a, 0, a.length - 1);
    }
    
    private static <T extends Comparable<? super T>> void sortHelper(T[] a, int low, int high) {
        int q = 0;
        if (low < high) {
            q = partition(a, low, high);
            sortHelper(a, low, q - 1);
            sortHelper(a, q + 1, high);
        }
    }
    
    private static <T extends Comparable<? super T>> int partition(T[] a, int low, int high) {
        T key = a[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (a[i].compareTo(key) <= 0) {
                j = j + 1;
                Utility.exchange(a, i, j);
            }
        }
        Utility.exchange(a, j + 1, high);
        return j + 1;
    }

}
