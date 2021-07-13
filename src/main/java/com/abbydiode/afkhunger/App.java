package com.abbydiode.afkhunger;

import com.abbydiode.afkhunger.commands.AFKHungerCommand;
import com.abbydiode.afkhunger.listeners.MoveListener;
import com.abbydiode.afkhunger.timers.AFKTimer;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new MoveListener(this);
		new AFKHungerCommand(this);
		new AFKTimer(this);
	}
}
