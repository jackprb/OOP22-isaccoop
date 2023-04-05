package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public final class ConcreteRoomGraphicsComponentFactory extends AbstractGraphicsComponentFactory implements RoomGraphicsComponentFactory {

    @Override
    public GraphicsComponent getRoomGraphicsComponent() {
        return super.getElementAsImageGraphicsComponent("floor.png");
    }

}
