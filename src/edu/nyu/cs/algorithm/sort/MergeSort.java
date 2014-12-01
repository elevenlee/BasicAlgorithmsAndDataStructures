package edu.nyu.cs.algorithm.sort;

public class MergeSort {
    
    private MergeSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a) {
        sortHelper(a, 0, a.length - 1);
    }
    
    private static void sortHelper(byte[] a, int low, int high) {
        int middle = 0;
        if (low < high) {
            middle = (low + high) / 2;
            sortHelper(a, low, middle);
            sortHelper(a, middle + 1, high);
            merge(a, low, middle, high);
        }
    }
    
    private static void merge(byte[]a , int low, int middle, int high) {
        int leftLength = middle - low + 1;
        int rightLength = high - middle;
        byte[] left = new byte[leftLength + 1];
        byte[] right = new byte[rightLength + 1];
        for (int i = 0; i < leftLength; i++) {
            left[i] = a[low + i];
        }
        for (int i = 0; i < rightLength; i++) {
            right[i] = a[middle + i + 1];
        }
        left[leftLength] = right[rightLength] = Byte.MAX_VALUE;
        for (int i = 0, j = 0, k = low; k <= high; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i = i + 1;
            } else {
                a[k] = right[j];
                j = j + 1;
            }
        }
    }
    
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sortHelper(a, 0, a.length - 1);
    }
    
    private static <T extends Comparable<? super T>> void sortHelper(T[] a, int low, int high) {
        int middle = 0;
        if (low < high) {
            middle = (low + high) / 2;
            sortHelper(a, low, middle);
            sortHelper(a, middle + 1, high);
            merge(a, low, middle, high);
        }
    }
    
    private static <T extends Comparable<? super T>> void merge(
            T[] a, int low, int middle, int high) {
        int leftLength = middle - low + 1;
        int rightLength = high - middle;
        @SuppressWarnings("unchecked")
        T[] left = (T[]) new Comparable[leftLength];
        @SuppressWarnings("unchecked")
        T[] right = (T[]) new Comparable[rightLength];
        for (int i = 0; i < leftLength; i++) {
            left[i] = a[low + i];
        }
        for (int i = 0; i < rightLength; i++) {
            right[i] = a[middle + i + 1];
        }
        int i = 0;
        int j = 0;
        int k = low;
        for (; i < leftLength && j < rightLength; k++) {
            if (left[i].compareTo(right[j]) <= 0) {
                a[k] = left[i];
                i = i + 1;
            } else {
                a[k] = right[j];
                j = j + 1;
            }
        }
        if (i >= leftLength) {
            for (; j < rightLength; k++) {
                a[k] = right[j];
                j = j + 1;
            }
        } else if (j >= rightLength){
            for (; i < leftLength; k++) {
                a[k] = left[i];
                i = i + 1;
            }
        }
    }

}
