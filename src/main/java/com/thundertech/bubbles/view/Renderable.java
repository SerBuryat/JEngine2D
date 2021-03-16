package com.thundertech.bubbles.view;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public interface Renderable extends EventHandler<MouseEvent> {
    void render(GraphicsContext graphics);
    @Override
    void handle(MouseEvent mouseEvent);
}
