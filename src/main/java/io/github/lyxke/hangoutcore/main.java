package io.github.lyxke.hangoutcore;

import io.github.lyxke.hangoutcore.events.PlayerHungerDamage;
import io.github.lyxke.hangoutcore.events.PlayerWelcomeMessage;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.*;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "HangoutCore", version = "1.0")
@Description("The Core for the Hangout!")
@Author("Hangout Dev Team")
@LoadOrder(PluginLoadOrder.STARTUP)
@LogPrefix("HangoutCore")
public class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        System.out.println("[HangoutCore] » Plugin has started!");
        getServer().getPluginManager().registerEvents(new PlayerWelcomeMessage(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDamage(), this);
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

}
