package it.unibo.isaccoop.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import it.unibo.isaccoop.model.boundingbox.RectBoundingBox;
import it.unibo.isaccoop.model.room.Level;
import it.unibo.isaccoop.model.room.Room;

public class RoomComponent extends JComponent {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final Font scoreFont;
    private final Font gameOverFont;
    private final Level gameState;
    private final double ratioX;
    private final double ratioY;

    private static final int SCORE_FONT = 36;
    private static final int GAME_OVER_FONT = 88;

    public RoomComponent(final Level gameState, final double ratioX, final double ratioY) {
        scoreFont = new Font("Verdana", Font.PLAIN, SCORE_FONT);
        gameOverFont = new Font("Verdana", Font.PLAIN, GAME_OVER_FONT);

        this.gameState = gameState;
        this.ratioX = ratioX;
        this.ratioY = ratioY;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

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

            g2.drawRect(0, 0, bbox.getWidth() * ((int) ratioX), bbox.getHeight() * ((int)ratioY));

            /* drawing the game objects */

            final SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY);

            scene.updateGraphics(gr);
            scene.getPlayer().ifPresent(p -> p.updateGraphics(gr));
            scene.getEnemies().ifPresent(l -> l.forEach(e -> e.updateGraphics(gr)));
            scene.getItems().ifPresent(l -> l.forEach(i -> i.updateGraphics(gr)));
            scene.getPowerUps().ifPresent(l -> l.forEach(p -> p.updateGraphics(gr)));

        }
    }

}
