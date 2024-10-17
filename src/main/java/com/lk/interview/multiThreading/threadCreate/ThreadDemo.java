package com.lk.interview.multiThreading.threadCreate;

/**
 * 继承Thread
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("我是thread创建");
    }
}
