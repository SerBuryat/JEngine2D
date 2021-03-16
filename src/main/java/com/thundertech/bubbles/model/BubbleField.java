package com.thundertech.bubbles.model;

import com.thundertech.bubbles.view.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;

public class BubbleField implements Renderable {
    private Bubble [][] field;
    private int width;
    private int height;

    public BubbleField() {
        this.width = 10;
        this.height = 10;
        this.field = new Bubble[this.width][this.height];
    }

    public BubbleField(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Bubble[this.width][this.height];
    }

    @Override
    public void render(GraphicsContext graphics) {
        for(int x = 0; x < this.width; x++) {
            for(int y = 0; y < this.height; y++) {
                Bubble bubble = this.getBubble(x,y);
                bubble.render(graphics);
            }
        }
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

    public void setBubble(Bubble bubble) {
        field[bubble.getX()][bubble.getY()] = bubble;
    }

    public Bubble getBubble(int x, int y) {
        return field[x][y];
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

    @Override
    public void handle(MouseEvent mouseEvent) {
        Arrays.stream(this.field)
                .forEach(bubbles -> Arrays.stream(bubbles).forEach(bubble -> bubble.handle(mouseEvent)));
    }
}
