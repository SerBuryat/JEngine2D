package com.thundertech.jengine2d.view.panel;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;

@Component
public class WorkPanel extends BorderPane {

    public WorkPanel() {
        this.setCenter(new Label("Work panel"));
    }
}
