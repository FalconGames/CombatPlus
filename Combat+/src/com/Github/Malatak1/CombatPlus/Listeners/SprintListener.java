package com.Github.Malatak1.CombatPlus.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Github.Malatak1.CombatPlus.Util.CalculateArmor;

public class SprintListener implements Listener{
	
	public static boolean hasArmorType(ItemStack item, Material type) {
	    return (item == null ? false : item.getType() == type);
	}
	
    @EventHandler
    public void toggleSprint(PlayerToggleSprintEvent event) {
    	if (event.getPlayer().isSprinting()) {
    		
    		event.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		event.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		
    	}
    		
    	else {
    		
    		int speedRating = new CalculateArmor(event.getPlayer()).getSpeedRating();
        	
        	int speedValue = 9;
        	
        	if(speedRating < 126) {
        		speedValue -= 1;
            	if(speedRating < 108) {
            		speedValue -= 1;
                	if(speedRating < 90) {
                		speedValue -= 1;
                    	if(speedRating < 72) {
                    		speedValue -= 1;
                        	if(speedRating < 54) {
                        		speedValue -= 1;
                            	if(speedRating < 36) {
                            		speedValue -= 1;
                            	}
                        	}
                    	}
                	}
            	}
        	}
        	
        	if (event.getPlayer().hasPotionEffect(PotionEffectType.SLOW)) {
        		speedValue = 10;
        	}
        	
        	switch (speedValue) {
        	
        	case 10: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 4)); break;
        	case 9: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 3)); break;
        	case 8: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 2)); break;
        	case 7: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 1)); break;
        	case 6: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 0)); break;
        	case 5: break;
        	case 4: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 0)); break;
        	case 3: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1)); break;
        	case 2: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 2)); break;
        	case 1: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 3)); break;
        	case 0: event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 4)); break;
        	
        	}
    	}
    } 
}
