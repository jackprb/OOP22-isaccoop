package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public abstract class AbstractGraphicsComponentFactory {

    /**
     * 
     * @param imageName
     * @return a MapElement as image 
     */
    protected GraphicsComponent getElementAsImageGraphicsComponent(final String imageName) {
        return (obj, w) -> w.drawElementAsImage(obj, imageName);
    }
}
