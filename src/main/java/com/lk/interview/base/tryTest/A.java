package com.lk.interview.base.tryTest;

/**
 * 很久之前碰到的面试题，finally如果有return会咋样。
 * 首先说try-catch-finally结构，finally里面代码无论如何都会被执行，一般用于文件流关闭。
 * 然后再说return，也是必然执行，也没有什么特殊的。下面测试方法，无论是否报错，结果都是2
 */
public class A {

    public static String test(String str){
        try {
            //这里是随便调用一个string的方法，用来触发空指针异常
            str.split("1");
            return "1";
        } catch (Exception e) {
            return "3";
        } finally {
            return "2";
        }
    }

    public static void main(String[] args) {
        System.out.println(test("1"));
        System.out.println(test(null));
    }
}
