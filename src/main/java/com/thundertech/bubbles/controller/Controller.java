package com.thundertech.bubbles.controller;

import com.thundertech.bubbles.model.Sprite;
import com.thundertech.bubbles.view.Render;
import com.thundertech.bubbles.view.Renderable;
import com.thundertech.bubbles.view.Window;
import javafx.scene.image.Image;

public class Controller {
    private final Window window;
    private final Render render;

    public Controller(Window window, Render render) {
        this.window = window;
        this.render = render;
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

        this.renderScene();
    }

    public void renderScene() {
        this.render.clear();
        render.render(RenderableMouseEvent.GET_RENDERABLES());
    }
}
