package com.abbydiode.afkhunger.listeners;

import java.util.HashMap;

import com.abbydiode.afkhunger.App;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
	private App plugin;
	public static HashMap<Player, Long> lastMove = new HashMap<>();
	
	public MoveListener(App plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		lastMove.put(player, System.currentTimeMillis());
	}
}
