package com.Github.Malatak1.CombatPlus.Listeners;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Github.Malatak1.CombatPlus.CombatPlus;
import com.Github.Malatak1.CombatPlus.Util.SpellCastHandler;

public class PlayerInteractListener implements Listener {
	
	private HashMap<String, String> spellSelected;
	
	public PlayerInteractListener(HashMap<String, String> hashmap) {
		this.spellSelected = hashmap;
	}
	
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
        	if (event.getPlayer().getItemInHand().getType() == Material.BOOK) {
        		ItemStack book = event.getPlayer().getItemInHand();
        		ItemMeta bookMeta = book.getItemMeta();
    			if (bookMeta.getDisplayName().equals("Spell Book")) {
					CombatPlus.openMenu(event.getPlayer());
        		}
        	}
        	if (event.getPlayer().getItemInHand().getType() == Material.ARROW) {
        		
        	}
        }
        if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR) {
        	if (event.getPlayer().getItemInHand().getType() == Material.BOOK) {
        		ItemStack book = event.getPlayer().getItemInHand();
        		ItemMeta bookMeta = book.getItemMeta();
    			if (bookMeta.getDisplayName().equals("Spell Book")) {
    				new SpellCastHandler(event.getPlayer(), spellSelected);
    			}
    			
        	}
        	
        }
        
    }
}
