package io.github.lyxke.hangoutcore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class HungerDamageCheck implements Listener {

    @EventHandler
    //Cancel out vanilla hunger damage mechanic
    public void playerDamageCheck(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.STARVATION){
            e.setCancelled(true);
        }
    }

}
