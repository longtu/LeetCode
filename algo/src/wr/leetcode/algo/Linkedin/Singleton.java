package wr.leetcode.algo.Linkedin;

public class Singleton {
    private Singleton() {}
    private static Singleton instance = null;

    public synchronized static Singleton instance() {
        if ( null == instance ) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton anotherInstance() {
        synchronized(Singleton.class) {
            if ( null == instance ) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}