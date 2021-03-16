package com.thundertech.bubbles.controller;

import com.thundertech.bubbles.model.BubbleField;
import com.thundertech.bubbles.model.Game;
import com.thundertech.bubbles.view.Render;
import com.thundertech.bubbles.view.Window;

public class Controller {
    private final Game game;
    private final Window window;
    private final Render render;

    public Controller(Game game, Window window, Render render) {
        this.game = game;
        this.window = window;
        this.render = render;
    }

    public void start() {
        int width = window.getWidth() / (game.getBubbleDiameter());
        int height = window.getHeight() / (game.getBubbleDiameter());
        BubbleField field = game.createBubbleField(width, height);

        RenderableMouseEvent.ADD_RENDERABLE(field);

        render.render(field);
    }
}
