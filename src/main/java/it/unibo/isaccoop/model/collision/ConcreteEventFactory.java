package it.unibo.isaccoop.model.collision;

import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;

/***/
public final class ConcreteEventFactory implements EventFactory {

    @Override
    public Event getItemPickUpEvent(final Item target) {
        return room -> room.getPlayer().ifPresent(target::interact);
    }

    @Override
    public Event getEnemyShot(final Enemy enemy) {
        return room -> room.getPlayer().ifPresent(enemy::onHit);
    }

    @Override
    public Event getEnemyHitEvent() {
        return room -> room.getPlayer().ifPresent(player -> player.setHeart(0));
    }

}
