package it.unibo.isaccoop.model.collision;

import it.unibo.isaccoop.model.action.ShootingHitStrategy;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.weapon.WeaponShot;

/***/
public final class ConcreteEventFactory implements EventFactory {

    @Override
    public Event getItemPickUpEvent(final Item target) {
        return room -> room.getPlayer().ifPresent(player -> {
            target.interact(player);
            room.remove(target);
        });
    }

    @Override
    public Event getEnemyShotEvent(final Enemy enemy) {
        return room -> room.getPlayer().ifPresent(player -> {
            player.onHit(enemy);
            if(enemy.getHearts() == 0) {
                room.remove(enemy);
            }
        });
    }

    @Override
    public Event getEnemyHitEvent(final Enemy enemy) {
        return room -> room.getPlayer().ifPresent(enemy::onHit);
    }

    @Override
    public Event getShotToBoundsEvent(final WeaponShot shot) {
        return room -> {
            room.getPlayer().ifPresent(p -> ((ShootingHitStrategy)p.getHitStrategy()).removeShot(shot));
            room.getEnemies()
            .ifPresent(enemies ->
                enemies.forEach(enemy ->
                    enemy.getWeaponShots().ifPresent(shots ->
                    ((ShootingHitStrategy) enemy.getHitStrategy()).removeShot(shot))));
        };
    }

}
