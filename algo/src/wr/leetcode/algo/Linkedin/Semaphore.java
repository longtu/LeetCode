package wr.leetcode.algo.Linkedin;

public class Semaphore {
    int signal = 0;
    int bound;

    public Semaphore (int initial ) {
        this.bound = initial;
    }

    public synchronized void aquire() throws InterruptedException {
        while(signal == 0) {
            this.wait();
        }
        signal--;
        notify();
    }

    public synchronized void release() {




        signal++;
        notify(); //notifys the first thread
        //notifyAll(); notifies all threads
    }
}
