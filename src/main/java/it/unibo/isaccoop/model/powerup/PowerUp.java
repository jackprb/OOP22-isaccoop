package it.unibo.isaccoop.model.powerup;

import it.unibo.isaccoop.model.item.AbstractItem;
import it.unibo.isaccoop.model.player.PlayerStat;

/**
 *
 * */
public abstract class PowerUp extends AbstractItem {
    private boolean superItem;

    /***/
    @Override
    public abstract void interact(PlayerStat p);
    /**
     * @return true if is a super item
     * */
    public boolean isSuperItem() {
        return superItem;
    }
    /**
     * @param superItem true for change boolean variable
     * */
    public void setSuperItem(final boolean superItem) {
        this.superItem = superItem;
    }

}
