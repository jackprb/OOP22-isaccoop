package it.unibo.isaccoop.test.model.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.player.PlayerStat;
import it.unibo.isaccoop.model.player.PlayerStatImpl;
import it.unibo.isaccoop.model.powerup.CoinUp;
import it.unibo.isaccoop.model.powerup.DamageUp;
import it.unibo.isaccoop.model.powerup.HealthUp;
import it.unibo.isaccoop.model.powerup.PowerUp;
import it.unibo.isaccoop.model.room.Shop;
import it.unibo.isaccoop.model.room.ShopImpl;

class TestShop {
    private final Shop shop = new ShopImpl();
    private final PlayerStat player = new PlayerStatImpl(null);
    private final PowerUp damageUp = new DamageUp();
    private final PowerUp healthUp = new HealthUp();
    private final PowerUp coinUp = new CoinUp();

    /***/
    @Test
    void testPowerUp() {
        //Test shop damage-up
        player.setCoin(10);
        assertEquals(10, player.getCoin());
        damageUp.setSuperItem(true);
        shop.buyItem(player, damageUp);
        assertEquals(6, player.getCoin());
        damageUp.setSuperItem(false);
        shop.buyItem(player, damageUp);
        assertEquals(4, player.getCoin());

        //Test shop coin-up
        coinUp.setSuperItem(true);
        shop.buyItem(player, coinUp);
        assertEquals(8, player.getCoin());
        coinUp.setSuperItem(false);
        shop.buyItem(player, coinUp);
        assertEquals(10, player.getCoin());
        
        player.setCoin(10);
        //Test shop health-up
        healthUp.setSuperItem(true);
        shop.buyItem(player, healthUp);
        assertEquals(6, player.getCoin());
        healthUp.setSuperItem(false);
        shop.buyItem(player, healthUp);
        assertEquals(4, player.getCoin());
        healthUp.setSuperItem(true);
        shop.buyItem(player, healthUp);
        assertEquals(0, player.getCoin());

    }

}
