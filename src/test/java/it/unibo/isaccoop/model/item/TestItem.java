package it.unibo.isaccoop.model.item;

import it.unibo.isaccoop.model.player.PlayerStat;
import it.unibo.isaccoop.model.player.PlayerStatImpl;
import it.unibo.isaccoop.model.powerup.DamageUp;
import it.unibo.isaccoop.model.powerup.PowerUp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 *
 * Class to test item.
 *
 */
public class TestItem {
    private PlayerStat stat = new PlayerStatImpl(null);
    private Item coin = new Coin();
    private Item heart = new Heart();
    private PowerUp damageUp = new DamageUp();

    /***/
    @Test
    void testItem() {
        /**
         * Test PowerUp.
         */
        assertEquals(1, stat.getDamage());
        damageUp.setSuperItem(true);
        damageUp.interact(stat);
        assertEquals(3, stat.getDamage());
        damageUp.setSuperItem(false);
        damageUp.interact(stat);
        assertEquals(4, stat.getDamage());

        /**
         * Test Item Coin.
         * */
        coin.interact(stat);
        assertEquals(1, stat.getCoin());

        /**
         * Test Item Heart.
         */
        assertEquals(3, stat.getHeart());
        heart.interact(stat);
        assertEquals(3, stat.getHeart());


    }
}
