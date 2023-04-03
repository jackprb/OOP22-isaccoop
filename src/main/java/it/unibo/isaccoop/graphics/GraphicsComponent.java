package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;
/***/
public interface GraphicsComponent {
    /**
     *
     * @param obj reference to MapElement
     * @param w reference to Graphics
     */
    void update(MapElement obj, Graphics w);

}
