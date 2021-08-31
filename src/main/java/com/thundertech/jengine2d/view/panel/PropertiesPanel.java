package com.thundertech.jengine2d.view.panel;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;

@Component
public class PropertiesPanel extends BorderPane {

    public PropertiesPanel() {
        this.setCenter(new Label("Properties panel"));
    }
}
