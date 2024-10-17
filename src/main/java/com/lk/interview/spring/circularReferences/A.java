package com.lk.interview.spring.circularReferences;

/**
 * UserController依赖LoginController，LoginController依赖UserController，构成循环依赖。
 * SpringBoot2.7.5之后取消了对循环依赖的默认支持，需开发人员主动开启配置spring.main.allow-circular-references。
 * 实际上报错提示已经出了解决方案:
 * Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.
 */
public class A {

}
