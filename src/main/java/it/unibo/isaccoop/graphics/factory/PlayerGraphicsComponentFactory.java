package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public interface PlayerGraphicsComponentFactory {

    /**
     * Get player graphics component.
     *
     * @return player graphics component
     * */
    GraphicsComponent getPlayerGraphicsComponent();

    /**
     * Get base weapon shot graphics component.
     *
     * @return base weapon shot graphics component
     * */
    GraphicsComponent getPlayerBaseWeaponShotGraphicsComponent();

}
