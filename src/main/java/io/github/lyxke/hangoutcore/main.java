package io.github.lyxke.hangoutcore;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.*;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.util.concurrent.TimeUnit;

@Plugin(name = "HangoutCore", version = "1.0")
@Description("The Core for the Hangout!")
@Author("Lyxke Zyxcelai")
@LoadOrder(PluginLoadOrder.STARTUP)
@LogPrefix("HangoutCore")
public class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        System.out.println("Plugin has started!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){
        System.out.println("Plugin has stopped!");
    }

    // Welcome message for all players
    @EventHandler
    public void playerJoinMessage(PlayerJoinEvent e){

        // Set player to the one that just joined the server
        Player player = e.getPlayer();

        // Wait 5 seconds to account for Bedrock players joining via the proxy
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        // Actual welcome message
        player.sendMessage(ChatColor.AQUA + "Welcome to the Hangout, " + player.getName() + "!");
        player.sendMessage(ChatColor.AQUA + "Please register using a password, then login using that password");
        player.sendMessage(ChatColor.AQUA + "If you have any other questions, please also contact me! :D");
        player.sendMessage(ChatColor.AQUA + "My discord is Zyxcelai and the ID is 7502");
        player.sendMessage(ChatColor.AQUA + "Thanks for playing! :D");

    }

    // Simulate Hard hunger mechanic on any other modes
    @EventHandler
    public void playerHungerDamage(FoodLevelChangeEvent e, EntityDamageEvent d){

        // Set the player as the entity involved
        Player player = (Player) e.getEntity();

        if(d.getCause() == EntityDamageEvent.DamageCause.STARVATION){
            d.setCancelled(true);
        }

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
/*    @EventHandler
    public void playerDeathCount(PlayerDeathEvent e){
        Player player = e.
    }
*/

}
