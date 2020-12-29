package com.thundertech.bubbles.model;

import java.util.Random;

public class Game {
    private int bubbleDiameter = 40;

    public BubbleField createBubbleField(int width, int height) {
        BubbleField field = new BubbleField(width, height);
        loadBubbleField(field);
        return field;
    }

    private void loadBubbleField(BubbleField field) {
        for(int x = 0; x < field.getWidth(); x++) {
            for(int y = 0; y < field.getHeight(); y++) {
                field.setBubble(createBubble(x,y,getRandomColor()));
            }
        }
    }

    private Bubble createBubble(int x, int y, String color) {
        return new Bubble(x,y,bubbleDiameter,color);
    }

    private String getRandomColor() {
        int random = new Random().nextInt(BubbleColors.values().length);
        return BubbleColors.values()[random].toString();
    }

    public void setBubbleDiameter(int bubbleDiameter) {
        this.bubbleDiameter = bubbleDiameter;
    }

    public int getBubbleDiameter() {
        return bubbleDiameter;
    }
}
