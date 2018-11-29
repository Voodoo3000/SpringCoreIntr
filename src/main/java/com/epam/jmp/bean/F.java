package com.epam.jmp.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class F implements InitializingBean, DisposableBean {
    private static final Logger LOGGER = Logger.getLogger(F.class);

    public void init() {
        LOGGER.info("init");
    }

    public void close() {
        LOGGER.info("close");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.info("destroy");
    }

    public void print() {
        LOGGER.info("Just print method of F class");
    }
}
