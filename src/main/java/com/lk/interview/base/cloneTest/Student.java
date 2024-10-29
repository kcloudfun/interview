package com.lk.interview.base.cloneTest;

public class Student extends Person implements Cloneable {
    private String className;
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public Student clone() {
        Student clone = new Student();
        clone.setName(null);
        clone.setClassName(this.className);
        // 如果直接 Student clone = （Student）super.clone()那就是深拷贝了，样例参照Teacher
        return clone;
    }
}
