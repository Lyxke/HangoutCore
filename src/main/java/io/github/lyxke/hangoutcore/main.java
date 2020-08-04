package io.github.lyxke.hangoutcore;

import io.github.lyxke.hangoutcore.commands.SettingsCommand;
import io.github.lyxke.hangoutcore.events.PlayerHungerDamage;
import io.github.lyxke.hangoutcore.events.PlayerWelcomeMessage;
import org.bukkit.event.Listener;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.permission.ChildPermission;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.plugin.*;
import org.bukkit.plugin.java.annotation.plugin.author.Author;


public class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        System.out.println("[HangoutCore] » Plugin has started!");
        getServer().getPluginManager().registerEvents(new PlayerWelcomeMessage(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerDamage(), this);
        getServer().getPluginManager().registerEvents(new SettingsCommand(), this);

        getCommand("settings").setExecutor(new SettingsCommand());
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
