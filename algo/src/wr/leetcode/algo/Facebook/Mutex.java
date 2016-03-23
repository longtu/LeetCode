package wr.leetcode.algo.Facebook;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Spin lock, bad for performance
 */
class MutexV1 {
    AtomicBoolean used = new AtomicBoolean(false);

    public void lock() {
        while (used.getAndSet(true));
    }


    public void unlock() {
        used.set(false);
    }
}

/**
 * Sleep lock using java intrinsic lock
 */

class MutexV2 {
    private boolean isLocked = false;

    public synchronized void lock()
            throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
