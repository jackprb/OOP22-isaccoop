package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;
/***/
public class PowerUpGraphicsComponentImpl extends AbstractGraphicsComponentFactory implements PowerUpGraphicsComponent {

    /***/
    @Override
    public GraphicsComponent getDamageUpGraphicsComponent(final Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("damage_up.png")
                : super.getElementAsImageGraphicsComponent("damage_super_up.png");
    }

    /***/
    @Override
    public GraphicsComponent getCoinUpGraphicsComponent(final Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("coin_up.png")
                : super.getElementAsImageGraphicsComponent("coin_super_up.png");
    }

    /***/
    @Override
    public GraphicsComponent getHealthUpGraphicsComponent(final Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("health_up.png")
                : super.getElementAsImageGraphicsComponent("health_super_up.gif");
    }

    /***/
    @Override
    public GraphicsComponent getRangeUpGraphicsComponent(final Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("range_up.png")
                : super.getElementAsImageGraphicsComponent("range_super_up.png");
    }

    /***/
    @Override
    public GraphicsComponent getSpeedUpGraphicsComponent(final Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("speed_up.png")
                : super.getElementAsImageGraphicsComponent("speed_super_up.png");
    }

    /***/
    @Override
    public GraphicsComponent getTearsUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("tears_up.png")
                : super.getElementAsImageGraphicsComponent("tears_super_up.gif");
    }

}
