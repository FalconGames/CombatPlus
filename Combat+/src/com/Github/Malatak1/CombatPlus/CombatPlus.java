package com.Github.Malatak1.CombatPlus;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.Github.Malatak1.CombatPlus.Listeners.EntityDamageByEntityListener;
import com.Github.Malatak1.CombatPlus.Listeners.SneakListener;
import com.Github.Malatak1.CombatPlus.Listeners.SprintListener;
import com.Github.Malatak1.CombatPlus.Listeners.PlayerInteractListener;
import com.Github.Malatak1.CombatPlus.Util.IconMenu;
import com.Github.Malatak1.CombatPlus.Util.SpellSelectHandler;
import com.Github.Malatak1.CombatPlus.Runnables.Regenerator;

public class CombatPlus extends JavaPlugin {
	
    public HashMap<String, String> spellSelected = new HashMap<>();
    public static IconMenu menu;
    private static CombatPlus instance;
    
    @Override
    public void onEnable(){
    	
    	instance = this;
    	
    	getServer().getPluginManager().registerEvents(new SprintListener(), this);
    	getServer().getPluginManager().registerEvents(new SneakListener(), this);
    	getServer().getPluginManager().registerEvents(new PlayerInteractListener(spellSelected), this);
    	getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
    	
    	menu = new IconMenu("Known Spells", 27, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent event) {
                event.setWillClose(true);
            	new SpellSelectHandler(event.getPlayer(), event.getName(), spellSelected);
            }
        }, this)

        .setOption(0, new ItemStack(Material.FIREBALL, 1), "Fireball", "Fires a destructive fireball to decimate your enemies.")
        .setOption(1, new ItemStack(Material.DIAMOND, 1), "Thunderbolt", "Smites the target down with a powerful bolt of lightning.")
        .setOption(2, new ItemStack(Material.SNOW_BALL, 1), "Flash Freeze", "Conjures cold winds to freeze nearby enemies in their tracks.")
    	.setOption(3, new ItemStack(Material.MELON, 1), "Personal Healing", "Rejuvinates fresh wounds for quick and easy healing.")
    	.setOption(4, new ItemStack(Material.SKULL, 1), "Shadow Blast", "Obliterate foes with a blast of destructive dark energy.")
    	.setOption(5, new ItemStack(Material.BLAZE_ROD, 1), "Firebolt", "Shoot a bolt of blazing energy to destroy your target.")
    	.setOption(6, new ItemStack(Material.POTION, 1), "Water Blast", "Send all in your path flying with a forceful spray of water.")
    	.setOption(7, new ItemStack(Material.LAVA_BUCKET, 1), "Cumbustive Burst", "Create a powerful explosion that sends nearby enemies flying.")
    	.setOption(8, new ItemStack(Material.SLIME_BALL, 1), "Poison", "Slowly drain the target's health with a deadly toxin.")
    	.setOption(9, new ItemStack(Material.BLAZE_POWDER, 1), "Fire Blitz", "Assail the enemy with a forceful blitz of five fireballs at once.")
    	.setOption(10, new ItemStack(Material.FEATHER, 1), "Wind Fury", "Blow away everything nearby with a powerful blast of air.")
    	.setOption(11, new ItemStack(Material.STONE, 1), "Stone Carapace", "Surround yourself in a protective stone shell temporarily.")
    	.setOption(12, new ItemStack(Material.ENDER_PEARL, 1), "Daze", "Stun the target with an intense blast of darkness.")
    	.setOption(13, new ItemStack(Material.INK_SACK, 1), "Shadow Step", "Render yourself invisible to all who look at you.")
    	.setOption(14, new ItemStack(Material.GHAST_TEAR, 1), "Arcane Shield", "Surround yourself in a protective magical shield.")
    	.setOption(15, new ItemStack(Material.WEB, 1), "Entangle", "Trap your enemy in the strands of a magical web.")
    	.setOption(16, new ItemStack(Material.ARROW, 1), "Magical Barrage", "Shoot your enemies with a powerful volley of magical darts.");
    	
    	Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Regenerator(), 100, 40);
    	
    }
    
    @Override
    public void onDisable() {
    	instance = null;
    }
    
    public static CombatPlus inst() {
    	  return instance;
    }
    
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(cmd.getName().equalsIgnoreCase("spell")) {
    		sender.sendMessage("Selected spell: " + spellSelected.get(sender.getName()));
    		return true;
    	}
    	return false; 
    }
    
    
    public static void openMenu(Player player) {
    	menu.open(player);
    }
    
}