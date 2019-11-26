package dev.glxy.afkhunger.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import dev.glxy.afkhunger.Main;

public class MoveListener implements Listener {
	private Main plugin;
	public static HashMap<Player, Long> lastMove = new HashMap<>();
	
	public MoveListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		lastMove.put(player, System.currentTimeMillis());
	}
}
