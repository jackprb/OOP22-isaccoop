package it.unibo.isaccoop.model.creator;

import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.item.Item;
import it.unibo.isaccoop.model.powerup.PowerUp;

public class ConcreteCreatorFactory implements CreatorFactory{

    @Override
    public Creator<Enemy> createEnemies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Creator<Enemy> createBoss() {
        // TODO Auto-generated method stub
        return null;
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
