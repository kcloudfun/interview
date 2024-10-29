package com.lk.interview.jvm.stackOverflowErrorTest;

/**
 * 栈溢出，指栈空间耗尽，通常是不合理递归调用。报错信息也比较明显，可在异常堆栈信息里面看到某一个方法重复出现
 */
public class A {

    public static void recursiveMethod(int depth) {
        depth++; // 递增递归深度
        System.out.println("Recursive Depth: " + depth);
        recursiveMethod(depth); // 递归调用自身
    }

    public static void main(String[] args) {
        recursiveMethod(0);
    }
}
