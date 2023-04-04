package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;

/***/
public interface Graphics {

    /**
     * Method to draw a MapElement as image.
     *
     * @param element map element
     * @param imageName element image name
     * */
    void drawElementAsImage(MapElement element, String imageName);

}
