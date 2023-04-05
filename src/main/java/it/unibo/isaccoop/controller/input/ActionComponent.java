package it.unibo.isaccoop.controller.input;
/**
 * Interface for the update of the ActionController.
 */
public interface ActionComponent {

    /**
     * Execute the actions selected in the action controller.
     * @param ctrl of the level.
     */
    void update(ActionController ctrl);
}
