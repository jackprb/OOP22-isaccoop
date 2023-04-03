package it.unibo.isaccoop.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import it.unibo.isaccoop.controller.input.KeyboardInputController;
import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.model.boundingbox.RectBoundingBox;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.Room;

public class SwingScene implements Scene {

    private JFrame frame;
    private ScenePanel panel;
    private GameEngine engine;
    private Level gameState;

    public SwingScene(Level gameState, GameEngine engine, int w, int h, double width, double height){
        frame = new JFrame("Isaccoop");
        frame.setSize(w,h);
        frame.setMinimumSize(new Dimension(w,h));
        frame.setResizable(false);
        this.gameState = gameState;
        this.engine = engine;
        panel = new ScenePanel(w,h, width, height);
        frame.getContentPane().add(panel);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit(-1);
            }
            public void windowClosed(WindowEvent ev){
                System.exit(-1);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    public void render(){
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame.repaint();
            });
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void renderGameOver(){
        /*
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame.repaint();
            });
        } catch (Exception ex){
            ex.printStackTrace();
        }
        */
    }

    public class ScenePanel extends JPanel implements KeyListener {

        private static final long serialVersionUID = 1L;
        private int centerX;
        private int centerY;
        private double ratioX;
        private double ratioY;
        private Font scoreFont, gameOverFont;
        private Stroke strokeBorder = new BasicStroke(2f);

        public ScenePanel(int w, int h, double width, double height){
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
            ratioX = w/width;
            ratioY = h/height;

            scoreFont = new Font("Verdana", Font.PLAIN, 36);
            gameOverFont = new Font("Verdana", Font.PLAIN, 88);

            this.addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow();

        }

        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2.clearRect(0,0,this.getWidth(),this.getHeight());

            if (gameState.isLevelComplete()){

                /* drawing the score */
                g2.setFont(gameOverFont);
                g2.setColor(Color.BLACK);
                g2.drawString("GAME COMPLETED ", 30, centerY - 50);
                g2.setFont(scoreFont);
                g2.setColor(Color.GREEN);

            } else {
                /* drawing the borders */

                Room scene = gameState.getRooms().stream()
                        .filter(r -> r.getPlayer().isPresent()).findFirst().get();
                RectBoundingBox bbox = (RectBoundingBox) scene.getBox();
                int x0 = getXinPixel(new Point2D(0, 0));
                int y0 = getYinPixel(new Point2D(0, 0));
                int x1 = getXinPixel(new Point2D(bbox.getWidth(), 0));
                int y1 = getYinPixel(new Point2D(0, bbox.getHeight()));

                g2.setColor(Color.BLACK);
                g2.setStroke(strokeBorder);
                g2.drawRect(x0, y0, x1-x0, y1-y0);

                /* drawing the game objects */

                SwingGraphics gr = new SwingGraphics(g2, centerX, centerY, ratioX, ratioY);
                scene.getEnemies().get().forEach( e -> {
                    e.updateGraphics(gr);
                });
            }
        }

        private int getXinPixel(Point2D p){
            return (int) Math.round(centerX + p.getX() * ratioX);
        }

        private int getYinPixel(Point2D p){
            return (int)  Math.round(centerY - p.getY() * ratioY);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            for (KeyboardInputController ctrl: engine.getKeyboardInputControllers()) {
                ctrl.notifyKeyPressed(e.getKeyCode());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            for (KeyboardInputController ctrl: engine.getKeyboardInputControllers()) {
                ctrl.notifyKeyReleased(e.getKeyCode());
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

    }
}