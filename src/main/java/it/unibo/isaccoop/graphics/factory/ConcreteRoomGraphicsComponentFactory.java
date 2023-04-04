package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public final class ConcreteRoomGraphicsComponentFactory implements RoomGraphicsComponentFactory {

    @Override
    public GraphicsComponent getRoomGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "floor.png");
    }

}
