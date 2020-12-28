package com.thundertech.bubbles.controller;

import com.thundertech.bubbles.model.Bubble;
import com.thundertech.bubbles.model.BubbleColors;
import com.thundertech.bubbles.model.BubbleField;

import java.util.Random;

public class Game {

    public void start() {
        BubbleField field = createBubbleField();

        //Create bubble field test
        System.out.println(field.toString());
    }

    private BubbleField createBubbleField() {
        BubbleField field = new BubbleField();

        loadBubbleField(field);

        return field;
    }

    private void loadBubbleField(BubbleField field) {
        for(int x = 0; x < field.getWidth(); x++) {
            for(int y = 0; y < field.getHeight(); y++) {
                field.getField()[x][y] = createBubble(x,y,getRandomColor());
            }
        }
    }

    private Bubble createBubble(int x, int y, String color) {
        return new Bubble(x,y,color);
    }

    private String getRandomColor() {
        int random = new Random().nextInt(BubbleColors.values().length);
        return BubbleColors.values()[random].toString();
    }
}
