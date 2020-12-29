package com.thundertech.bubbles.view;

import com.thundertech.bubbles.model.Bubble;
import com.thundertech.bubbles.model.BubbleField;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Render {
    private final GraphicsContext graphics;

    public Render(GraphicsContext graphics) {
        this.graphics = graphics;
    }

    public void paint(BubbleField field) {
        for(int x = 0; x < field.getWidth(); x++) {
            for(int y = 0; y < field.getHeight(); y++) {
                Bubble bubble = field.getBubble(x,y);
                paint(bubble);
            }
        }
    }

    public void paint(Bubble bubble) {
        Image image = new Image("/bubbles/" + bubble.getColor().toLowerCase().trim() + ".png");
        int width = bubble.getDiameter();
        int height = bubble.getDiameter();
        graphics.drawImage(image, bubble.getX() * width, bubble.getY() * height, width, height);
    }
}
