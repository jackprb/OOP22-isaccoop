package it.unibo.isaccoop.graphics;

import java.awt.Component;

/**
 * Interface that contains methods for GUI windows made with {@link JFrame}.
 */
public interface GUIFrame {

    /**
     * Display the frame.
     * Implemented by default in {@link AbstractGUIFrame}.
     */
    void display();

    /**
     * Method to update the GUI, to be called when a repaint of the frame is needed to show changes.
     * To be implemented in subclasses.
     */
    void updateView();

    /**
     * Add the specified component to the main {@link BorderLayout} panel.
     * @param comp the component to add to the main panel
     * @param position the position where to put the component
     */
    void addElementToMainPanel(Component comp, Object position);
}
