package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public final class ConcreteEnemyGraphicsComponentFactory extends AbstractGraphicsComponentFactory implements EnemyGraphicsComponentFactory {

    @Override
    public GraphicsComponent getNonShootingGraphicsComponent() {
        return super.getElementAsImageGraphicsComponent("nonShootinhEnemy1.gif");
    }

    @Override
    public GraphicsComponent getShootingGraphicsComponent() {
        return super.getElementAsImageGraphicsComponent("shootinhEnemy.gif");
    }

    @Override
    public GraphicsComponent getBossGraphicsComponent() {
        return super.getElementAsImageGraphicsComponent("EnemyBoss.gif");
    }

}
