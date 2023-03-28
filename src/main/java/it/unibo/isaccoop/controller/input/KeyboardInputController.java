package it.unibo.isaccoop.controller.input;

/**
 * 
 *
 */
public class KeyboardInputController implements InputController {
    
    private int keyCodeUp;
    private int keyCodeDown;
    private int keyCodeLeft;
    private int keyCodeRight;
    
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
    public KeyboardInputController(int keyCodeUp, int keyCodeDown, int keyCodeLeft, int keyCodeRight) {
        super();
        this.keyCodeUp = keyCodeUp;
        this.keyCodeDown = keyCodeDown;
        this.keyCodeLeft = keyCodeLeft;
        this.keyCodeRight = keyCodeRight;
    }
    
    public void notifyKeyPressed(int keyCode) {
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
    
    public void notifyKeyReleased(int keyCode) {
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
