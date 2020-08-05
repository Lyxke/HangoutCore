package io.github.lyxke.hangoutcore;

import io.github.lyxke.hangoutcore.commands.HungerCommand;
import io.github.lyxke.hangoutcore.commands.SettingsCommand;
import io.github.lyxke.hangoutcore.events.HungerDamageCheck;
import io.github.lyxke.hangoutcore.events.PlayerHungerDamage;
import io.github.lyxke.hangoutcore.events.PlayerWelcomeMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;


public class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        System.out.println("[HangoutCore] » Plugin has started!");

        getServer().getPluginManager().registerEvents(new PlayerWelcomeMessage(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDamage(), this);
        getServer().getPluginManager().registerEvents(new SettingsCommand(), this);
        getServer().getPluginManager().registerEvents(new HungerDamageCheck(), this);

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

}
