package com.epam.jmp.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class E implements MethodReplacer {
    private static final Logger LOGGER = Logger.getLogger(E.class);
    private F fClass;

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        LOGGER.info("Hello from E Class!");
        return o;
    }

    public F getfClass() {
        return fClass;
    }

    public void setfClass(F fClass) {
        this.fClass = fClass;
    }
}
