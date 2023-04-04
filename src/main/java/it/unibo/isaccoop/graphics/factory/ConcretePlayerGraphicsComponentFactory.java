package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public final class ConcretePlayerGraphicsComponentFactory extends AbstractGraphicsComponentFactory implements PlayerGraphicsComponentFactory {

    @Override
    public GraphicsComponent getPlayerGraphicsComponent() {
        return super.getElementAsImageGraphicsComponent("player.gif");
    }

}
