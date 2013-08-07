package com.Github.Malatak1.CombatPlus.Spells;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellCombustiveburst extends Spell{

	Player p;
	
	public SpellCombustiveburst(Player p) {
		super("Cumbustive Burst", "Create a powerful explosion that sends nearby enemies flying.", new ItemStack(Material.LAVA_BUCKET, 1), "Fire", 50, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		List<Entity> nearby = p.getNearbyEntities(10, 5, 10);
		
		for (int i = 0; i < nearby.size(); i++) {
			if (nearby.get(i) instanceof Damageable) {
		        nearby.get(i).getWorld().createExplosion(nearby.get(i).getLocation(), 0);
		        nearby.get(i).setFireTicks(80);
		        ((Damageable) nearby.get(i)).damage(4);
		        nearby.get(i).setVelocity(new Vector(0, 1.5, 0));
		        //nearby.get(i).getWorld().playEffect(nearby.get(i).getLocation(), Effect.SMOKE, Material.LAVA, 5);
			}
		}
	}

}
