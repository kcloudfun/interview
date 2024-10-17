package com.lk.interview.multiThreading.threadCreate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class A {

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo();
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread threadDemo2 = new Thread(runnableDemo);
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask<>(callableDemo);
        Thread threadDemo3 = new Thread(futureTask);

        Long start = System.currentTimeMillis();
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
