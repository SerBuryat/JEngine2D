package com.thundertech.bubbles.model;

import java.util.Arrays;

public class BubbleField {
    private Bubble [][] field;
    private int width;
    private int height;

    public BubbleField() {
        this.width = 5;
        this.height = 5;
        this.field = new Bubble[this.width][this.height];
    }

    public BubbleField(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Bubble[this.width][this.height];
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setField(Bubble[][] field) {
        this.field = field;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bubble[][] getField() {
        return field;
    }

    @Override
    public String toString() {
        String field = "";

        for(int x = 0; x < this.getWidth(); x++) {
            for(int y = 0; y < this.getHeight(); y++) {
                field += this.field[x][y] + " ";
            }
            field += "\n";
        }

        return field;
    }
}
