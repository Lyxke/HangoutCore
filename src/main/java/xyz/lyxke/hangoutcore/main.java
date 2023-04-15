package xyz.lyxke.hangoutcore;

import xyz.lyxke.hangoutcore.commands.HungerCommand;
import xyz.lyxke.hangoutcore.commands.SettingsCommand;
import xyz.lyxke.hangoutcore.events.HungerDamageCheck;
import xyz.lyxke.hangoutcore.events.MenuHandler;
import xyz.lyxke.hangoutcore.events.PlayerHungerDamage;
import xyz.lyxke.hangoutcore.events.PlayerWelcomeMessage;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        System.out.println("[HangoutCore] » Plugin has started!");

        getServer().getPluginManager().registerEvents(new PlayerWelcomeMessage(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDamage(), this);
        getServer().getPluginManager().registerEvents(new SettingsCommand(), this);
        getServer().getPluginManager().registerEvents(new HungerDamageCheck(), this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new MenuHandler(), this);

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
