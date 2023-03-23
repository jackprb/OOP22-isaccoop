package it.unibo.isaccoop.model.creator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.enemy.NonShootingEnemy;
import it.unibo.isaccoop.model.enemy.ShootingEnemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.PowerUp;

public class ConcreteCreatorFactory implements CreatorFactory{

    private final static int MAX_ENEMIES = 5;

    @Override
    public Creator<Enemy> createEnemies() {
        return () -> Stream.iterate(0, i -> i + 1)
                .limit(ThreadLocalRandom.current().nextInt(ConcreteCreatorFactory.MAX_ENEMIES) + 1)
                .map(i -> ThreadLocalRandom.current().nextBoolean() ? new NonShootingEnemy() : new ShootingEnemy())
                .collect(Collectors.toList());
    }

    @Override
    public Creator<Enemy> createBoss() {
        return () -> List.of();
    }

    @Override
    public Creator<PowerUp> createShopPowerUps() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Creator<PowerUp> createTreasurePowerUps() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Creator<Item> createItems() {
        // TODO Auto-generated method stub
        return null;
    }

}
