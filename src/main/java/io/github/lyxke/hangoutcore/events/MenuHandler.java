package io.github.lyxke.hangoutcore.events;

import io.github.lyxke.hangoutcore.commands.SettingsCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;


public class MenuHandler implements Listener {

    SettingsCommand settingsC = new SettingsCommand();

    PlayerDeathEvent de;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){

        Player deplayer = de.getEntity();
        Player eplayer = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Player Settings")){
            e.setCancelled(false);
            if(e.getCurrentItem() == null){
                return;
            }
            else if(e.getCurrentItem().getItemMeta() == settingsC.skullmeta){
                de.setDeathMessage(ChatColor.GOLD + deplayer.getDisplayName() + ChatColor.WHITE + " reset their player.");
                deplayer.setHealth(0);
            }
        }
    }

}
