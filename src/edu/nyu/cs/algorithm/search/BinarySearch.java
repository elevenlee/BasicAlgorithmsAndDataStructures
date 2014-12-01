package edu.nyu.cs.algorithm.search;

public class BinarySearch {

    private BinarySearch() {
        throw new AssertionError();
    }
    
    public static int searchRecursive(byte[] a, byte key) {
        return searchRecursiveHelper(a, key, 0, a.length - 1);
    }
    
    private static int searchRecursiveHelper(byte[] a, byte key, int low, int high) {
        if (low > high) {
            return -1;
        } else {
            int middle = (low + high) / 2;
            if (a[middle] == key) {
                return middle;
            } else if ( a[middle] > key) {
                return searchRecursiveHelper(a, key, low, middle - 1);
            } else {
                return searchRecursiveHelper(a, key, middle + 1, high);
            }
        }
    }
    
    public static int searchIterative(byte[] a, byte key) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (a[middle] == key) {
                return middle;
            } else if (a[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
    
    public static <T extends Comparable<? super T>> int searchRecursive(T[] a, T key) {
        return searchRecursiveHelper(a, key, 0, a.length - 1);
    }
    
    private static <T extends Comparable<? super T>> int searchRecursiveHelper(
            T[] a, T key, int low, int high) {
        if (low > high) {
            return -1;
        } else {
            int middle = (low + high) / 2;
            if (a[middle].compareTo(key) == 0) {
                return middle;
            } else if (a[middle].compareTo(key) > 0) {
                return searchRecursiveHelper(a, key, low, middle - 1);
            } else {
                return searchRecursiveHelper(a, key, middle + 1, high);
            }
        }
    }
    
    public static <T extends Comparable<? super T>> int searchIterative(T[] a, T key) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (a[middle].compareTo(key) == 0) {
                return middle;
            } else if (a[middle].compareTo(key) > 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
    
}
