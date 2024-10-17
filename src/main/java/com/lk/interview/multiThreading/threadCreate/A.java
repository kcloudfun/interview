package com.lk.interview.multiThreading.threadCreate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 线程创建的几种方式：1.继承Thread；2.实现Runnable；3.实现Callable。
 */
public class A {

    public static void main(String[] args) {
        //继承Thread后直接new一个
        ThreadDemo threadDemo1 = new ThreadDemo();

        //实现Runnable后一般还是借助Thread创建
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread threadDemo2 = new Thread(runnableDemo);

        //实现Callable相对更曲折，因为Thread构造函数不支持使用Callable，但可以先构造FutureTask
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask<>(callableDemo);
        Thread threadDemo3 = new Thread(futureTask);

        //均是调用start方法后，线程进入就绪状态，等待cpu调度执行
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();

        //Callable线程，上面start且线程执行完毕后，就能通过futureTask.get()获取到返回值。但会强制要求处理线程中断异常和线程执行异常
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //若不执行上面Thread.start()方法，还可以将线程对象交给线程池执行，线程也会被执行起来
        ThreadDemo threadDemo5 = new ThreadDemo();
        RunnableDemo runnableDemo2 = new RunnableDemo();
        Thread threadDemo6 = new Thread(runnableDemo2);
        CallableDemo callableDemo2 = new CallableDemo();
        FutureTask futureTask2 = new FutureTask<>(callableDemo2);
        Thread threadDemo7 = new Thread(futureTask2);
        ExecutorService service = Executors.newFixedThreadPool(3);
        //execute方法只适用于Runnable，另Thread也实现了Runnable
        service.execute(threadDemo5);
        service.execute(threadDemo6);
        //submit同时适用于Callable、Runnable
        service.submit(threadDemo7);
        service.shutdown();
    }
}
