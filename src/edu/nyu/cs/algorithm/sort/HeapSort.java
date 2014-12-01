package edu.nyu.cs.algorithm.sort;

import edu.nyu.cs.algorithm.util.Utility;

public class HeapSort {
    
    private HeapSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a) {
        int heapSize = a.length;
        buildMaxHeap(a, heapSize);
        for (int i = a.length - 1; i > 0; i--) {
            Utility.exchange(a, i, 0);
            heapSize = heapSize - 1;
            maxHeapifyRecursive(a, 0, heapSize);
        }
    }
    
    private static void buildMaxHeap(byte[] a, final int heapSize) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapifyIterative(a, i, heapSize);
        }
    }
    
    private static void maxHeapifyRecursive(byte[] a, int i, final int heapSize) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        if (leftChild < heapSize && a[leftChild] > a[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && a[rightChild] > a[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            Utility.exchange(a, i, largest);
            maxHeapifyRecursive(a, largest, heapSize);
        }
    }
    
    private static void maxHeapifyIterative(byte[] a, int i, final int heapSize) {
        int leftChild = 0;
        int rightChild = 0;
        int largest = 0;
        while (i < heapSize) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largest = i;
            if (leftChild < heapSize && a[leftChild] > a[largest]) {
                largest = leftChild;
            }
            if (rightChild < heapSize && a[rightChild] > a[largest]) {
                largest = rightChild;
            }
            if (largest != i) {
                Utility.exchange(a, i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }
    
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        int heapSize = a.length;
        buildMaxHeap(a, heapSize);
        for (int i = a.length - 1; i > 0; i--) {
            Utility.exchange(a, i, 0);
            heapSize = heapSize - 1;
            maxHeapifyIterative(a, 0, heapSize);
        }
    }
    
    private static <T extends Comparable<? super T>> void buildMaxHeap(T[] a, final int heapSize) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapifyRecursive(a, i, heapSize);
        }
    }
    
    private static <T extends Comparable<? super T>> void maxHeapifyRecursive(
            T[] a, int i, final int heapSize) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;
        if (leftChild < heapSize && a[leftChild].compareTo(a[largest]) > 0) {
            largest = leftChild;
        }
        if (rightChild < heapSize && a[rightChild].compareTo(a[largest]) > 0) {
            largest = rightChild;
        }
        if (largest != i) {
            Utility.exchange(a, i, largest);
            maxHeapifyRecursive(a, largest, heapSize);
        }
    }
    
    private static <T extends Comparable<? super T>> void maxHeapifyIterative(
            T[] a, int i, final int heapSize) {
        int leftChild = 0;
        int rightChild = 0;
        int largest = 0;
        while (i < heapSize) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largest = i;
            if (leftChild < heapSize && a[leftChild].compareTo(a[largest]) > 0) {
                largest = leftChild;
            }
            if (rightChild < heapSize && a[rightChild].compareTo(a[largest]) > 0) {
                largest = rightChild;
            }
            if (largest != i) {
                Utility.exchange(a, i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

}
