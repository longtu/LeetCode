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
 * This lock is not reentrant.
 * see http://tutorials.jenkov.com/java-concurrency/locks.html
 * for reentrant defination
 *
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

/**
 * Reentrant lock implementation
 */

class MutexV3 {
    boolean isTaken = false;
    Thread takingThread = null;
    //this is required otherwise one unlock will unlock all lock() positions
    int lockedStackTime = 0;

    public synchronized void lock() throws InterruptedException {
        while (isTaken && takingThread != Thread.currentThread()) {
            //this line will cause currentThread to give out the intrinsic lock
            this.wait();
        }
        isTaken = true;
        takingThread = Thread.currentThread();
        lockedStackTime++;
    }

    public synchronized void unlock() {
        if(Thread.currentThread() == this.takingThread){
            if(--lockedStackTime == 0) {
                isTaken = false;
                takingThread = null;
                this.notifyAll();
            }
        }
    }
}
