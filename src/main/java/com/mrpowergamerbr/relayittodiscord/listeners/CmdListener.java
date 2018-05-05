package com.mrpowergamerbr.relayittodiscord.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.mrpowergamerbr.relayittodiscord.RelayItToDiscord;
import com.mrpowergamerbr.temmiewebhook.DiscordMessage;

public class CmdListener implements Listener {
	RelayItToDiscord m;

	public CmdListener(RelayItToDiscord m) {
		this.m = m;
		Bukkit.getPluginManager().registerEvents(this, m);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("relayme")) {
			sender.SendMessage("You need your full Discord ID (@name#0002)");
			sender.SendMessage("To confirm your identity to Discord, do:");
			sender.SendMessage("/relayme @test#7479  - replacing the ID with your own!");
			sender.SendMessage("This won't actually work until the rest of the code is written");
			return true;
		}
	}
#	public void onChat(AsyncPlayerChatEvent e) {
#		if (m.startRelaying) {
#			if (m.getConfig().getBoolean("Advanced.IgnoreCancelled") && e.isCancelled()) {
#				return;
#			}
#			
#			String message = e.getMessage();
#			if (m.getConfig().getBoolean("StripColors")) {
#				// The super ultimate workaround(tm)
#				message = ChatColor.translateAlternateColorCodes('&', message);
#				message = ChatColor.stripColor(message);
#			}
#			String format = m.getConfig().getString("Format");
#			format = format.replace("%content%", message);
#			format = m.parse(format, e.getPlayer());
#			
#			DiscordMessage dm = DiscordMessage.builder()
#					.username(m.parse(m.getConfig().getString("Username"), e.getPlayer())) // Player's name
#					.content(format) // Player's message
#					.avatarUrl(m.parse(m.getConfig().getString("AvatarUrl"), e.getPlayer())) // Avatar
#					.build();
#			
#			m.temmie.sendMessage(dm);
#		}
#	}
}
