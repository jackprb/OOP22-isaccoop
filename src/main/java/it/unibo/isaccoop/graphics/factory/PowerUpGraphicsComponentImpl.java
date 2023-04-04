package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

public class PowerUpGraphicsComponentImpl extends AbstractGraphicsComponentFactory implements PowerUpGraphicsComponent {

    @Override
    public GraphicsComponent getDamageUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("damage_up.gif")
                : super.getElementAsImageGraphicsComponent("damage_super_up.gif");
    }

    @Override
    public GraphicsComponent getCoinUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("coin_up.gif")
                : super.getElementAsImageGraphicsComponent("coin_super_up.gif");
    }

    @Override
    public GraphicsComponent getHealthUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("health_up")
                : super.getElementAsImageGraphicsComponent("health_super_up");
    }

    @Override
    public GraphicsComponent getRangeUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("range_up")
                : super.getElementAsImageGraphicsComponent("range_super_up");
    }

    @Override
    public GraphicsComponent getSpeedUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("speed_up")
                : super.getElementAsImageGraphicsComponent("speed_super_up");
    }

    @Override
    public GraphicsComponent getTearsUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? super.getElementAsImageGraphicsComponent("tears_up")
                : super.getElementAsImageGraphicsComponent("tears_super_up");
    }

}
