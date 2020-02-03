package sample;

import javafx.event.Event;

import java.util.EventListener;

public interface Button  <T extends Event> extends EventListener {
    void action(javafx.scene.control.Button button);
}
