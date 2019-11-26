package dev.glxy.afkhunger;

import org.bukkit.plugin.java.JavaPlugin;

import dev.glxy.afkhunger.commands.AFKHungerCommand;
import dev.glxy.afkhunger.listeners.MoveListener;
import dev.glxy.afkhunger.timers.AFKTimer;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new MoveListener(this);
		new AFKHungerCommand(this);
		new AFKTimer(this);
	}
}
