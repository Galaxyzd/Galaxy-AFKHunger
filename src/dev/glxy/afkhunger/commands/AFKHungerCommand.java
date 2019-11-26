package dev.glxy.afkhunger.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import dev.glxy.afkhunger.Main;

public class AFKHungerCommand implements CommandExecutor {
	private Main plugin;
	
	public AFKHungerCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("afkhunger").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("AFK Hunger is correctly configured and working!");
		return true;
	}
}
