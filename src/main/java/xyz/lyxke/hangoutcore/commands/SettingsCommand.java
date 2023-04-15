package xyz.lyxke.hangoutcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;


public class SettingsCommand implements CommandExecutor, Listener {

    private PlayerDeathEvent de;

    public ItemStack resetCharacter = new ItemStack(Material.PLAYER_HEAD,1);
    public SkullMeta skullmeta = (SkullMeta) resetCharacter.getItemMeta();

    public ItemStack creativeBlock = new ItemStack(Material.GRASS_BLOCK,1);
    public ItemMeta creativeMeta = creativeBlock.getItemMeta();

    public ItemStack survivalBlock = new ItemStack(Material.DIAMOND_SWORD,1);
    public ItemMeta survivalMeta = survivalBlock.getItemMeta();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            Inventory settingsInventory = Bukkit.createInventory(player, 54, ChatColor.AQUA + "Player Settings");



            skullmeta.setOwningPlayer(player);
            skullmeta.setDisplayName(ChatColor.RED + "Reset " + player.getName() + "?");
            resetCharacter.setItemMeta(skullmeta);
            settingsInventory.setItem(0, resetCharacter);


            creativeMeta.setDisplayName(ChatColor.GREEN + "Creative World!");
            creativeBlock.setItemMeta(creativeMeta);
            settingsInventory.setItem(11, creativeBlock);

            survivalMeta.setDisplayName(ChatColor.AQUA + "Survival World!");
            survivalBlock.setItemMeta(survivalMeta);
            settingsInventory.setItem(12, survivalBlock);

            player.openInventory(settingsInventory);

            return true;
        }
        return false;
    }

/*    public static final SmartInventory INVENTORY = SmartInventory.builder()
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

*/
}