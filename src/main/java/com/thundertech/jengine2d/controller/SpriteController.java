package com.thundertech.jengine2d.controller;

import com.thundertech.jengine2d.model.sprite.Sprite;
import com.thundertech.jengine2d.model.sprite.SpriteMouseAction;
import com.thundertech.jengine2d.view.render.Renderable;
import com.thundertech.jengine2d.view.render.RenderableActionObserver;
import com.thundertech.jengine2d.view.render.RenderableMouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SpriteController implements Renderable, EventHandler<MouseEvent>, SpriteMouseAction {
    private final Sprite sprite;
    private Rectangle2D boundary;
    private boolean picked;
    private final RenderableActionObserver renderableActionObserver;
    private final RenderableMouseEvent renderableMouseEvent;

    public SpriteController( int x, int y, int width, int height, Image image,
                             RenderableActionObserver renderableActionObserver,
                             RenderableMouseEvent renderableMouseEvent) {
        this.sprite = new Sprite(x,y,width,height,image);
        this.boundary = new Rectangle2D(this.sprite.getX(),this.sprite.getY(),
                                        this.sprite.getWidth(),this.sprite.getHeight());
        this.renderableActionObserver = renderableActionObserver;
        this.renderableMouseEvent = renderableMouseEvent;
        this.renderableMouseEvent.addRenderable(this);
        this.renderableActionObserver.notifyListeners(this);
    }

    public void moveSprite(int x, int y) {
        this.sprite.setX(x);
        this.sprite.setY(y);
        this.boundary = new Rectangle2D(this.sprite.getX(), this.sprite.getY(),
                this.sprite.getWidth(), this.sprite.getHeight());
        renderableActionObserver.notifyListeners(this);
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

    @Override
    public void handle(MouseEvent mouseEvent) {
        pick(mouseEvent);
        move(mouseEvent);
    }

    @Override
    public void move(MouseEvent mouseEvent) {
        if(mouseEvent.isPrimaryButtonDown()) {
            if (isPicked() && mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double spriteMidW = getBoundary().getWidth()/2;
                double spriteMidH = getBoundary().getHeight()/2;
                moveSprite((int) (mouseEvent.getX() - spriteMidH), (int) (mouseEvent.getY() - spriteMidW));
            }
        }
    }

    @Override
    public void pick(MouseEvent mouseEvent) {
        if(isContainsPoint(mouseEvent.getX(), mouseEvent.getY())) {
            if(mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                setPicked(!isPicked());
            }
        }
    }

    public boolean isContainsPoint(double x, double y) {
        return this.boundary.contains(x,y);
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
        renderableActionObserver.notifyListeners(this);
    }

    public void setSize(int width, int height) {
        this.sprite.setWidth(width);
        this.sprite.setHeight(height);
        this.boundary = new Rectangle2D(this.sprite.getX(), this.sprite.getY(),
                this.sprite.getWidth(), this.sprite.getHeight());
        renderableActionObserver.notifyListeners(this);
    }

    public void setImage(Image image) {
        this.sprite.setImage(image);
        renderableActionObserver.notifyListeners(this);
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

    @Override
    public String toString() {
        return "SpriteController{" +
                "sprite=" + sprite +
                ", boundary=" + boundary +
                '}';
    }
}
