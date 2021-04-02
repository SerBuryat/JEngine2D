package com.thundertech.jengine2d.view.render;

import java.util.ArrayList;
import java.util.List;

public class RenderableEventManager {

    public RenderableEventManager() {}

    private final List<RenderableEventsListener> listeners = new ArrayList<>();

    public void notifyRenderableListeners(Renderable renderable) {
        this.listeners.forEach(listener -> listener.renderableObjectChanged(renderable));
    }

    public void addEventListener(RenderableEventsListener listener) {
        this.listeners.add(listener);
    }
}
