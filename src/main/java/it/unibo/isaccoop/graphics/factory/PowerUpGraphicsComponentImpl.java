package it.unibo.isaccoop.graphics.factory;

import it.unibo.isaccoop.graphics.GraphicsComponent;

public class PowerUpGraphicsComponentImpl implements PowerUpGraphicsComponent {

    @Override
    public GraphicsComponent getCoinUpGraphicsComponent(Boolean isSuper) {
        return isSuper ? (obj, w) -> w.drawElementAsImage(obj, "coin.gif")
                : (obj, w) -> w.drawElementAsImage(obj, "nonShootinhEnemy1.gif");
    }

    @Override
    public GraphicsComponent getHealthUpGraphicsComponent(Boolean isSuper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GraphicsComponent getRangeUpGraphicsComponent(Boolean isSuper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GraphicsComponent getSpeedUpGraphicsComponent(Boolean isSuper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GraphicsComponent getTearsUpGraphicsComponent(Boolean isSuper) {
        // TODO Auto-generated method stub
        return null;
    }

}
