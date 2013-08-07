package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellHealing extends Spell{

	Player p;
	
	public SpellHealing(Player p) {
		super("Personal Healing", "Rejuvinates fresh wounds for quick and easy healing.", new ItemStack(Material.MELON, 1), "Nature", 50, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		p.setHealth(20);
		p.playEffect(EntityEffect.WOLF_HEARTS);
	}

}
