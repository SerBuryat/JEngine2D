package com.thundertech.jengine2d.view;

import com.thundertech.jengine2d.view.panel.WindowMainPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ApplicationWindow {

    private final BorderPane mainPanel;

    public ApplicationWindow() {
        mainPanel = new WindowMainPanel();
    }

    public void loadAndShow(Stage stage) {
        stage.setScene(new Scene(mainPanel));
        stage.setTitle("[JEngine2D]");
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }
}
