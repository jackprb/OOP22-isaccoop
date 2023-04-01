package it.unibo.isaccoop.graphics;

import java.awt.Graphics2D;

public class SwingGraphics implements Graphics {

    private Graphics2D g2;

    private int centerX;
    private int centerY;
    private double ratioX;
    private double ratioY;

    public SwingGraphics(Graphics2D g2, int centerX, int centerY, double ratioX, double ratioY){
            this.g2 = g2;
            this.centerX = centerX;
            this.centerY = centerY;
            this.ratioX = ratioX;
            this.ratioY = ratioY;
    }

    @Override
    public void drawRoom() {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawItem() {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawPlayer() {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawEnemy() {
        // TODO Auto-generated method stub

    }

}
