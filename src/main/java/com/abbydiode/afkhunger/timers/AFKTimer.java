package com.abbydiode.afkhunger.timers;

import com.abbydiode.afkhunger.App;
import com.abbydiode.afkhunger.listeners.MoveListener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.scheduler.BukkitScheduler;

public class AFKTimer {
	private App plugin;
	BukkitScheduler scheduler;
	
	public AFKTimer(App plugin) {
		this.plugin = plugin;
		Long interval = plugin.getConfig().getLong("interval");
		Integer afkTime = plugin.getConfig().getInt("afkTime") * 1000;
		Integer hungerTime = plugin.getConfig().getInt("hungerTime") * 1000;
		scheduler = Bukkit.getServer().getScheduler();
		
		scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				MoveListener.lastMove.forEach((player, lastMoveTime) -> {
					if (player != null && player.getGameMode() == GameMode.SURVIVAL) {
						if (lastMoveTime + afkTime < System.currentTimeMillis()) {
							float saturationLevel = player.getSaturation();
							if (saturationLevel > 0) {
								player.setSaturation(Math.max(saturationLevel - 1, 0));
							} else {
								player.setFoodLevel(Math.max(player.getFoodLevel() - 1, 0));
							}
							MoveListener.lastMove.put(player, lastMoveTime + hungerTime);
						}
					} else {
						MoveListener.lastMove.remove(player);
					}
				});
			}
		}, interval, interval);
	}
}
