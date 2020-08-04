package io.github.lyxke.hangoutcore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.concurrent.TimeUnit;

public class PlayerHungerDamage implements Listener {


    // Simulate Normal hunger mechanic on any other modes
    @EventHandler
    public void playerHungerDamage(FoodLevelChangeEvent e){

        // Set the player as the entity involved
        Player player = (Player) e.getEntity();

        /*
         If food level is less than or at 0,
         damage the player every 4 seconds by .5 hearts
         until they eat or reach .5 total health
         */
        if (player.getFoodLevel() <= 0) {
            while(e.getEntity().getHealth() > 1){
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                player.setHealth(player.getHealth() - 1);
            }
        }
    }

}
