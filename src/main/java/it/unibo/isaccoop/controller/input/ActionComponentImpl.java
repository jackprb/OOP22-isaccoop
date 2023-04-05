/**
 * 
 */
package it.unibo.isaccoop.controller.input;

import it.unibo.isaccoop.model.room.Level;

/**
 * Class that execute the update of the ActionController on the level.
 */
public class ActionComponentImpl implements ActionComponent {

    private final Level level;
    /**
     * Contructor of the ActionComponent
     * @param level
     */
    public ActionComponentImpl(final Level level) {
        this.level = level;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final ActionController ctrl) {
        if (ctrl.isEsc()) {
            //go to menu
        } else if (ctrl.isNextRoom()) {
            this.level.moveToNextRoom();
        } else if (ctrl.isPrevRoom()) {
            this.level.moveToPreviousRoom();
        }
    }

}
