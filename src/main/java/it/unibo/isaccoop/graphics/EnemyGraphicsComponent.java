package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;

public class EnemyGraphicsComponent implements GraphicsComponent {

    @Override
    public void update(MapElement obj, Graphics w) {
        w.drawEnemy();
    }

}
