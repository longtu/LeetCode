package wr.leetcode.algo.Linkedin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ThreadSafeBlockingQueue<T> {
    private Queue<T> queue ;
    private Semaphore consume;
    private Semaphore produce;

    public ThreadSafeBlockingQueue (int capacity ) {
        this.queue = new LinkedList<>();
        consume = new Semaphore(0);
        produce = new Semaphore(capacity);
    }

    /** Retrieve and remove the head of the queue, waiting if no elements
     are present. */

    public synchronized T take() throws InterruptedException {
        consume.acquire();
        T ret = queue.poll();
        produce.release();
        return ret;
    }

    /** Add the given element to the end of the queue, waiting if necessary
     for space to become available. */
    public synchronized void put (T obj) throws InterruptedException {
        produce.acquire();
        queue.offer(obj);
        consume.release();
    };
}
