package it.unibo.isaccoop.model.collision;

import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;

public class ConcreteEventFactory implements EventFactory {

    @Override
    public Event getItemPickUpEvent(Item target) {
        return (room) -> {};
    }

    @Override
    public Event getEnemyShot(Enemy enemy) {
        return (room) -> {};
    }

    @Override
    public Event getEnemyHitEvent() {
        return (room) -> {};
    }

}
