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
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.unibo.isaccoop.controller.input.KeyboardInputController;
import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.model.boundingbox.RectBoundingBox;
import it.unibo.isaccoop.model.common.Point2D;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.Room;
/**
 * Represent the scene with Swing.
 *
 */
public class SwingScene implements Scene {

    private static final Logger LOGGER = Logger.getLogger(SwingScene.class.getName());
    private final JFrame frame;
    private final GameEngine engine;
    private final Level gameState;
    private static final int SCORE_FONT = 36;
    private static final int GAME_OVER_FONT = 88;
    /**
     *
     * @param gameState
     * @param engine
     * @param w
     * @param h
     * @param width
     * @param height
     */
    public SwingScene(final Level gameState, final GameEngine engine,
            final int w, final int h, final double width, final double height) {
        final ScenePanel panel;
        frame = new JFrame("Isaccoop");
        frame.setSize(w, h);
        frame.setMinimumSize(new Dimension(w, h));
        frame.setResizable(false);
        this.gameState = gameState;
        this.engine = engine;
        panel = new ScenePanel(w, h, width, height);
        frame.getContentPane().add(panel);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent ev) {
                System.exit(-1);
            }
            @Override
            public void windowClosed(final WindowEvent ev) {
                System.exit(-1);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
    /***/
    @Override
    public void render() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame.repaint();
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }
    /***/
    @Override
    public void renderGameOver() {
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
    /***/
    public class ScenePanel extends JPanel implements KeyListener {

        private static final long serialVersionUID = 1L;
        private final int centerX;
        private final int centerY;
        private final double ratioX;
        private final double ratioY;
        private final Font scoreFont;
        private final Font gameOverFont;
        private final Stroke strokeBorder = new BasicStroke(2f);
        /**
         *
         * @param w
         * @param h
         * @param width
         * @param height
         */
        public ScenePanel(final int w, final int h, final double width, final double height) {
            setSize(w, h);
            centerX = w / 2;
            centerY = h / 2;
            ratioX = w / width;
            ratioY = h / height;

            scoreFont = new Font("Verdana", Font.PLAIN, SCORE_FONT);
            gameOverFont = new Font("Verdana", Font.PLAIN, GAME_OVER_FONT);

            this.addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow();

        }
        /**
         * @param g reference to Graphics.
         */
        @Override
        public void paint(final Graphics g) {
            final Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2.clearRect(0, 0, this.getWidth(), this.getHeight());

            if (gameState.isLevelComplete()) {

                /* drawing the score */
                g2.setFont(gameOverFont);
                g2.setColor(Color.BLACK);
                //g2.drawString("GAME COMPLETED ", 30, centerY - 50);
                g2.setFont(scoreFont);
                g2.setColor(Color.GREEN);

            } else {
                /* drawing the borders */

                final Room scene = gameState.getRooms().stream()
                        .filter(r -> r.getPlayer().isPresent()).findFirst().get();
                final RectBoundingBox bbox = (RectBoundingBox) scene.getBox();
                final int x0 = getXinPixel(new Point2D(0, 0));
                final int y0 = getYinPixel(new Point2D(0, 0));
                final int x1 = getXinPixel(new Point2D(bbox.getWidth(), 0));
                final int y1 = getYinPixel(new Point2D(0, bbox.getHeight()));

                g2.setColor(Color.BLACK);
                g2.setStroke(strokeBorder);
                g2.drawRect(x0, y0, x1 - x0, y1 - y0);

                /* drawing the game objects */

                final SwingGraphics gr = new SwingGraphics(g2, centerX, centerY, ratioX, ratioY);
                scene.getEnemies().get().forEach(e -> {
                    e.updateGraphics(gr);
                });
            }
        }

        private int getXinPixel(final Point2D p) {
            return (int) Math.round(centerX + p.getX() * ratioX);
        }

        private int getYinPixel(final Point2D p) {
            return (int)  Math.round(centerY - p.getY() * ratioY);
        }
        /**
         * @param e reference to KeyEvent.
         */
        @Override
        public void keyPressed(final KeyEvent e) {
            for (final KeyboardInputController ctrl: engine.getKeyboardInputControllers()) {
                ctrl.notifyKeyPressed(e.getKeyCode());
            }
        }
        /**
         * @param e reference to KeyEvent.
         */
        @Override
        public void keyReleased(final KeyEvent e) {
            for (final KeyboardInputController ctrl: engine.getKeyboardInputControllers()) {
                ctrl.notifyKeyReleased(e.getKeyCode());
            }
        }

        @Override
        public void keyTyped(final KeyEvent e) { }

    }
}
