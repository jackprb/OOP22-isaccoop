package it.unibo.isaccoop;

import it.unibo.isaccoop.graphics.GameMenu;

/**
 * MainClass.
 * */
public final class MainClass {

    private MainClass() {
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        //new GameEngineImpl().run();
        new GameMenu().display();
    }
}
