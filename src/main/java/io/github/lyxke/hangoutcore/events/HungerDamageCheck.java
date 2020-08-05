package io.github.lyxke.hangoutcore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.concurrent.TimeUnit;

public class HungerDamageCheck implements Listener {

    @EventHandler
    //Cancel out vanilla hunger damage mechanic
    public void playerDamageCheck(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.STARVATION){
            e.setCancelled(true);

            // Set the player as the entity involved
            Player player = (Player) e.getEntity();

            /*
             If food level is less than or at 0,
             damage the player every 4 seconds by .5 hearts
             until they eat or reach .5 total health
             */
            if (player.getFoodLevel() <= 0) {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                while(player.getHealth() > 1){
                    player.setHealth(player.getHealth() - 1);
                }
            }

        }
    }

}
