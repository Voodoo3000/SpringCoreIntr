package com.epam.jmp.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class E implements MethodReplacer {
    private F fClass;

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Hello from E Class!");
        return o;
    }

    public F getfClass() {
        return fClass;
    }

    public void setfClass(F fClass) {
        this.fClass = fClass;
    }
}
