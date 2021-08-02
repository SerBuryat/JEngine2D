package com.thundertech.jengine2d.model.sprite;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Sprite  {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    @Override
    public String toString() {
        return "Sprite{" +
                "x=" + x +
                ", y=" + y +
                ", image=" + image.getUrl().split("/")[image.getUrl().split("/").length-1] +
                '}';
    }

}
