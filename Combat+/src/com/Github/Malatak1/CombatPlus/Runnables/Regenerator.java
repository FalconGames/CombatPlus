package com.Github.Malatak1.CombatPlus.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Regenerator implements Runnable {
    @Override
    public void run() {
    	Player[] onlinePlayerList = Bukkit.getServer().getOnlinePlayers();
    	for (int i = 0; i < onlinePlayerList.length; i++) {
        	if (onlinePlayerList[i].getLevel() < 81) {
        		int setTo = onlinePlayerList[i].getLevel();
        		setTo += 20;
        		onlinePlayerList[i].setLevel(setTo);
        	}
        	if (onlinePlayerList[i].getLevel() < 100 && onlinePlayerList[i].getLevel() > 80) {
        		int setTo = onlinePlayerList[i].getLevel();
        		int temp = (100-onlinePlayerList[i].getLevel());
        		setTo += (temp);
        		onlinePlayerList[i].setLevel(setTo);
        	}
    	}
    }
}
