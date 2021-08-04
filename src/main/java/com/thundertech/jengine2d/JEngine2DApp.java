package com.thundertech.jengine2d;

import com.thundertech.jengine2d.config.SpringConfig;
import com.thundertech.jengine2d.controller.JEngineController;
import com.thundertech.jengine2d.view.Window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JEngine2DApp extends Application {

    @Override
    public void start(Stage stage) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Window window = context.getBean(Window.class);
        JEngineController jEngineController = context.getBean(JEngineController.class);

        loadScene(stage, window.getPane());

        jEngineController.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void loadScene(Stage stage, Pane pane) {
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("[JEngine2D]");
        stage.setResizable(false);
        stage.show();
    }

}
