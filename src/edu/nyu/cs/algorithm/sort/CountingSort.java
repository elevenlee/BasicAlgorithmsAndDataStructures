package edu.nyu.cs.algorithm.sort;

public class CountingSort {
    
    private CountingSort() {
        throw new AssertionError();
    }
    
    public static void sort(byte[] a, byte[] b, byte k) {
        int[] c = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            c[a[i]] = c[a[i]] + 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {   // reverse order is important, guarantee stable
            c[a[i]] = c[a[i]] - 1;
            b[c[a[i]]] = a[i];
        }
    }

}
