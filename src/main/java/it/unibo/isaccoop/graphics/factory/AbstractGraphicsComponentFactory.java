package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public abstract class AbstractGraphicsComponentFactory {

    protected GraphicsComponent getElementAsImageGraphicsComponent(final String imageName) {
        return (obj, w) -> w.drawElementAsImage(obj, imageName);
    }

}
