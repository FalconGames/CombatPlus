package com.Github.Malatak1.CombatPlus.Spells;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellWindfury extends Spell{

	Player p;
	
	public SpellWindfury(Player p) {
		super("Wind Fury", "Blow away everything nearby with a powerful blast of air.", new ItemStack(Material.FEATHER, 1), "Air", 50, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		List<Entity> nearby = p.getNearbyEntities(10, 10, 10);
		
		for (int i = 0; i < nearby.size(); i++) {
			Entity target = nearby.get(i);
			Player caster = p;
			
			caster.playEffect(caster.getLocation(), Effect.SMOKE, 5);
			caster.playEffect(caster.getLocation(), Effect.SMOKE, 5);
			caster.playEffect(caster.getLocation(), Effect.SMOKE, 5);
			
			Vector p = new Vector();
            p.setX(caster.getLocation().getDirection().getX());
            p.setY(caster.getLocation().getDirection().getY());
            p.setZ(caster.getLocation().getDirection().getZ());
			
			Vector t = new Vector();
            t.setX(target.getLocation().getDirection().getX());
            t.setY(target.getLocation().getDirection().getY());
            t.setZ(target.getLocation().getDirection().getZ());
            
            Vector vector = p.subtract(t);
            
            vector.setX(vector.getX() * 1.5);
            vector.setY(vector.getY() * 0);
            vector.setY(vector.getY() + 1.35);
            vector.setZ(vector.getZ() * 1.5);
            
            target.setVelocity(vector);
		}
	}

}
