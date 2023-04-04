package it.unibo.isaccoop.graphics;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import it.unibo.isaccoop.model.common.MapElement;

/**
 * Represents the graphics in the swing.
 */
public final class SwingGraphics implements Graphics {

    private static final String RES_PATH = "it/unibo/isaccoop/images/";

    private java.awt.Graphics g2;

    private final double ratioX;
    private final double ratioY;

    /**
     *
     * @param g2
     * @param ratioX
     * @param ratioY
     */
    public SwingGraphics(final Graphics2D g2, final double ratioX, final double ratioY) {
        this.g2 = g2.create();
        this.ratioX = ratioX;
        this.ratioY = ratioY;
    }

    @Override
    public void drawElementAsImage(final MapElement element, final String imageName) {
       var imageIcon = new ImageIcon(ClassLoader.getSystemResource(RES_PATH + imageName));
       this.g2.drawImage(imageIcon.getImage(), (int) element.getCoords().getX(), (int) element.getCoords().getY(), null);
    }

}
