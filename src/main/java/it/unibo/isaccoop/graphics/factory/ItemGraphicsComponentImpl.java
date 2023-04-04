package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;
/***/
public class ItemGraphicsComponentImpl implements ItemGraphicsComponent {

    @Override
    public GraphicsComponent getHeartGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "heart.gif");
    }

    @Override
    public GraphicsComponent getCoinGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "coin.gif");
    }

}
