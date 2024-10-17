package com.lk.interview.multiThreading.order;

public class SayThread extends Thread {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("我是线程:"+i);
    }
}
