package it.unibo.isaccoop.model.player;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for the player.
 * */
public class Player extends PlayerMovementImpl {

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
    void hit(final int direction, final float distance) {
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
}
