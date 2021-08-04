package com.thundertech.jengine2d.view.render;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RenderableActionObserver {

    private final List<RenderableActionListener> listeners = new ArrayList<>();

    public void notifyListeners(Renderable renderable) {
        this.listeners.forEach(listener -> listener.renderableObjectChanged(renderable));
    }

    public void addActionListener(RenderableActionListener listener) {
        this.listeners.add(listener);
    }
}
