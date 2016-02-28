package wr.leetcode.algo.Linkedin;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 实现两个函数: H() and O(), 这两个函数会被多线程调用。当一个线程调用H或O时
 * ，如果当前已经有至少两个线程call H和一个线程call O。那么让两个call H和一个
 * call O的线程返回（产生一个水分子），其他的都block。
 */

class H2OProducer {

    /**
     * Semaphore could be initialized to be 0, requires a release to be available
     */
    Semaphore semH = new Semaphore(0);
    Semaphore semO = new Semaphore(0);

    public void h(){
        semH.release();
        try {
            semO.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void o() {
        try {
            semH.acquire(2);
        } catch (InterruptedException e) {
        }
        semO.release(2);
        System.out.println("Water made!");
        System.out.flush();
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        H2OProducer h2OProducer = new H2OProducer();

        System.out.println("start!");
        for (int i = 0; i <= 3; i ++) {
            for (int j = 1; j <= 5; ++j) {
                service.submit(h2OProducer::h);
                service.submit(h2OProducer::o);
                service.submit(h2OProducer::h);
            }
            service.submit(h2OProducer::h);
        }
        System.out.println("finish!");
    }

}
