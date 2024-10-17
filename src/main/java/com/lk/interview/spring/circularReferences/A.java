package com.lk.interview.spring.circularReferences;

public class A {

    //UserController依赖LoginController，LoginController依赖UserController，构成循环依赖。SpringBoot2.7.5之后取消了对循环依赖的默认支持，需开发人员主动开启配置spring.main.allow-circular-references
    //实际上报错提示已经出了解决方案


}
