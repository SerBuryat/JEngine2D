package com.thundertech.jengine2d.controller;

import com.thundertech.jengine2d.view.render.*;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JEngineController implements RenderableActionListener {
    private final Render render;
    public final RenderableActionObserver renderableActionObserver;
    public final RenderableMouseEvent renderableMouseEvent;

    @Autowired
    public JEngineController(Render render,
                             RenderableActionObserver renderableActionObserver,
                             RenderableMouseEvent renderableMouseEvent) {
        this.render = render;
        this.renderableActionObserver = renderableActionObserver;
        this.renderableMouseEvent = renderableMouseEvent;
        this.renderableActionObserver.addActionListener(this);
    }

    public void start() {
        SpriteController blueBubble = createSprite(0,50,50,50,
                new Image("/bubbles/blue.png"));

        System.out.println(blueBubble);

//        SpriteController redBubble = createSprite(50,75,50,50,
//                new Image("/bubbles/red.png"));
//
//        SpriteController greenBubble = createSprite(100,150,50,50,
//                new Image("/bubbles/green.png"));
//
//        SpriteController yellowBubble = createSprite(200,100,50,50,
//                new Image("/bubbles/yellow.png"));
    }

    public SpriteController createSprite(int x, int y, int width, int height, Image image) {
        return new SpriteController(x, y, width, height, image, renderableActionObserver,renderableMouseEvent);
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
