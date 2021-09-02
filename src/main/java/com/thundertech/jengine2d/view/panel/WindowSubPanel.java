package com.thundertech.jengine2d.view.panel;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class WindowSubPanel extends Pane {

    private String nameID;

    public WindowSubPanel(String nameId) {
        this.getChildren().add(new Label(nameId));
        this.setMinHeight(100);
        this.setMinWidth(100);
    }
}
