package com.thundertech.jengine2d.controller;

import com.thundertech.jengine2d.view.render.*;
import com.thundertech.jengine2d.model.sprite.Sprite;
import com.thundertech.jengine2d.view.Window;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class JEngineController implements RenderableEventsListener {
    private final Window window;
    private final Render render;
    public final static RenderableEventManager renderableEventManager = new RenderableEventManager();
    public final static RenderableMouseEvent renderableMouseEvent = new RenderableMouseEvent();
    public static final List<SpriteController> sprites = new ArrayList<>();

    public JEngineController(Window window, Render render) {
        this.window = window;
        this.render = render;
        renderableEventManager.addEventListener(this);
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
        SpriteController spriteController = new SpriteController(x, y, width, height, image);
        sprites.add(spriteController);
        return spriteController;
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
