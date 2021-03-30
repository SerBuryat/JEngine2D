package com.thundertech.jengine2d.view.render;

import java.util.ArrayList;
import java.util.List;

public class RenderableEventManager {

    private static final List<RenderableEventsListener> LISTENER = new ArrayList<>();

    public static void notifyRenderableListeners(Renderable renderable) {
        LISTENER.forEach(listener -> listener.renderableObjectChanged(renderable));
    }

    public static void addEventListener(RenderableEventsListener listener) {
        LISTENER.add(listener);
    }
}
