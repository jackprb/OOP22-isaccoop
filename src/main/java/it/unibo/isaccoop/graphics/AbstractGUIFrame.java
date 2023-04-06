package it.unibo.isaccoop.graphics;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Abstract class that implements common methods of {@link GUIFrame}.
 */
public abstract class AbstractGUIFrame implements GUIFrame {

    private final JFrame frame = new JFrame("");
    private int frameResizeProportion = 2;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTitle(final String title) {
        this.frame.setTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display() {
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize(sw / frameResizeProportion, sh / frameResizeProportion);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        this.frame.setLocationByPlatform(true);
        this.updateView();
        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        this.frame.setVisible(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setResizeProportion(final int proportion) {
        this.frameResizeProportion = proportion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JFrame getJFrame() {
        return this.frame;
    }
}
