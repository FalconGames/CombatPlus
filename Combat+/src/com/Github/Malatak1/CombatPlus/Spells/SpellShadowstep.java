package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellShadowstep extends Spell{

	Player p;
	
	public SpellShadowstep(Player p) {
		super("Shadow Step", "Render yourself invisible to all who look at you.", new ItemStack(Material.INK_SACK, 1), "Dark", 15, p);
		this.p = p;
	}


	@Override
	public void spellCast() {
		PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0);
        player.addPotionEffect(effect);	
	}
	
}
