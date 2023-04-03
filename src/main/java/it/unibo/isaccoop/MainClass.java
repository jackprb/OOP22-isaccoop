package it.unibo.isaccoop;

import it.unibo.isaccoop.core.GameEngineImpl;

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
        new GameEngineImpl().run();
    }
}
