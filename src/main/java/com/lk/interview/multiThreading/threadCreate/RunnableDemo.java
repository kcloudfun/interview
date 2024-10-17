package com.lk.interview.multiThreading.threadCreate;

/**
 * 实现Runnable
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("我是runnable创建");
    }
}
