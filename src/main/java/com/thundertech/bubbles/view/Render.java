package com.thundertech.bubbles.view;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Render {
    private final GraphicsContext graphics;

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
