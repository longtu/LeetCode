package wr.leetcode.algo.Facebook;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * implement RWLock using normal lock
 */

public class RWLock {
    Lock writeLock = new ReentrantLock();
    Lock readCountLock = new ReentrantLock();
    int readCount = 0;

    public void rLock() {
        readCountLock.lock();
        if(++readCount == 1) {
            writeLock.lock();
        }
        readCountLock.unlock();
    }

    public void rUnclok() {
        readCountLock.lock();
        if(--readCount == 0) {
            writeLock.unlock();
        }
        readCountLock.unlock();
    }

    public void wLock() {
        writeLock.lock();
    }

    public void wUnlock() {
        writeLock.unlock();
    }

    public static void main(String[] args) {
        HashMap map;
    }
}