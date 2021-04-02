package com.thundertech.jengine2d.model.sprite;

import com.thundertech.jengine2d.controller.SpriteController;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class SpriteMouseActions {
    public static void pick(SpriteController spriteController, MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY) {
            if(mouseEvent.getClickCount() == 2) {
                spriteController.setPicked(!spriteController.isPicked());
            }
        }
    }

    public static void move(SpriteController sprite, MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY &&
                sprite.isPicked() && mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {

            Point2D currentPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
            SpriteMovementTrack movementTrack = sprite.getMovementTrack();
            movementTrack.addMovePoint(currentPoint);

            if(movementTrack.getTrackSize() > 1) {
                Point2D previousPoint = movementTrack.getMovePoint(movementTrack.getTrackSize()-2);
                int newX = ((int)(sprite.getX() + (currentPoint.getX() - previousPoint.getX())));
                int newY = ((int)(sprite.getY() + (currentPoint.getY() - previousPoint.getY())));
                sprite.move(newX, newY);
            }
        }
    }
}
