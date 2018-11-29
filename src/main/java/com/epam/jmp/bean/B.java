package com.epam.jmp.bean;

public class B {
    private A aClass;

    public B(A aClass) {
        this.aClass = aClass;
    }

    public A getaClass() {
        return aClass;
    }

    public void setaClass(A aClass) {
        this.aClass = aClass;
    }

    public void methodForEClass() {
        System.out.println("Hello from B class!");
    }
}
