package com.lk.interview.multiThreading.threadCreate;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() {
        System.out.println("我是callable创建");
        return "返回结果";
    }
}
