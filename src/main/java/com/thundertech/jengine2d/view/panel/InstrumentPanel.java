package com.thundertech.jengine2d.view.panel;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;

@Component
public class InstrumentPanel extends BorderPane {

    public InstrumentPanel() {
        this.setCenter(new Label("Instruments panel"));
    }
}
