package com.lk.interview.base.cloneTest;

import java.math.BigDecimal;

/**
 * java对象克隆怎么使用，是深拷贝还是浅拷贝？
 * 实现Cloneable接口重写clone方法。是深拷贝还是浅拷贝取决于你重写clone方法时的代码逻辑
 */
public class A {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("xueA");
        student1.setClassName("class1");
        Student student2 = student1.clone();
        //name是父对象的属性，为null说明没拷贝上，浅拷贝
        System.out.println(student2.getName());

        Teacher teacher1 = new Teacher();
        teacher1.setName("xingming");
        teacher1.setSalary(new BigDecimal(1));
        Teacher teacher2 = teacher1.clone();
        //name是父对象的属性，和1值一样说明拷贝上了，深拷贝
        System.out.println(teacher2.getName());
    }
}
