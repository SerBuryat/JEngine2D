package com.thundertech.jengine2d.controller;

import com.thundertech.jengine2d.view.render.*;
import com.thundertech.jengine2d.model.Sprite;
import com.thundertech.jengine2d.view.Window;
import javafx.scene.image.Image;

public class Controller implements RenderableEventsListener {
    private final Window window;
    private final Render render;

    public Controller(Window window, Render render) {
        this.window = window;
        this.render = render;
        RenderableEventManager.addEventListener(this);
    }

    public void start() {
        Sprite blueBubble = new Sprite(0,50,50,50,
                                            new Image("/bubbles/blue.png"));

        Sprite redBubble = new Sprite(50,75,50,50,
                new Image("/bubbles/red.png"));

        Sprite greenBubble = new Sprite(100,150,50,50,
                new Image("/bubbles/green.png"));

        Sprite yellowBubble = new Sprite(200,100,50,50,
                new Image("/bubbles/yellow.png"));
    }

    public void renderScene() {
        this.render.clear();
        render.render(RenderableMouseEvent.GET_RENDERABLES());
    }

    @Override
    public void renderableObjectChanged(Renderable renderable) {
        renderScene();
    }
}
