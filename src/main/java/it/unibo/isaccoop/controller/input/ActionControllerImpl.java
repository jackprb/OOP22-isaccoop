package it.unibo.isaccoop.controller.input;
/**
 * Class that manages the pressure of the buttons,
 * saving only the last key pressed until it is used.
 */
public class ActionControllerImpl implements ActionController {

    private final int keyEsc;
    private final int keyNextDoor;
    private final int keyPrevDoor;

    private boolean isEsc;
    private boolean isNextDoor;
    private boolean isPrevDoor;
    /**
     * @param keyEsc
     * @param keyNextDoor
     * @param keyPrevDoor
     */
    public ActionControllerImpl(final int keyEsc, final int keyNextDoor, final int keyPrevDoor) {
        super();
        this.keyEsc = keyEsc;
        this.keyNextDoor = keyNextDoor;
        this.keyPrevDoor = keyPrevDoor;
    }

    /**
     * 
     * @param keyCode
     */
    public void notifyKeyPressed(final int keyCode) {
        this.setAllFalse();
        if (keyCode == this.keyEsc) {
            this.isEsc = true;
        } else if (keyCode == this.keyNextDoor) {
            this.isNextDoor = true;
        } else if (keyCode == this.keyPrevDoor) {
            this.isPrevDoor = true;
        }
    }

    /**
     * Clears all fields that keep track of the last key pressed.
     */
    private void setAllFalse() {
        this.isEsc = false;
        this.isNextDoor = false;
        this.isPrevDoor = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEsc() {
        if (this.isEsc) {
            this.setAllFalse();
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNextDoor() {
        if (this.isNextDoor) {
            this.setAllFalse();
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPrevDoor() {
        if (this.isPrevDoor) {
            this.setAllFalse();
            return true;
        }
        return false;
    }
}
