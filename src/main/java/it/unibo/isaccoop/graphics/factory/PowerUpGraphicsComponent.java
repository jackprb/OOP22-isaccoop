package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public interface PowerUpGraphicsComponent {

    /**
     * Get damage up powerUp graphics component.
     *
     * @param isSuper true if item is super
     * 
     * @return Damage graphics component
     * */
    GraphicsComponent getDamageUpGraphicsComponent(Boolean isSuper);

    /**
     * Get coin up powerUp graphics component.
     * 
     * @param isSuper true if item is super
     *
     * @return CoinUp graphics component
     * */
    GraphicsComponent getCoinUpGraphicsComponent(Boolean isSuper);

    /**
     * Get Health Up graphics component.
     * 
     * @param isSuper true if item is super
     *
     * @return HealthUp graphics component
     * */
    GraphicsComponent getHealthUpGraphicsComponent(Boolean isSuper);

    /**
     * Get range up graphics component.
     * 
     * @param isSuper true if item is super
     *
     * @return RangeUp graphics component
     * */
    GraphicsComponent getRangeUpGraphicsComponent(Boolean isSuper);

    /**
     * Get speed up graphics component.
     * 
     * @param isSuper true if item is super
     *
     * @return SpeedUp graphics component
     * */
    GraphicsComponent getSpeedUpGraphicsComponent(Boolean isSuper);

    /**
     * Get tears up graphics component.
     * 
     * @param isSuper true if item is super
     *
     * @return TearsUp graphics component
     * */
    GraphicsComponent getTearsUpGraphicsComponent(Boolean isSuper);

}
