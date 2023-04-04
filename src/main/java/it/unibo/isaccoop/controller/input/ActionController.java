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
     * @return true if NextRoom button has been pressed
     */
    boolean isNextRoom();

    /**
     * 
     * @return true if PrevRoom button has been pressed
     */
    boolean isPrevRoom();
}
