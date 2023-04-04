package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

/***/
public final class ConcreteEnemyGraphicsComponentFactory implements EnemyGraphicsComponentFactory {

    @Override
    public GraphicsComponent getNonShootingGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "nonShootinhEnemy1.gif");
    }

    @Override
    public GraphicsComponent getShootingGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "shootinhEnemy.gif");
    }

    @Override
    public GraphicsComponent getBossGraphicsComponent() {
        return (obj, w) -> w.drawElementAsImage(obj, "EnemyBoss.gif");
    }

}
