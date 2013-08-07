package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellArcaneShield extends Spell{

	Player p;
	
	public SpellArcaneShield(Player p) {
		super("Arcane Shield", "Surround yourself in a protective magical shield.", new ItemStack(Material.GHAST_TEAR, 1), "Arcane", 25, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 0));
	}

}
