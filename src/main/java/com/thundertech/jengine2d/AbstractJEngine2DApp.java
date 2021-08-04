package com.thundertech.jengine2d;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class AbstractJEngine2DApp extends Application {

    private static String[] savedArgs;

    protected ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = SpringApplication.run(getClass(), savedArgs);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    protected static void launchApp(String[] args) {
        AbstractJEngine2DApp.savedArgs = args;
        Application.launch(JEngine2DApp.class, args);
    }
}
