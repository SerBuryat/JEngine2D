package com.thundertech.jengine2d.view.panel.main;

import com.thundertech.jengine2d.view.panel.main.area.WindowMainPanelBottomArea;
import com.thundertech.jengine2d.view.panel.main.area.WindowMainPanelCenterArea;
import com.thundertech.jengine2d.view.panel.main.area.WindowMainPanelTopArea;
import com.thundertech.jengine2d.view.panel.work.WorkPanel;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WindowMainPanel extends SplitPane {


    private final WindowMainPanelTopArea topPanel;
    private final WindowMainPanelCenterArea centerPanel;
    private final WindowMainPanelBottomArea bottomPanel;

    @Autowired
    public WindowMainPanel(WindowMainPanelTopArea topPanel,
                           WindowMainPanelCenterArea centerPanel,
                           WindowMainPanelBottomArea bottomPanel) {
        this.topPanel = topPanel;
        this.centerPanel = centerPanel;
        this.bottomPanel = bottomPanel;
    }

    @PostConstruct
    public void init() {
        SplitPane innerCentralPanel = new SplitPane(new WorkPanel("Center1"),
                new WorkPanel("Center2"),
                new WorkPanel("Center3"));
        centerPanel.getItems().add(innerCentralPanel);

        topPanel.getItems().add(new WorkPanel("Top"));
        bottomPanel.getItems().add(new WorkPanel("Bottom"));

        this.setOrientation(Orientation.VERTICAL);
        this.getItems().addAll(topPanel,centerPanel,bottomPanel);
    }
}
