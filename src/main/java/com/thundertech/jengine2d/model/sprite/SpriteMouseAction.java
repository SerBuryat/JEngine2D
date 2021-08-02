package com.thundertech.jengine2d.model.sprite;

import javafx.scene.input.MouseEvent;

public interface SpriteMouseAction {
    void move(MouseEvent mouseEvent);
    void pick(MouseEvent mouseEvent);
}
