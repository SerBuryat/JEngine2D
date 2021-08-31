package com.thundertech.jengine2d.app;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * This class encapsulate <b>Spring Context</b> initialization inside
 * <b>JavaFx</b> application.
 * <p>
 * After extending from <i>this class</i>, you can use <i><b>@Autowired</b></i>
 * in your own <i><b>Application</b></i> class.
 * **/
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
