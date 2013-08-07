package com.Github.Malatak1.CombatPlus.Util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CalculateArmor {
	
	int speedRating = 0;
	int armorRating = 0;
	
	public CalculateArmor(Player player) {
		PlayerInventory inventory = player.getInventory();
    	
    	if(hasArmorType(inventory.getHelmet(), Material.LEATHER_HELMET)) {
    		speedRating += 5;
    		armorRating += 5;
    	}
    	if(hasArmorType(inventory.getHelmet(), Material.CHAINMAIL_HELMET)) {
    		speedRating += 10;
    		armorRating += 15;
    	}
    	if(hasArmorType(inventory.getHelmet(), Material.GOLD_HELMET)) {
    		speedRating += 20;
    		armorRating += 20;
    	}
    	if(hasArmorType(inventory.getHelmet(), Material.IRON_HELMET)) {
    		speedRating += 20;
    		armorRating += 40;
    	}
    	if(hasArmorType(inventory.getHelmet(), Material.DIAMOND_HELMET)) {
    		speedRating += 15;
    		armorRating += 60;
    	}
    	
    	
    	if(hasArmorType(inventory.getChestplate(), Material.LEATHER_CHESTPLATE)) {
    		speedRating += 8;
    		armorRating += 8;
    	}
    	if(hasArmorType(inventory.getChestplate(), Material.CHAINMAIL_CHESTPLATE)) {
    		speedRating += 16;
    		armorRating += 20;
    	}
    	if(hasArmorType(inventory.getChestplate(), Material.GOLD_CHESTPLATE)) {
    		speedRating += 32;
    		armorRating += 32;
    	}
    	if(hasArmorType(inventory.getChestplate(), Material.IRON_CHESTPLATE)) {
    		speedRating += 32;
    		armorRating += 64;
    	}
    	if(hasArmorType(inventory.getChestplate(), Material.DIAMOND_CHESTPLATE)) {
    		speedRating += 24;
    		armorRating += 96;
    	}
    	
    	
    	if(hasArmorType(inventory.getLeggings(), Material.LEATHER_LEGGINGS)) {
    		speedRating += 7;
    		armorRating += 7;
    	}
    	if(hasArmorType(inventory.getLeggings(), Material.CHAINMAIL_LEGGINGS)) {
    		speedRating += 14;
    		armorRating += 18;
    	}
    	if(hasArmorType(inventory.getLeggings(), Material.GOLD_LEGGINGS)) {
    		speedRating += 28;
    		armorRating += 28;
    	}
    	if(hasArmorType(inventory.getLeggings(), Material.IRON_LEGGINGS)) {
    		speedRating += 28;
    		armorRating += 56;
    	}
    	if(hasArmorType(inventory.getLeggings(), Material.DIAMOND_LEGGINGS)) {
    		speedRating += 21;
    		armorRating += 86;
    	}
    	
    	
    	if(hasArmorType(inventory.getBoots(), Material.LEATHER_BOOTS)) {
    		speedRating += 4;
    		armorRating += 4;
    	}
    	if(hasArmorType(inventory.getBoots(), Material.CHAINMAIL_BOOTS)) {
    		speedRating += 8;
    		armorRating += 10;
    	}
    	if(hasArmorType(inventory.getBoots(), Material.GOLD_BOOTS)) {
    		speedRating += 16;
    		armorRating += 16;
    	}
    	if(hasArmorType(inventory.getBoots(), Material.IRON_BOOTS)) {
    		speedRating += 16;
    		armorRating += 32;
    	}
    	if(hasArmorType(inventory.getBoots(), Material.DIAMOND_BOOTS)) {
    		speedRating += 12;
    		armorRating += 48;
    	}
	}
	
	public int getSpeedRating() {
		return speedRating;
	}
	
	public int getArmorPoints() {
		return armorRating;
	}
	
	
	private static boolean hasArmorType(ItemStack item, Material type) {
	    return (item == null ? false : item.getType() == type);
	}
	
}
