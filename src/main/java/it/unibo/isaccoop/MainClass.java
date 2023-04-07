package it.unibo.isaccoop;

import it.unibo.isaccoop.graphics.GameMenu;

/**
 * Main class of the program.
 */
public final class MainClass {

    private MainClass() {
    }

    /**
     * @param args ignored
     */
    public static void main(final String[] args) {
        new GameMenu().display();
    }
}
