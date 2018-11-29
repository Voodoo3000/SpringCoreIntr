package com.epam.jmp.bean;

import org.apache.log4j.Logger;

public class B {
    private static final Logger LOGGER = Logger.getLogger(B.class);
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
        LOGGER.info("Hello from B class!");
    }
}
