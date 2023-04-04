package it.unibo.isaccoop.controller.input;
/**
 * Interface for the action controller.
 */
public interface ActionController {

    /**
     * 
     * @return true if Esc button has been pressed
     */
    boolean isEsc();

    /**
     * 
     * @return true if NextDoor button has been pressed
     */
    boolean isNextDoor();

    /**
     * 
     * @return true if PrevDoor button has been pressed
     */
    boolean isPrevDoor();
}
