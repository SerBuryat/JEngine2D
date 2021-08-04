package com.thundertech.jengine2d.view;

import com.thundertech.jengine2d.view.render.RenderableMouseEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class Window  {
    private final Pane pane;
    private final Canvas canvas;
    @Setter
    private int width = 800;
    @Setter
    private int height = 600;

    private final RenderableMouseEvent renderableMouseEvent;

    @PostConstruct
    public void init() {
        this.canvas.setOnMousePressed(renderableMouseEvent);
        this.canvas.setOnMouseDragged(renderableMouseEvent);
    }

    @Autowired
    public Window(RenderableMouseEvent renderableMouseEvent) {
        this.canvas = new Canvas(width, height);
        this.pane = new BorderPane(this.canvas);
        this.renderableMouseEvent = renderableMouseEvent;
    }
}
