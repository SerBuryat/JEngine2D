package com.thundertech.jengine2d.view.render;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RenderableMouseEvent implements EventHandler<MouseEvent> {
    private final List<Renderable> renderables = new ArrayList<>();

    @Override
    public void handle(MouseEvent mouseEvent) {
        renderables.forEach(renderable -> renderable.handle(mouseEvent));
    }

    public void addRenderable(Renderable renderable) {
        this.renderables.add(renderable);
    }

    public List<Renderable> getRenderables() {
        return renderables;
    }
}
