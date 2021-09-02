package com.thundertech.jengine2d.view;

import com.thundertech.jengine2d.view.panel.main.WindowMainPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ApplicationWindow {

    private final WindowMainPanel mainPanel;

    @Autowired
    public ApplicationWindow(WindowMainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void loadAndShow(Stage stage) {
        stage.setScene(new Scene(mainPanel));
        stage.setTitle("[JEngine2D]");
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }
}
