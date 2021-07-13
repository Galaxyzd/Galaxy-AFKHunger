package com.abbydiode.afkhunger.commands;

import com.abbydiode.afkhunger.App;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AFKHungerCommand implements CommandExecutor {
	private App plugin;
	
	public AFKHungerCommand(App plugin) {
		this.plugin = plugin;
		plugin.getCommand("afkhunger").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage("AFK Hunger is correctly configured and working!");
		return true;
	}
}
