package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;
/***/
public class EnemyGraphicsComponent implements GraphicsComponent {
    /**
     * @param obj reference to MapElement
     * @param w reference to Graphics
     */
    @Override
    public void update(final MapElement obj, final Graphics w) {
        w.drawEnemy();
    }

}
