package it.unibo.isaccoop.controller.input;
/**
 * 
 *
 */
public interface InputController {

    /**
     * 
     * @return true if direction is UP.
     */
    boolean isUp();

    /**
     * 
     * @return true if direction is DOWN.
     */
    boolean isDown();

    /**
     * 
     * @return true if direction is LEFT.
     */
    boolean isLeft();

    /**
     * 
     * @return true if direction is RIGHT.
     */
    boolean isRight();
}
