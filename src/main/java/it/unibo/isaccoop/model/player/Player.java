package it.unibo.isaccoop.model.player;

import java.util.ArrayList;
import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Removable;
import it.unibo.isaccoop.model.enemy.Hitable;

/**
 * The class for the player.
 * */
public class Player extends PlayerMovementImpl implements Removable, Hitable {

    /**
     * Time since last shot.
     * */
    private long timeSinceLastShot;

    /***/
    private final List<PlayerShot> shots = new ArrayList<>();

    /**
     * @param direction the direction in which the player moves
     * */
    void move(final int direction) {
        super.update(direction);
    }

    /**
     * @param direction the direction in which the bullet is fired
     * @param distance the distance between the player and the end of the room
     * */
    void hit(final int direction, final float distance) {       //distance da togliere, usare Vector2D
        if (System.currentTimeMillis() - timeSinceLastShot > super.getTears()) {
            shots.add(new PlayerShot(direction, super.getCoords(), super.getDamage()));
            this.timeSinceLastShot = System.currentTimeMillis();
        }
        this.shots.forEach(shot -> shot.bulletDirection(shot.getDirection(),  distance));
    }

    /**
     * @return the list of bullets fired.
     * */
    public List<PlayerShot> getShot() {
        return List.copyOf(shots);
    }

    /**
     * Remove the bullet 'e' from the list.
     * @param e
     */
    @Override
    public void remove(final MapElement e) {
        this.shots.remove(e);
    }

    /**
     * @param player
     * */
    @Override
    public void onHit(final PlayerStat player) {
    }

}
