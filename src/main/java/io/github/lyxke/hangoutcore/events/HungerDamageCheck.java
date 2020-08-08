package io.github.lyxke.hangoutcore.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.lyxke.hangoutcore.main;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class HungerDamageCheck implements Listener {

    Map<String, Long> hungerTimer = new HashMap<String, Long>();

    @EventHandler
    //Cancel out vanilla hunger damage mechanic
    public void playerDamageCheck(EntityDamageEvent e) {

        if (e.getCause() == EntityDamageEvent.DamageCause.STARVATION) {
            e.setCancelled(true);
        }



        // Set the player as the entity involved
        if(e.getEntity() == ((Player) e.getEntity()).getPlayer()) {

            Player player = (Player) e.getEntity();
                                /*
                    If food level is less than or at 0,
                     damage the player every 4 seconds by .5 hearts
                     until they eat or reach .5 total health
                     */
            //Check player health is above 1 and empty food level
            while (player.getHealth() > 1 && player.getFoodLevel() <= 0) {
                //Begin timer code

                //If hungerTimer has the player's name,
                if (hungerTimer.containsKey(player.getName())) {
                    if (hungerTimer.get(player.getName()) > System.currentTimeMillis()) {
                        return;
                    } else {
                        player.setHealth(player.getHealth() - 1);
                    }
                }
                hungerTimer.put(player.getName(), System.currentTimeMillis() + (4 * 1000));
            }
        }else{
            return;
        }


    }

}
