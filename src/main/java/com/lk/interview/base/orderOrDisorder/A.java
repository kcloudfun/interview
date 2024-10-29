package com.lk.interview.base.orderOrDisorder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * set无序，treeSet有序？
 * 实际两者说的不是一个概念。list有序set无序，说的是插入的顺序，虽然这个说法也比较笼统
 * （LinkedHashSet是基于双向链表实现的，也是有序的）。
 * treeSet有序指的是支持排序，并且放入时候就排好了。
 */
public class A {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(4);
        //插入顺序和输出顺序不一致（无序）
        for (Object o : treeSet) {
            System.out.println(o);
        }

        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(0);
        linkedHashSet.add(3);
        linkedHashSet.add(2);
        //双向链表，插入顺序和输出顺序一致（有序）
        for (Object o : linkedHashSet) {
            System.out.println(o);
        }

        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(0);
        hashSet.add(3);
        hashSet.add(2);
        //插入顺序和输出顺序不一致（无序）
        for (Object o : hashSet) {
            System.out.println(o);
        }
    }
}
