package it.unibo.isaccoop.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.unibo.isaccoop.controller.input.KeyboardInputController;
import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.Room;

/**
 * Represents the game scene, implemented with Swing.
 */
public class SwingScene implements Scene {

    private static final Logger LOGGER = Logger.getLogger(SwingScene.class.getName());
    private final JFrame frame;
    private final GameEngine engine;
    private final Level gameState;
    private static final int GAME_OVER_FONT = 30;

    private static final int MINIMAP_HEIGHT = 150;
    private static final int ROOM_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int ROOM_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()
            - MINIMAP_HEIGHT;

    /**
     * Constructor.
     * @param gameState the level to play
     * @param engine the {@link GameEngine}
     */
    public SwingScene(final Level gameState, final GameEngine engine) {

        final JPanel containerPanel = new JPanel(new BorderLayout());
        frame = new JFrame("Isaccoop");
        frame.setSize(ROOM_WIDTH, ROOM_HEIGHT + MINIMAP_HEIGHT);
        frame.setPreferredSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT + MINIMAP_HEIGHT));
        frame.setMinimumSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT + MINIMAP_HEIGHT));
        frame.setResizable(true);
        this.gameState = gameState;
        this.engine = engine;
        containerPanel.add(new ScenePanel(ROOM_WIDTH, ROOM_HEIGHT, gameState.getCurrentRoom().getWidth(),
                gameState.getCurrentRoom().getHeight()));
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
        private final Font gameOverFont;
        private final Color backgroundColor = new Color(150, 75, 50);

        /**
         *
         * @param w
         * @param h
         * @param width
         * @param height
         */
        public ScenePanel(final int w, final int h, final double width, final double height) {
            setSize(w, h);
            setPreferredSize(new Dimension(w, h));
            setMinimumSize(new Dimension(w, h));
            centerX = w / 2;
            centerY = h / 2;
            ratioX = this.getWidth() / width;
            ratioY = this.getHeight() / height;

            gameOverFont = new Font("Verdana", Font.PLAIN, w / GAME_OVER_FONT);

            this.setLayout(new BorderLayout());
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

            // hidden button to go back to main menu
            final JButton btnGoToMenu = new JButton(" ");
            btnGoToMenu.addActionListener(l -> {
                new GameMenu().display();
                frame.setVisible(false);
            });

            if(SwingScene.this.engine.getGameLoop().isPause()) {

                /* drawing the score */
                g2.setFont(gameOverFont);
                g2.setColor(this.backgroundColor);
                g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                g2.setColor(Color.BLACK);
                this.drawCenteredString(g2, "PAUSE", getVisibleRect(), gameOverFont);

            } else if (gameState.isLevelComplete()) {
                /* drawing the score */
                g2.setFont(gameOverFont);
                g2.setColor(this.backgroundColor);
                g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                g2.setColor(Color.BLACK);
                this.drawCenteredString(g2, "GAME COMPLETED", getVisibleRect(), gameOverFont);
                this.add(btnGoToMenu);

            } else if (gameState.getPlayer().isDead()) {
                /* drawing the score */
                g2.setFont(gameOverFont);
                g2.setColor(this.backgroundColor);
                g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                g2.setColor(Color.BLACK);
                this.drawCenteredString(g2, "GAME OVER", getVisibleRect(), gameOverFont);
                this.add(btnGoToMenu);

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

        /**
         * Draw a String centered in the middle of a Rectangle.
         *
         * @param g The Graphics instance.
         * @param text The String to draw.
         * @param rect The Rectangle to center the text in.
         * @param font the Font of the text
         */
        private void drawCenteredString(final Graphics g, final String text, final Rectangle rect, final Font font) {
            // Get the FontMetrics
            final FontMetrics metrics = g.getFontMetrics(font);
            // Determine the X coordinate for the text
            final int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
            // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
            final int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
            // Set the font
            g.setFont(font);
            // Draw the String
            g.drawString(text, x, y);
        }
    }
}
