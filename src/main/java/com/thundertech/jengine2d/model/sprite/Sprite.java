package com.thundertech.jengine2d.model.sprite;

import javafx.scene.image.Image;

public class Sprite  {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Sprite(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
                ", image=" + image.getUrl().split("/")[image.getUrl().split("/").length-1] +
                '}';
    }
}
