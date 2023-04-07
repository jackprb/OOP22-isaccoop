package it.unibo.isaccoop.graphics;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import it.unibo.isaccoop.model.boundingbox.CircleBoundingBox;
import it.unibo.isaccoop.model.common.MapElement;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.room.Room;

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

       if(element instanceof Room) {
           var room = ((Room) element);
           this.g2.drawImage(imageIcon.getImage(), 0, 0, (int) Math.round(room.getWidth() * this.ratioX), (int) Math.round(room.getHeight() * this.ratioY),null);
       } else {
           var sy2 = imageIcon.getImage().getHeight(null);
           var sx2 = imageIcon.getImage().getWidth(null);
           //var h = this.getYinPixel(element.getCoords()) - centerY;
           //var w = this.getXinPixel(element.getCoords()) - centerX;
           //this.g2.drawImage(imageIcon.getImage(), w, h, null);
           var delta = this.getDeltaXinPixel(((CircleBoundingBox)element.getBox()).getRadius());

           var dx1 = this.getXinPixel(element.getCoords()) - delta;
           var dy1 = this.getYinPixel(element.getCoords()) - delta;
           var dx2 = this.getXinPixel(element.getCoords()) + delta;
           var dy2 = this.getYinPixel(element.getCoords()) + delta;


           this.g2.drawImage(imageIcon.getImage(),
                   dx1,
                   dy1,
                   dx2,
                   dy2,
                   0,
                   0,
                   sx2,
                   sy2,
                   null);
       }

    }

    private int getXinPixel(final Point2D p) {
        return (int) Math.round(p.getX() * ratioX);
    }

    private int getYinPixel(final Point2D p) {
        return (int)  Math.round(p.getY() * ratioY);
    }

    private int getDeltaXinPixel(double dx){
        return (int)  Math.round(dx * ratioX);
    }

}
