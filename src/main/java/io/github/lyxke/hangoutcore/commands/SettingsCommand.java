package io.github.lyxke.hangoutcore.commands;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


public class SettingsCommand implements CommandExecutor, InventoryProvider, Listener {

    private PlayerDeathEvent de;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player player = (Player) sender;
        INVENTORY.open(player);

        return false;
    }

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("settingsMenu")
            .provider(new SettingsCommand())
            .size(4, 9)
            .title(ChatColor.AQUA + "Player Settings")
            .build();

    public void init(Player player, InventoryContents inventoryContents) {
        ItemStack playerSkull = new ItemStack(Material.PLAYER_HEAD,1);

        SkullMeta meta = (SkullMeta) playerSkull.getItemMeta();

        meta.setOwningPlayer(player);



        inventoryContents.set(0, 0, ClickableItem.of(new ItemStack(playerSkull), e -> {
            if(e.isLeftClick()){
                de.setDeathMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.AQUA + " died from Reset Character.");
                player.setHealth(0);
            }
        }));

        inventoryContents.set(1, 2, ClickableItem.of(new ItemStack(Material.GRASS_BLOCK), e -> {
            if(e.isLeftClick()){
                player.teleport((Location) Bukkit.getWorld("creative"));
                player.sendMessage(ChatColor.AQUA + "Welcome to the Creative World!");
            }
        }));

        inventoryContents.set(1, 3, ClickableItem.of(new ItemStack(Material.STONE), e -> {
            if(e.isLeftClick()){
                player.teleport((Location) Bukkit.getWorld("Bedrock level"));
                player.sendMessage(ChatColor.AQUA + "Welcome to the Survival World!");
            }
        }));
    }

    public void update(Player player, InventoryContents inventoryContents) {

    }
}
