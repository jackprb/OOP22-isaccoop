package it.unibo.isaccoop.model.creator;

import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.PowerUp;

public interface CreatorFactory {

    Creator<Enemy> createEnemies();

    Creator<Enemy> createBoss();

    Creator<PowerUp> createShopPowerUps();

    Creator<PowerUp> createTreasurePowerUps();

    Creator<Item> createItems();

}
