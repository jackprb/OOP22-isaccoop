/**
 *
 */
package it.unibo.isaccoop.controller.input;

import it.unibo.isaccoop.core.GameLoop;

/**
 * Class that execute the update of the ActionController on the level.
 */
public class ActionComponentImpl implements ActionComponent {

    private final GameLoop loop;
    /**
     * Contructor of the ActionComponent
     * @param level
     */
    public ActionComponentImpl(final GameLoop loop) {
        this.loop = loop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final ActionController ctrl) {
        if (ctrl.isEsc()) {
            this.loop.setPause(!this.loop.isPause());
        } else if (!this.loop.isPause() && ctrl.isNextRoom()) {
            this.loop.getLevel().moveToNextRoom();
        } else if (!this.loop.isPause() && ctrl.isPrevRoom()) {
            this.loop.getLevel().moveToPreviousRoom();
        }
    }

}
