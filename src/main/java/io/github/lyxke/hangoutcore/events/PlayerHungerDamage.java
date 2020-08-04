package io.github.lyxke.hangoutcore.events;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import java.util.concurrent.TimeUnit;

public class PlayerHungerDamage implements Listener {

    // Simulate Normal hunger mechanic on any other modes
    @EventHandler
    public void playerHungerDamage(FoodLevelChangeEvent e, EntityDamageEvent d){

        // Set the player as the entity involved
        Player player = (Player) e.getEntity();

        //Cancel out vanilla hunger damage mechanic
        if(d.getCause() == EntityDamageEvent.DamageCause.STARVATION){
            d.setCancelled(true);
        }

        /*
         If food level is less than or at 0,
         damage the player every 4 seconds by .5 hearts
         until they eat or reach .5 total health
         */
        if (e.getFoodLevel() <= 0) {
            while(player.getHealth() > .5){
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                player.setHealth(player.getHealth() - .5);
            }
        }
    }

}
