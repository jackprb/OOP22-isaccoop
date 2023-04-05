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
class TestItem {
    private final PlayerStat stat = new PlayerStatImpl(null);
    private final Item coin = new Coin();
    private final Item heart = new Heart();
    private final PowerUp damageUp = new DamageUp();

    /***/
    @Test
    void testPowerUp() {
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
    }

    /***/
    @Test
    void testItem() {

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
