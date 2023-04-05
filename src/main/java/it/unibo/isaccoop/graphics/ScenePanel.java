package it.unibo.isaccoop.graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import it.unibo.isaccoop.controller.input.KeyboardInputController;
import it.unibo.isaccoop.core.GameEngine;

public class ScenePanel extends JPanel implements KeyListener {

    private static final long serialVersionUID = 1L;
    private final int centerX;
    private final int centerY;
    private final double ratioX;
    private final double ratioY;
    private final GameEngine engine;

    /**
     *
     * @param w
     * @param h
     * @param width
     * @param height
     */
    public ScenePanel(final int w, final int h, final double width, final double height, final GameEngine engine) {
        setSize(w, h);
        centerX = w / 2;
        centerY = h / 2;
        ratioX = w / width;
        ratioY = h / height;
        this.engine = engine;

        this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();

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
