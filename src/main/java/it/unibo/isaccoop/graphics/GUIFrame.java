package it.unibo.isaccoop.graphics;

import javax.swing.JFrame;

/**
 * Interface that contains methods for GUI windows made with {@link JFrame}.
 */
public interface GUIFrame {

    /**
     * Set the title of this frame.<br>
     * Implemented by default in {@link AbstractGUIFrame}.
     * @param title the string to set as title in frame
     */
    void setTitle(String title);

    /**
     * Display the frame.
     * Implemented by default in {@link AbstractGUIFrame}.
     */
    void display();

    /**
     * Hide the frame.
     * Implemented by default in {@link AbstractGUIFrame}.
     */
    void hide();

    /**
     * Method to update the GUI, to be called when a repaint of the frame is needed to show changes.
     * To be implemented in subclasses.
     */
    void updateView();

    /**
     * Method to set the resize proportion of a {@link JFrame}, depending on the sceen dimension.
     */
    void setResizeProportion(int proportion);

    /**
     * Get the {@link JFrame}.
     * @return the Jframe
     */
    JFrame getJFrame();
}
