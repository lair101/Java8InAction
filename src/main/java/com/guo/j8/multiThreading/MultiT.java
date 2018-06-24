package com.guo.j8.multiThreading;


import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用两个线程分别打印0-100之间的奇偶数。
 * 比如 有A，B两个线程；
 * A线程打印1，3，5，7，9 … 99
 * B线程打印0，2，4，6，8 … 100.
 * <p>
 * Java 5 approach
 */
public class MultiT {

    volatile int num = 1;

    //create two threads that each will print the num
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            int count = 0;
            while (count < 101) {
                count++;
                if (count % 2 == 1)
                    System.out.println(Thread.currentThread().getName() + "---->" + count);

            }

        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            int count = 0;
            while (count < 101) {
                count++;
                if (count % 2 == 0)
                    System.out.println(Thread.currentThread().getName() + "---->" + count);
            }
        }
    });

    //Java 7 approach

    public void threadsPrint() {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock reentrantLock = new ReentrantLock();


        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (num < 101) {
                    if (num % 2 == 0) {
                        reentrantLock.lock();
                        System.out.println(Thread.currentThread() + "--->" + num);
                        num++;
                        reentrantLock.unlock();
                    }

                }

            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (num < 101) {
                    if (num % 2 == 1) {
                        reentrantLock.lock();
                        System.out.println(Thread.currentThread() + "--->" + num);
                        num++;
                        reentrantLock.unlock();
                    }

                }

            }
        });

        executor.shutdown();
    }


    //Java 8 Future class usage

    public void newPrint() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock reentrantLock = new ReentrantLock();

        executor.submit(() -> {
            while (num < 101) {
                if (num % 2 == 0) {
                    reentrantLock.lock();
                    try {
                        System.out.println(Thread.currentThread() + ">>>>>" + num);
                        num++;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }

        });

        executor.submit(() -> {
            while (num < 101) {
                if (num % 2 == 1) {
                    reentrantLock.lock();
                    try {
                        System.out.println(Thread.currentThread() + ">>>>>" + num);
                        num++;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }

        });

        executor.shutdown();
    }


    public void start() {
        t1.start();
        t2.start();
    }


    @Test
    public void test1() {
        MultiT m = new MultiT();
        m.start();
    }

    @Test
    public void test2() {
        MultiT m = new MultiT();
        m.threadsPrint();
    }

    @Test
    public void test3(){
        MultiT m = new MultiT();
        m.newPrint();
    }
}
