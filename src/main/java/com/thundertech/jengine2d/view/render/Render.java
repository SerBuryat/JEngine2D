package com.thundertech.jengine2d.view.render;

import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Render {
    private final GraphicsContext graphics;

    @Autowired
    public Render(GraphicsContext graphics) {
        this.graphics = graphics;
    }

    public void render(Renderable renderable) {
        renderable.render(this.graphics);
    }

    public void render(List<Renderable> renderables) {
        renderables.forEach(this::render);
    }

    public void clear() {
        graphics.clearRect(0,0,800,600);
    }
}
