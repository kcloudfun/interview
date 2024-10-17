package com.lk.interview.multiThreading.threadCreate;

import java.util.concurrent.Callable;

/**
 * 实现Callable
 */
public class CallableDemo implements Callable {

    @Override
    public Object call() {
        System.out.println("我是callable创建");
        return "我是Callable返回结果";
    }
}
