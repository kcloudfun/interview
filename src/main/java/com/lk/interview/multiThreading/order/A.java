package com.lk.interview.multiThreading.order;

public class A {

    public static void main(String[] args) throws InterruptedException {
        SayThread sayThread1 = new SayThread();
        sayThread1.setI(1);
        SayThread sayThread2 = new SayThread();
        sayThread2.setI(2);
        SayThread sayThread3 = new SayThread();
        sayThread3.setI(3);
        SayThread sayThread4 = new SayThread();
        sayThread4.setI(4);
        SayThread sayThread5 = new SayThread();
        sayThread5.setI(5);
        SayThread sayThread6 = new SayThread();
        sayThread6.setI(6);

        //正常start，无法保证执行顺序
        sayThread1.start();
        sayThread2.start();
        sayThread3.start();
        sayThread4.start();
        sayThread5.start();
        sayThread6.start();

        //使用join等待上一个线程结束
//        sayThread1.start();
//        sayThread1.join();
//        sayThread2.start();
//        sayThread2.join();
//        sayThread3.start();
//        sayThread3.join();
//        sayThread4.start();
//        sayThread4.join();
//        sayThread5.start();
//        sayThread5.join();
//        sayThread6.start();

        //还有使用wait-notify、CountDownLatch、单个线程的线程池等等实现的，本质上是人为控制线程调度了，鄙人都觉得很丑陋，写出的代码也没有实际意义，实际这么强的先后，不如放在一个线程里面处理完。
        //如果确实需要分段处理，可以使用CountDownLatch
    }
}
