package com.Github.Malatak1.CombatPlus.Runnables;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Github.Malatak1.CombatPlus.CombatPlus;

public class PlayerHiddenChecker extends BukkitRunnable{
	
	Player player;
	int radius = 20;
	
	public PlayerHiddenChecker(Player player) {
		this.player = player;
	}
	
//	@Override
	public void run() {
		
		if (player.isSneaking()) {
			List<Entity> nearby = player.getNearbyEntities(100, 100, 100);
			List<Entity> close = player.getNearbyEntities(radius, radius, radius);
			
			for (int i = 0; i < nearby.size(); i++) {
				Entity target = nearby.get(i);
				if (!(target instanceof Monster) && !(target instanceof Player)) {
					if (nearby.get(i) instanceof Player) {
						if (nearby.get(i) == close) {
							player.hidePlayer((Player) nearby.get(i));
						}
					}
					else if (nearby.get(i) instanceof Monster) {
						Monster monster = (Monster) target;
						if (monster.getTarget() == player) {
							monster.setTarget(null);
						}
					}
				}
			}
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CombatPlus.inst(), new PlayerHiddenChecker(player), 40);
		}
		else {
			List<Entity> nearby = player.getNearbyEntities(100, 100, 100);
			
			for (int i = 0; i < nearby.size(); i++) {
				Entity target = nearby.get(i);
				if (target instanceof Player) {
					((Player) target).showPlayer(player);
				}
				
			}
		}
	}
}
