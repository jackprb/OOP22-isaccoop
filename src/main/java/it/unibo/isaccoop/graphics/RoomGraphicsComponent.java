package it.unibo.isaccoop.graphics;

import it.unibo.isaccoop.model.common.MapElement;

public class RoomGraphicsComponent implements GraphicsComponent{

    @Override
    public void update(MapElement obj, Graphics w) {
        w.drawRoom(obj);
    }

}
