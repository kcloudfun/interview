package com.lk.interview.base.cloneTest;

import java.math.BigDecimal;

public class Teacher extends Person implements Cloneable {

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public Teacher clone() {
        try {
            return (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
