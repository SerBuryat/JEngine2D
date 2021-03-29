package com.thundertech.bubbles.view;

import javafx.scene.canvas.GraphicsContext;

public class Render {
    private final GraphicsContext graphics;

    public Render(GraphicsContext graphics) {
        this.graphics = graphics;
    }

    public void render(Renderable renderable) {
        renderable.render(this.graphics);
    }
}
