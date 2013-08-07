package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellShadowblast extends Spell{

	Player p;
	
	public SpellShadowblast(Player p) {
		super("Shadow Blast", "Obliterate foes with a blast of destructive dark energy.", new ItemStack(Material.SKULL, 1), "Dark", 10, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2)).toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
		
		WitherSkull witherSkull = p.getWorld().spawn(loc, WitherSkull.class);
		witherSkull.setYield(1);
		
		p.playEffect(loc, Effect.SMOKE, 50);
		p.playEffect(loc, Effect.BLAZE_SHOOT, 2);
	}

}
