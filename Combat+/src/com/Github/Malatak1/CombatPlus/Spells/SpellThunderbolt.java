package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellThunderbolt extends Spell{

	Player p;
	
	public SpellThunderbolt(Player p) {
		super("Thunderbolt", "Smites the target down with a powerful bolt of lightning.", new ItemStack(Material.DIAMOND, 1), "Arcane", 30, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		p.getWorld().strikeLightning(p.getTargetBlock(null, 200).getLocation());
	}
	
}
