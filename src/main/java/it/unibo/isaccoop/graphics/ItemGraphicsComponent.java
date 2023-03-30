package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;

public class ItemGraphicsComponent implements GraphicsComponent {

    @Override
    public void update(MapElement obj, Graphics w) {
        w.drawItem();

    }

}
