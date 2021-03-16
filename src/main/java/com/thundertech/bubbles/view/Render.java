package com.thundertech.bubbles.view;

import com.thundertech.bubbles.model.Bubble;
import javafx.scene.canvas.GraphicsContext;

public class Render {
    private final GraphicsContext graphics;

    public Render(GraphicsContext graphics) {
        this.graphics = graphics;
    }

    public void render(Renderable renderable) {
        renderable.render(this.graphics);
    }

    public void clear(Bubble bubble) {
        double x = bubble.getBoundary().getMinX();
        double y = bubble.getBoundary().getMinY();

        int diameter = bubble.getDiameter();
        graphics.clearRect(x,y,diameter,diameter);
    }

    public void pick(Bubble bubble) {
        double x = bubble.getBoundary().getMinX();
        double y = bubble.getBoundary().getMinY();
        int diameter = bubble.getDiameter();

        graphics.strokeRect(x, y, diameter, diameter);
    }
}
