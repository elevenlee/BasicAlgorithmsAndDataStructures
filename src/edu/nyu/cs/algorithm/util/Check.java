package edu.nyu.cs.algorithm.util;

public class Check {

    private Check() {
        throw new AssertionError();
    }
    
    public static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }
    
    public static <T> void nullCheck(T arg, String name) {
        if (arg == null) {
            throw new NullPointerException(name + ": " + arg);
        }
    }
    
    public static void emptyCheck(String arg, String name) {
        if (arg.equals("")) {
            throw new IllegalArgumentException(name + ": " + arg + " empty!");
        }
    }
    
}
