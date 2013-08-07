package com.Github.Malatak1.CombatPlus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Spell {
	
	private String name, description, tab;
	private int mana;
	private ItemStack icon;
	private Player p;
	public Spell(String name, String description, ItemStack icon, String tab, int mana, Player p) {
		this.name = name;
		this.description = description;
		this.tab = tab;
		this.icon = icon;
		this.mana = mana;
		this.p = p;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getTab() {
		return tab;
	}
	
	public ItemStack getIcon() {
		return icon;
	}
	
	public void cast(){
		if(p.getLevel() >= mana) {
			spellCast();
			p.setLevel(p.getLevel() - mana);
		}
		else {
			p.sendMessage("Insufficient Mana! Please wait until you have " + p.getLevel() + " mana and then try again!");
		}
	}
	
	public abstract void spellCast();
}