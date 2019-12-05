package dev.glxy.afkhunger.timers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.scheduler.BukkitScheduler;

import dev.glxy.afkhunger.Main;
import dev.glxy.afkhunger.listeners.MoveListener;

public class AFKTimer {
	private Main plugin;
	BukkitScheduler scheduler;
	
	public AFKTimer(Main plugin) {
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
