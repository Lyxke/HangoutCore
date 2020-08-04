package io.github.lyxke.hangoutcore.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.TimeUnit;

public class PlayerWelcomeMessage implements Listener {

    // Welcome message for all players
    @EventHandler
    public void playerWelcomeMessage(PlayerJoinEvent e){

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

}
