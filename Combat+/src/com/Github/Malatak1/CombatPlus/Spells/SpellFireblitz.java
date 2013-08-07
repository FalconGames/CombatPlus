package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.inventory.ItemStack;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellFireblitz extends Spell{

	Player p;
	
	public SpellFireblitz(Player p) {
		super("Fire Blitz", "Assail the enemy with a forceful blitz of five fireballs at once.", new ItemStack(Material.BLAZE_ROD, 1), "Fire", 10, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(3)).toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
		
		for (int i = 0; i < 10; i++) {
			SmallFireball fireball = p.getWorld().spawn(loc, SmallFireball.class);
			fireball.setIsIncendiary(false);
			fireball.setFireTicks(0);
			fireball.setVelocity(fireball.getVelocity().multiply(2));
		}
		
		p.playEffect(loc, Effect.SMOKE, 5);
		p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 5);
		p.playEffect(loc, Effect.BLAZE_SHOOT, 1);
	}

}
