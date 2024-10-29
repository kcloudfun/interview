package com.lk.interview.base.stringTest;

/**
 * String类为什么被设计为不可变类？
 * （严格来说没有必然的原因，只能聊聊设计成这样有什么优点，但这话不太适合直接给面试官讲，比较轴）
 * 优点：
 * 1.不可修改之后安全性高，不会被恶意利用，比如文件路径、网路链接等关键场景；
 * 2.不可修改之后线程安全，在多线程环境性能更好；
 * 3.不可修改之后哈希值也不会变，然后string也设计了hashcode缓存机制，这样在多次调用string的hashcode方法时速度也更快。由于哈希值也被用于像hashmap、hashset这些很常见场景，所以也更加方便。
 */
public class A {
}
