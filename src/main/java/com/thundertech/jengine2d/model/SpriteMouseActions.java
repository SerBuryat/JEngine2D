package com.thundertech.jengine2d.model;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class SpriteMouseActions {
    public static void pick(Sprite sprite, MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY) {
            if(mouseEvent.getClickCount() == 2) {
                sprite.setPicked(!sprite.isPicked());
            }
        }
    }

    public static void move(Sprite sprite, MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY &&
                sprite.isPicked() && mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) {

            Point2D currentPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
            SpriteMovementTrack movementTrack = sprite.getMovementTrack();
            movementTrack.addMovePoint(currentPoint);

            if(movementTrack.getTrackSize()-2 >= 0) {
                Point2D previousPoint = movementTrack.getMovePoint(movementTrack.getTrackSize()-2);
                sprite.setX((int)(sprite.getX() + (currentPoint.getX() - previousPoint.getX())));
                sprite.setY((int)(sprite.getY() + (currentPoint.getY() - previousPoint.getY())));
            }
        }
    }
}
