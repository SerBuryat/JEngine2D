package com.thundertech.jengine2d;

import com.thundertech.jengine2d.controller.JEngineController;
import com.thundertech.jengine2d.view.Window;
import com.thundertech.jengine2d.view.render.Render;
import com.thundertech.jengine2d.view.render.RenderableEventManager;
import com.thundertech.jengine2d.view.render.RenderableMouseEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class JEngine2DApp extends Application {

    @Override
    public void start(Stage stage) {
        RenderableEventManager renderableEventManager = new RenderableEventManager();
        RenderableMouseEvent renderableMouseEvent = new RenderableMouseEvent();

        Window window = new Window(800,600,renderableMouseEvent);
        Render render = new Render(window.getCanvas().getGraphicsContext2D());
        JEngineController jEngineController =
                new JEngineController(render, renderableEventManager, renderableMouseEvent);

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
