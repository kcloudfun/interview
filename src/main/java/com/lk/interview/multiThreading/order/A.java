package com.lk.interview.multiThreading.order;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如何保证多个线程之间按顺序依次执行。
 * 这是一个比较没营养的问题，都多线程了，还人工去干预执行顺序？为什么不把有顺序逻辑的代码放在同一个线程处理？
 * 无奈面试官问了，所以还是记录一下。
 * 实质就是在控制上一个线程执行结束后才执行下一个线程，不是什么特别高明方法。
 */
public class A {

    /**
     * 正常不加控制的线程执行
     */
    public static void noOrder(){
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
    }

    /**
     * 使用join控制。join的官方解释是Waits for this thread to die.也就是等当前线程结束。
     * 可以在主线程里面使用，也可以在线程run方法（call方法）里面使用，在线程run方法里面使用要求传入指定线程对象即可，换了个位置，没啥特别的。
     * @throws InterruptedException
     */
    public static void useJoin() throws InterruptedException {
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

        //使用join等待上一个线程结束。使用join会强制要求处理线程中断异常
        sayThread1.start();
        sayThread1.join();
        sayThread2.start();
        sayThread2.join();
        sayThread3.start();
        sayThread3.join();
        sayThread4.start();
        sayThread4.join();
        sayThread5.start();
        sayThread5.join();
        sayThread6.start();
    }

    /**
     * 使用多个CountDownLatch数值为1的计数器，只有当值为0时才确信前面的线程执行完了。
     */
    public static void useCountDownLatch(){
        CountDownLatch c1 = new CountDownLatch(1);
        //线程1是第一个执行，没有任何限制
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                c1.countDown();
                System.out.println("线程1执行了");
            }
        });
        CountDownLatch c2 = new CountDownLatch(1);
        //线程2需等线程1执行，也就是等c1为0.同时为了告知线程3它已执行，还需把c2减为0
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c1.await();
                    System.out.println("线程2执行了");
                    c2.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //线程3需判断线程2是否已执行，也就是c2是否为0
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c2.await();
                    System.out.println("线程3执行了");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //这里没继续往后加了，如果还有线程4、5、6，那必然还会有c3、4、5

        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 使用只有一条线程的线程池时，后交给线程池管理的线程都将在队列中等待被依次执行，所以是有顺序的（实际把多线程变为了单线程，所以说这问题本身没有营养）
     */
    public static void usePool(){
        //创建一个只有一条线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        executorService.execute(sayThread1);
        executorService.execute(sayThread2);
        executorService.execute(sayThread3);
        executorService.execute(sayThread4);
        executorService.execute(sayThread5);
        executorService.execute(sayThread6);
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        noOrder();
        Thread.sleep(5000);
        System.out.println("useJoin分割线<<<<<<<<<<<<");
        useJoin();
        Thread.sleep(5000);
        System.out.println("useCountDownLatch分割线<<<<<<<<<<<<");
        useCountDownLatch();
        Thread.sleep(5000);
        System.out.println("usePool分割线<<<<<<<<<<<<");
        usePool();

    }
}
