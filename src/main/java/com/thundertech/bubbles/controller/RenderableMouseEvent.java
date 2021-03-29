package com.thundertech.bubbles.controller;

import com.thundertech.bubbles.view.Renderable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class RenderableMouseEvent implements EventHandler<MouseEvent> {
    private static final List<Renderable> RENDERABLES = new ArrayList<>();

    @Override
    public void handle(MouseEvent mouseEvent) {
        RENDERABLES.forEach(renderable -> renderable.handle(mouseEvent));
    }

    /**Add observer **/
    public static void ADD_RENDERABLE(Renderable renderable) {
        RENDERABLES.add(renderable);
    }

    public static void ADD_RENDERABLE(List<Renderable> renderables) {
        RENDERABLES.addAll(renderables);
    }

    public static List<Renderable> GET_RENDERABLES() {
        return RENDERABLES;
    }
}
