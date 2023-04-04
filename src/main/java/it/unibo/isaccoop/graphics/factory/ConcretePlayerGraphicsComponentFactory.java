package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public final class ConcretePlayerGraphicsComponentFactory implements PlayerGraphicsComponentFactory {

    @Override
    public GraphicsComponent getPlayerGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "player.gif");
    }

}
