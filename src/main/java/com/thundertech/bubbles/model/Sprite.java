package com.thundertech.bubbles.model;

import com.thundertech.bubbles.view.Renderable;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Sprite implements Renderable, EventHandler<MouseEvent> {

    private int x;
    private int y;
    private Rectangle2D boundary;
    private int width;
    private int height;
    private Image image;

    public Sprite(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        boundary = new Rectangle2D(x * width,y * height,width,height);
    }

    public void render(GraphicsContext graphics) {
        graphics.drawImage(this.image,
                this.boundary.getMinX(),
                this.boundary.getMinY(),
                this.width, this.height);
    }

    public void setX(int x) {
        this.x = x;
        this.boundary = new Rectangle2D(x * width,y * height,width,height);
    }

    public void setY(int y) {
        this.y = y;
        this.boundary = new Rectangle2D(x * width,y * height,width,height);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public boolean isContainsPoint(double x, double y) {
        return boundary.contains(x,y);
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "x=" + x +
                ", y=" + y +
                ", boundary=" + boundary +
                '}';
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(this.isContainsPoint(mouseEvent.getX(), mouseEvent.getY()))
            System.out.println(this);
    }
}
