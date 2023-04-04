package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;
/***/
public interface ItemGraphicsComponent {

    /**
     * Get heart item graphics component.
     *
     * @return heart graphics component
     * */
    GraphicsComponent getHeartGraphicsComponent();

    /**
     * Get coin graphics component.
     *
     * @return coin graphics component
     * */
    GraphicsComponent getCoinGraphicsComponent();

}
