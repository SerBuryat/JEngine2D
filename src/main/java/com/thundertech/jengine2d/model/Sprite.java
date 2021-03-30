package com.thundertech.jengine2d.model;

import com.thundertech.jengine2d.view.render.RenderableEventManager;
import com.thundertech.jengine2d.view.render.RenderableMouseEvent;
import com.thundertech.jengine2d.view.render.Renderable;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Sprite implements Renderable, EventHandler<MouseEvent> {

    private int x;
    private int y;
    private Rectangle2D boundary;
    private int width;
    private int height;
    private Image image;
    private boolean picked = false;

    public Sprite(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.boundary = new Rectangle2D(x,y ,width,height);
        RenderableMouseEvent.ADD_RENDERABLE(this);
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public boolean isContainsPoint(double x, double y) {
        return boundary.contains(x,y);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(this.isContainsPoint(mouseEvent.getX(), mouseEvent.getY())) {
            if(mouseEvent.getButton() == MouseButton.PRIMARY) {
                if(mouseEvent.getClickCount() == 2) {
                    if(!picked)
                        this.setPicked(true);
                    else this.setPicked(false);
                }
                if(this.isPicked()) {
                    this.setX((int) mouseEvent.getX());
                    this.setY((int) mouseEvent.getY());
                }
            }
        }
    }

    public void render(GraphicsContext graphics) {
        if(picked) {
            graphics.setFill(Color.RED);
            graphics.strokeRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
        graphics.drawImage(this.image,
                this.boundary.getMinX(),
                this.boundary.getMinY(),
                this.width, this.height);
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public void setX(int x) {
        this.x = x;
        this.boundary = new Rectangle2D(x ,y,width,height);
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public void setY(int y) {
        this.y = y;
        this.boundary = new Rectangle2D(x,y ,width,height);
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public void setWidth(int width) {
        this.width = width;
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public void setHeight(int height) {
        this.height = height;
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public void setImage(Image image) {
        this.image = image;
        RenderableEventManager.notifyRenderableListeners(this);
    }

    public boolean isPicked() {
        return picked;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getBoundary() {
        return boundary;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "x=" + x +
                ", y=" + y +
                ", boundary=" + boundary +
                ", picked=" + picked +
                ", image=" + image.getUrl().split("/")[image.getUrl().split("/").length-1] +
                '}';
    }
}
