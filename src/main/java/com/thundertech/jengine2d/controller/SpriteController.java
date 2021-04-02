package com.thundertech.jengine2d.controller;

import com.thundertech.jengine2d.model.sprite.Sprite;
import com.thundertech.jengine2d.model.sprite.SpriteMouseActions;
import com.thundertech.jengine2d.model.sprite.SpriteMovementTrack;
import com.thundertech.jengine2d.view.render.Renderable;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SpriteController implements Renderable, EventHandler<MouseEvent> {
    private final Sprite sprite;
    private Rectangle2D boundary;
    private boolean picked;
    private final SpriteMovementTrack movementTrack = new SpriteMovementTrack();

    public SpriteController( int x, int y, int width, int height, Image image) {
        this.sprite = new Sprite(x,y,width,height,image);
        this.boundary = new Rectangle2D(this.sprite.getX(),this.sprite.getY(),
                                        this.sprite.getWidth(),this.sprite.getHeight());
        JEngineController.renderableMouseEvent.addRenderable(this);
        JEngineController.renderableEventManager.notifyRenderableListeners(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(this.isContainsPoint(mouseEvent.getX(), mouseEvent.getY())) {
            SpriteMouseActions.pick(this, mouseEvent);
            SpriteMouseActions.move(this, mouseEvent);
        }
    }

    public void render(GraphicsContext graphics) {
        if(this.isPicked()) {
            graphics.setFill(Color.RED);
            graphics.strokeRect(this.sprite.getX(), this.sprite.getY(),
                                this.sprite.getWidth(), this.sprite.getHeight());
        }
        graphics.drawImage(this.sprite.getImage(),
                this.getBoundary().getMinX(),
                this.getBoundary().getMinY(),
                this.sprite.getWidth(), this.sprite.getHeight());
    }

    public boolean isContainsPoint(double x, double y) {
        return this.boundary.contains(x,y);
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
        JEngineController.renderableEventManager.notifyRenderableListeners(this);
    }

    public void move(int x, int y) {
        this.sprite.setX(x);
        this.sprite.setY(y);
        this.boundary = new Rectangle2D(this.sprite.getX(), this.sprite.getY(),
                                        this.sprite.getWidth(), this.sprite.getHeight());
        JEngineController.renderableEventManager.notifyRenderableListeners(this);
    }

    public void setSize(int width, int height) {
        this.sprite.setWidth(width);
        this.sprite.setHeight(height);
        this.boundary = new Rectangle2D(this.sprite.getX(), this.sprite.getY(),
                                        this.sprite.getWidth(), this.sprite.getHeight());
        JEngineController.renderableEventManager.notifyRenderableListeners(this);
    }

    public void setImage(Image image) {
        this.sprite.setImage(image);
        JEngineController.renderableEventManager.notifyRenderableListeners(this);
    }

    public boolean isPicked() {
        return picked;
    }

    public Rectangle2D getBoundary() {
        return boundary;
    }

    public int getX() {
        return this.sprite.getX();
    }

    public int getY() {
        return this.sprite.getY();
    }

    public SpriteMovementTrack getMovementTrack() {
        return movementTrack;
    }
}
