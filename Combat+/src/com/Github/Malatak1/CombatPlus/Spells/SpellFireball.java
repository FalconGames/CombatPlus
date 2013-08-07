package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellFireball extends Spell{

	Player p;
	
	public SpellFireball(Player p) {
		super("Fireball", "Fires a destructive fireball to decimate your enemies.", new ItemStack(Material.FIREBALL, 1), "Fire", 15, p);
	}

	@Override
	public void spellCast() {
		Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2)).toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
		
		Fireball fireball = p.getWorld().spawn(loc, Fireball.class);
		fireball.setIsIncendiary(false);
		fireball.setYield(3);
		p.playEffect(loc, Effect.SMOKE, 5);
		p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 5);
		p.playEffect(loc, Effect.BLAZE_SHOOT, 2);
	}

	
	
}
