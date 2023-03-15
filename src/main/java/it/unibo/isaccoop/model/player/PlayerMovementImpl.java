package it.unibo.isaccoop.model.player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Implement the PlayerMovement interface and
 * model player position directly by extending PlayerStatImpl.
 * */
public class PlayerMovementImpl extends PlayerStatImpl implements PlayerMovement {

    /**
     * Player movement constructor.
     * @param x the x position
     * @param y the y position
     * @param height the height of the player
     * @param width the width of the player
     * */
    public PlayerMovementImpl(final double x, final double y, final float height, final float width) {
        super(x, y, height, width);
    }

    /**
     * @return if the movement is available
     * */
    @Override
    public boolean isMovementAvailable() {
        /* collision */
        return true;
    }

    /**
     * Move the player.
     * @param map the map
     * */
    @Override
    public void move(final JFrame map) {
        final float distance = super.getSpeed();
        final double x = super.getPosition().getKey();
        final double y = super.getPosition().getValue();

        map.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                final int keyCode = e.getKeyCode();
                if (isMovementAvailable()) {
                    if (keyCode == KeyEvent.VK_W) {
                        setPlayerPosition(Pair.of(x, y - distance));
                    }
                    if (keyCode == KeyEvent.VK_S) {
                        setPlayerPosition(Pair.of(x, y + distance));
                    }
                    if (keyCode == KeyEvent.VK_A) {
                        setPlayerPosition(Pair.of(x - distance, y));
                    }
                    if (keyCode == KeyEvent.VK_D) {
                        setPlayerPosition(Pair.of(x + distance, y));
                    }
                }
            }
        });
        map.setVisible(true);
    }

    /**
     * Set the new player position.
     * @param position new position
     * */
    @Override
    public void setPlayerPosition(final Pair<Double, Double> position) {
        super.setPosition(position);
    }

    /**
     * Move the bullet.
     * @param map the map
     * */
    /*public void shotBullet(final JFrame map) {
        final float distance = super.getSpeed();
        final float damage = super.getDamage();
        final double x = super.getPosition().getKey();
        final double y = super.getPosition().getValue();

        map.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                final int keyCode = e.getKeyCode();
                Pair<Double, Double> newPosition;
              if (keyCode == KeyEvent.VK_UP) {
               newPosition = Pair.of(x, y - distance);
               PlayerShot bullet = new PlayerShot(0, newPosition, 3, 4, damage, distance);
              }
              if (keyCode == KeyEvent.VK_RIGHT) {
               newPosition = Pair.of(x + distance, y);
               PlayerShot bullet = new PlayerShot(1, newPosition, 3, 4, damage, distance);
              }
              if (keyCode == KeyEvent.VK_DOWN) {
               newPosition = Pair.of(x, y + distance);
               PlayerShot bullet = new PlayerShot(2, newPosition, 3, 4, damage, distance);
              }
              if (keyCode == KeyEvent.VK_LEFT) {
               newPosition = Pair.of(x - distance, y);
               PlayerShot bullet = new PlayerShot(3, newPosition, 3, 4, damage, distance);
              }
            }
        });
        map.setVisible(true);
    }
    */

}
