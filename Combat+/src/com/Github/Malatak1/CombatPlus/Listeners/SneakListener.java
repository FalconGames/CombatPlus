package com.Github.Malatak1.CombatPlus.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.Github.Malatak1.CombatPlus.CombatPlus;
import com.Github.Malatak1.CombatPlus.Runnables.PlayerHiddenChecker;

public class SneakListener implements Listener{
	
	@EventHandler
	public void PlayerSneak(PlayerToggleSneakEvent event) {
		if (!(event.getPlayer().isSneaking())) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CombatPlus.inst(), new PlayerHiddenChecker(event.getPlayer()), 0);
		}
		else {
		}
	}
}
