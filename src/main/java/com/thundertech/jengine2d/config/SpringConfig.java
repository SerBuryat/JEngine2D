package com.thundertech.jengine2d.config;

import com.thundertech.jengine2d.view.Window;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.thundertech.jengine2d")
public class SpringConfig {

    @Autowired
    private Window window;

    @Bean
    public GraphicsContext graphicsContext() {
        return window.getCanvas().getGraphicsContext2D();
    }

}
