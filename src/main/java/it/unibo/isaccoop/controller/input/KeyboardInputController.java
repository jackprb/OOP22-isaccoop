package it.unibo.isaccoop.controller.input;

/**
 * 
 *
 */
public class KeyboardInputController implements InputController {

    private final int keyCodeUp;
    private final int keyCodeDown;
    private final int keyCodeLeft;
    private final int keyCodeRight;

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;



    /**
     * @param keyCodeUp
     * @param keyCodeDown
     * @param keyCodeLeft
     * @param keyCodeRight
     */
    public KeyboardInputController(final int keyCodeUp, final int keyCodeDown, 
                final int keyCodeLeft, final int keyCodeRight) {
        super();
        this.keyCodeUp = keyCodeUp;
        this.keyCodeDown = keyCodeDown;
        this.keyCodeLeft = keyCodeLeft;
        this.keyCodeRight = keyCodeRight;
    }

    /**
     * 
     * @param keyCode
     */
    public void notifyKeyPressed(final int keyCode) {
        if (keyCode == keyCodeUp) {
            isUp = true;
        } else if (keyCode == keyCodeDown) {
            isDown = true;
        } else if (keyCode == keyCodeLeft) {
            isLeft = true;
        } else if (keyCode == keyCodeRight) {
            isRight = true;
        }
    }

    /**
     * 
     * @param keyCode
     */
    public void notifyKeyReleased(final int keyCode) {
        if (keyCode == keyCodeUp) {
            isUp = false;
        } else if (keyCode == keyCodeDown) {
            isDown = false;
        } else if (keyCode == keyCodeLeft) {
            isLeft = false;
        } else if (keyCode == keyCodeRight) {
            isRight = false;
        }
    }

    /**
     * 
     */
    @Override
    public boolean isUp() {
        return this.isUp;
    }

    /**
     * 
     */
    @Override
    public boolean isDown() {
        return this.isDown;
    }

    /**
     * 
     */
    @Override
    public boolean isLeft() {
        return this.isLeft;
    }

    /**
     * 
     */
    @Override
    public boolean isRight() {
        return this.isRight;
    }
}
