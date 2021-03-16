package com.thundertech.bubbles.model;

import com.thundertech.bubbles.view.Renderable;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Bubble implements Renderable, EventHandler<MouseEvent> {
    private int x;
    private int y;
    private Rectangle2D boundary;
    private int diameter;
    private String color;
    private Image image;

    public Bubble(int x, int y, int diameter, String color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
        image = new Image("/bubbles/" + color.toLowerCase().trim() + ".png");
        boundary = new Rectangle2D(x * diameter,y * diameter,diameter,diameter);
    }

    public void render(GraphicsContext graphics) {
        graphics.drawImage(this.image,
                this.boundary.getMinX(),
                this.boundary.getMinY(),
                this.diameter, this.diameter);
    }

    public void setX(int x) {
        this.x = x;
        boundary = new Rectangle2D(x * diameter,y * diameter,diameter,diameter);
    }

    public void setY(int y) {
        this.y = y;
        boundary = new Rectangle2D(x * diameter,y * diameter,diameter,diameter);
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getDiameter() {
        return diameter;
    }

    public String getColor() {
        return color;
    }

    public Image getImage() {
        return image;
    }

    public boolean isContainsPoint(double x, double y) {
        return boundary.contains(x,y);
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "x=" + x +
                ", y=" + y +
                ", boundary=" + boundary +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(this.isContainsPoint(mouseEvent.getX(), mouseEvent.getY()))
            System.out.println(this);
    }
}
