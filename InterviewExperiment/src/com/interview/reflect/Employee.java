package com.interview.reflect;

/**
 * Created by ysx on 2017/6/12.
 */
public class Employee extends Person implements TestInterface{

    private float salary;
    public int days;

    private Employee() {
        super(0, "");
    }

    public Employee(int age, String name, float salary) {
        super(age, name);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public void fly() {

    }
}
