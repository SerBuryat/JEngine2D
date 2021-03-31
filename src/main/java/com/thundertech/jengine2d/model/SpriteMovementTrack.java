package com.thundertech.jengine2d.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class SpriteMovementTrack {
    private List<Point2D> movementTrack = new ArrayList<>();
    private final int movementTrackCapacity = 20;

    public void addMovePoint(Point2D point2D) {
        if(this.movementTrack.size() == this.movementTrackCapacity)
            this.movementTrack.remove(0);
        this.movementTrack.add(point2D);
    }

    public Point2D getMovePoint(int index) {
        return movementTrack.get(index);
    }

    public int getTrackSize() {
        return movementTrack.size();
    }
}
