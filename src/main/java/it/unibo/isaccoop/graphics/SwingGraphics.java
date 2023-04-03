package it.unibo.isaccoop.graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import it.unibo.isaccoop.model.common.MapElement;
/**
 * Represents the graphics in the swing.
 *
 */
public class SwingGraphics implements Graphics {

    private java.awt.Graphics g2;

    private final double ratioX;
    private final double ratioY;
    /**
     *
     * @param g2
     * @param centerX
     * @param centerY
     * @param ratioX
     * @param ratioY
     */
    public SwingGraphics(final Graphics2D g2, final double ratioX, final double ratioY) {
        this.g2 = g2.create();
        this.ratioX = ratioX;
        this.ratioY = ratioY;
    }

    @Override
    public void drawRoom(final MapElement room) {
        Image img = Toolkit.getDefaultToolkit().getImage("resources/floor.png");
        this.g2.drawImage(img, (int) room.getCoords().getX(), (int) room.getCoords().getY(), null);
    }

    @Override
    public void drawItem() {

    }

    @Override
    public void drawPlayer(final MapElement player) {
        Image img = Toolkit.getDefaultToolkit().getImage("resources/player.gif");
        this.g2.drawImage(img, (int) player.getCoords().getX(), (int) player.getCoords().getY(), null);
    }

    @Override
    public void drawEnemy() {
    }

}
