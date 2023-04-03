package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;
/***/
public class PlayerGraphicsComponent implements GraphicsComponent {
    /***/
    @Override
    public void update(final MapElement obj, final Graphics w) {
        w.drawPlayer(obj);

    }

}
