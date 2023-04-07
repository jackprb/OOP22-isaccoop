package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
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

    private static final int MINIMAP_HEIGHT = 100;
    private static final int ROOM_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int ROOM_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()
            - MINIMAP_HEIGHT * 2;

    /**
     * Constructor.
     * @param gameState the level to play
     * @param engine the {@link GameEngine}
     */
    public SwingScene(final Level gameState, final GameEngine engine) {

        final JPanel containerPanel = new JPanel(new BorderLayout());
        frame = new JFrame("Isaccoop");
        frame.setSize(ROOM_WIDTH, ROOM_HEIGHT + MINIMAP_HEIGHT);
        frame.setMinimumSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT + MINIMAP_HEIGHT));
        frame.setResizable(false);
        this.gameState = gameState;
        this.engine = engine;
        containerPanel.add(new ScenePanel(ROOM_WIDTH, ROOM_HEIGHT, gameState.getCurrentRoom().getWidth(),
                gameState.getCurrentRoom().getHeight()), BorderLayout.CENTER);
        containerPanel.add(new OverlayGUI(gameState, ROOM_WIDTH, MINIMAP_HEIGHT), BorderLayout.PAGE_END);
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

                /* drawing the game objects */

                final SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY);

                scene.updateGraphics(gr);
                scene.getItems().ifPresent(l -> l.forEach(i -> i.updateGraphics(gr)));
                scene.getPowerUps().ifPresent(l -> l.forEach(p -> p.updateGraphics(gr)));
                scene.getEnemies().ifPresent(l -> l.forEach(e -> {
                    e.updateGraphics(gr);
                    e.getWeaponShots().ifPresent(shots -> shots.forEach(shot -> shot.updateGraphics(gr)));
                }));
                scene.getPlayer().ifPresent(p -> {
                    p.updateGraphics(gr);
                    p.getWeaponShots().forEach(shot -> shot.updateGraphics(gr));
                });

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
            engine.getActionController().notifyKeyPressed(e.getKeyCode());
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
