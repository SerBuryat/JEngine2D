package com.thundertech.jengine2d.view.render;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public interface Renderable extends EventHandler<MouseEvent> {
    void render(GraphicsContext graphics);
    @Override
    void handle(MouseEvent mouseEvent);
}
