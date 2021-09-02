package com.thundertech.jengine2d.view.panel.main.area;

import javafx.geometry.Orientation;
import org.springframework.stereotype.Component;

@Component
public class WindowMainPanelCenterArea extends WindowMainPanelArea {
    public WindowMainPanelCenterArea() {
        this.setOrientation(Orientation.HORIZONTAL);
    }
}
