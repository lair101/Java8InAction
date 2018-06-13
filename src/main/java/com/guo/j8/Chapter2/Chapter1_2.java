package com.guo.j8.Chapter2;

import org.junit.jupiter.api.Test;

public class Chapter1_2 {

    /**
     * Runnable interface implementation
     */
    public void runner(){

        //old way to start a runner
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("this is the thread :"+ Thread.currentThread().getId());
                    }
                }
        );

        //new way to implement
        Thread t2 = new Thread(
                () -> {
                    System.out.println("this is the thread :"+ Thread.currentThread().getId());
                }
        );

        t1.start();
        t2.start();

    }

    @Test
    public void test1(){
        Chapter1_2 test = new Chapter1_2();
        test.runner();
    }

}
