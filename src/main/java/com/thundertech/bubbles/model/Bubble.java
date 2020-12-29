package com.thundertech.bubbles.model;

public class Bubble {
    private int x;
    private int y;
    private int diameter;
    private String color;

    public Bubble(int x, int y, int diameter, String color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "[" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                ']';
    }
}
