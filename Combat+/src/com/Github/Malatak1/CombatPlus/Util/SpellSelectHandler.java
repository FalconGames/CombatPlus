package com.Github.Malatak1.CombatPlus.Util;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class SpellSelectHandler {
	
	private HashMap<String, String> spellSelected;
	
	public SpellSelectHandler(Player player, String spellName, HashMap<String, String> hashmap) {
	    
		this.spellSelected = hashmap;
		
        player.sendMessage("You have selected " + spellName);
        if (spellName.equals(spellName)) {
            if (spellSelected.containsKey(player.getName())) {
                spellSelected.remove(player.getName());
                spellSelected.put(player.getName(), spellName);
            }	
            else {
            	spellSelected.put(player.getName(), spellName);
            	
            }
        }
	}
}
