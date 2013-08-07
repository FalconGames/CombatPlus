package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellFirebolt extends Spell{

	Player p;
	
	public SpellFirebolt(Player p) {
		super("Firebolt", "Shoot a bolt of blazing energy to destroy your target.",  new ItemStack(Material.BLAZE_ROD, 1), "Fire", 5, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		Vector direction = p.getEyeLocation().getDirection().multiply(1.5);
		Projectile projectile = p.getWorld().spawn(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), Arrow.class);
		projectile.setShooter(p);
		projectile.setVelocity(direction.multiply(2));
		projectile.setFireTicks(1200);
		
		Location loc = p.getLocation();
		
		p.playEffect(loc, Effect.SMOKE, 5);
		p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 5);
		p.playEffect(loc, Effect.BLAZE_SHOOT, 1);
	}

}
