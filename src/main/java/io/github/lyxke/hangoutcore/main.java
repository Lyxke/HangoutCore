package io.github.lyxke.hangoutcore;

import io.github.lyxke.hangoutcore.commands.HungerCommand;
import io.github.lyxke.hangoutcore.commands.SettingsCommand;
import io.github.lyxke.hangoutcore.events.HungerDamageCheck;
import io.github.lyxke.hangoutcore.events.PlayerHungerDamage;
import io.github.lyxke.hangoutcore.events.PlayerWelcomeMessage;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        System.out.println("[HangoutCore] » Plugin has started!");

        getServer().getPluginManager().registerEvents(new PlayerWelcomeMessage(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDamage(), this);
        getServer().getPluginManager().registerEvents(new SettingsCommand(), this);
        getServer().getPluginManager().registerEvents(new HungerDamageCheck(), this);
        getServer().getPluginManager().registerEvents(this, this);

        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("hunger").setExecutor(new HungerCommand());


    }

    @Override
    public void onDisable(){
        System.out.println("[HangoutCore] » Plugin has stopped!");
    }


/*    @EventHandler
    public void playerDeathCount(PlayerDeathEvent e){
        Player player = e.
    }
*/

    @EventHandler
    //Cancel out vanilla hunger damage mechanic
    public void playerDamageCheck(EntityDamageEvent e){

        if(e.getCause() == EntityDamageEvent.DamageCause.STARVATION){

            e.setCancelled(true);

            BukkitTask task = new BukkitRunnable() {
                public void run() {

                    // Set the player as the entity involved
                    Player player = (Player) e.getEntity();
                    /*
                    If food level is less than or at 0,
                     damage the player every 4 seconds by .5 hearts
                     until they eat or reach .5 total health
                     */
                    //Check player health is above 1 and empty food level
                    while(player.getHealth() > 1 && player.getFoodLevel() <= 0){
                        player.setHealth(player.getHealth() - 1);
                    }
                }
            }.runTaskTimer(this,0,80L);
        }
    }

}
