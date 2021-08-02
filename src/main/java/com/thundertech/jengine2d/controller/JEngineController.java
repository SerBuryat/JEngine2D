package com.thundertech.jengine2d.controller;

import com.thundertech.jengine2d.view.render.*;
import javafx.scene.image.Image;

public class JEngineController implements RenderableEventsListener {
    private final Render render;
    public RenderableEventManager renderableEventManager;
    public RenderableMouseEvent renderableMouseEvent;

    public JEngineController(Render render,
                             RenderableEventManager renderableEventManager,
                             RenderableMouseEvent renderableMouseEvent) {
        this.render = render;
        this.renderableEventManager = renderableEventManager;
        this.renderableMouseEvent = renderableMouseEvent;
        this.renderableEventManager.addEventListener(this);
    }

    public void start() {
        SpriteController blueBubble = createSprite(0,50,50,50,
                new Image("/bubbles/blue.png"));

        SpriteController redBubble = createSprite(50,75,50,50,
                new Image("/bubbles/red.png"));

        SpriteController greenBubble = createSprite(100,150,50,50,
                new Image("/bubbles/green.png"));

        SpriteController yellowBubble = createSprite(200,100,50,50,
                new Image("/bubbles/yellow.png"));
    }

    public SpriteController createSprite(int x, int y, int width, int height, Image image) {
        return new SpriteController(x, y, width, height, image,renderableEventManager,renderableMouseEvent);
    }

    public void renderScene() {
        this.render.clear();
        render.render(renderableMouseEvent.getRenderables());
    }

    @Override
    public void renderableObjectChanged(Renderable renderable) {
        renderScene();
    }
}
