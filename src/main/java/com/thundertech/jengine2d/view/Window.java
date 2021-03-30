package com.thundertech.jengine2d.view;

import com.thundertech.jengine2d.view.render.RenderableMouseEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Window  {
    private final Pane pane;
    private final Canvas canvas;
    private int width;
    private int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new Canvas(width, height);
        this.canvas.setOnMousePressed(new RenderableMouseEvent());
        this.canvas.setOnMouseDragged(new RenderableMouseEvent());
        this.pane = new BorderPane(this.canvas);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Pane getPane() {
        return pane;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
