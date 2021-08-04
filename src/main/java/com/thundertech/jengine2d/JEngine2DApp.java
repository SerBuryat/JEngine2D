package com.thundertech.jengine2d;

import com.thundertech.jengine2d.controller.JEngineController;
import com.thundertech.jengine2d.view.Window;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class JEngine2DApp extends AbstractJEngine2DApp {

    @Autowired
    private JEngineController jEngineController;
    @Autowired
    private Window window;

    @Override
    public void start(Stage stage) {
        window.loadAndShow(stage);
        jEngineController.start();
    }

    public static void main(String[] args) {
        launchApp(args);
    }

}
