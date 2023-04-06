package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public interface EnemyGraphicsComponentFactory {

    /**
     * Get non shooting enemy graphics component.
     *
     * @return non shooting enemy graphics component
     * */
    GraphicsComponent getNonShootingGraphicsComponent();

    /**
     * Get shooting enemy graphics component.
     *
     * @return shooting enemy graphics component
     * */
    GraphicsComponent getShootingGraphicsComponent();

    /**
     * Get boss graphics component.
     *
     * @return boss graphics component
     * */
    GraphicsComponent getBossGraphicsComponent();

    /**
     * Get base weapon shot graphics component.
     *
     * @return base weapon shot graphics component
     * */
    GraphicsComponent getBaseWeaponShotGraphicsComponent();

}
