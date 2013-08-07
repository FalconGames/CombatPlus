package com.Github.Malatak1.CombatPlus.Util;

import org.bukkit.entity.Player;

public class ManaReductor {
	
	public ManaReductor(int ammount, Player player) {
		int temp = player.getLevel();
		player.setLevel(temp -= ammount);
	}
}
