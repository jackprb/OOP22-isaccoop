package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;
/***/
public class ItemGraphicsComponentImpl extends AbstractGraphicsComponentFactory implements ItemGraphicsComponent {

    @Override
    public GraphicsComponent getHeartGraphicsComponent() {
        return super.getElementAsImageGraphicsComponent("heart.gif");
    }

    @Override
    public GraphicsComponent getCoinGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "coin.gif");
    }

}
