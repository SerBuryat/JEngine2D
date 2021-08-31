package com.thundertech.jengine2d.app;

import com.thundertech.jengine2d.view.ApplicationWindow;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.thundertech.jengine2d")
public class JEngine2DApp extends AbstractJEngine2DApp {

    @Autowired
    private ApplicationWindow applicationWindow;

    private int windowWidth = 800;
    private int windowHeight = 600;

    @Override
    public void start(Stage stage) {
        stage.setWidth(windowWidth);
        stage.setHeight(windowHeight);
        applicationWindow.loadAndShow(stage);
    }

    public static void main(String[] args) {
        launchApp(args);
    }

}
