package it.unibo.isaccoop.graphics;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
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
            final int w, final int h) {

        final JPanel containerPanel = new JPanel(new BorderLayout());
        frame = new JFrame("Isaccoop");
        frame.setSize(w, h);
        frame.setMinimumSize(new Dimension(w, h));
        frame.setResizable(false);
        this.gameState = gameState;
        this.engine = engine;
        containerPanel.add(new ScenePanel(w, h, gameState.getCurrentRoom().getWidth(), gameState.getCurrentRoom().getHeight()),
                BorderLayout.CENTER);
        containerPanel.add(new MinimapGUI(gameState), BorderLayout.PAGE_END);
        frame.getContentPane().add(containerPanel);
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
        //
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
        private final Stroke strokeBorder;

        private final MinimapGUI minimap;
        /**
         *
         * @param w
         * @param h
         * @param width
         * @param height
         */
        public ScenePanel(final int w, final int h, final double width, final double height) {
            this.minimap = new MinimapGUI(gameState);
            setSize(w, h);
            centerX = w / 2;
            centerY = h / 2;
            ratioX = w / width;
            ratioY = h / height;
            this.strokeBorder = new BasicStroke(2f);

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

                /* drawing the game objects */

                final SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY);

                scene.updateGraphics(gr);
                scene.getPlayer().ifPresent(p -> p.updateGraphics(gr));
                scene.getEnemies().ifPresent(l -> l.forEach(e -> e.updateGraphics(gr)));
                scene.getItems().ifPresent(l -> l.forEach(i -> i.updateGraphics(gr)));
                scene.getPowerUps().ifPresent(l -> l.forEach(p -> p.updateGraphics(gr)));

                this.minimap.paint(g2);

            }
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
