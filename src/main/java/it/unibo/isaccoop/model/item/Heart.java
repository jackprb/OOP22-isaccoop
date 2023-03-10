package it.unibo.isaccoop.model.item;

import it.unibo.isaccoop.model.player.PlayerStat;

/**
 *
 * */
public class Heart extends AbstractItem {
    private static final int HEART_UP = 1;

    /**
     *
     * */
    @Override
    public void interact(final PlayerStat p) {
        if (p.getHeart() < p.getMaxHeart()) {
            p.setHeart(p.getHeart() + HEART_UP);
        }
        /*
         * TODO Gestione per far sì che il cuore resti dov'è e gestione
         * delle collisioni
         * */
    }

}
