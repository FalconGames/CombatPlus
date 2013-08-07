package com.Github.Malatak1.CombatPlus.Spells;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.Spell;

public class SpellMagicalBarrage extends Spell{

	private Player p;
	
	public SpellMagicalBarrage(Player p) {
		super("Magical Barrage", "Fires a destructive fireball to decimate your enemies.", new ItemStack(Material.ARROW, 30), "Arcane", 60, p);
	}

	@Override
	public void spellCast() {
		Vector direction = p.getEyeLocation().getDirection().multiply(1.5);
		
		for(int i = 0; i < 30; i++){
			
			Arrow a = p.getWorld().spawnArrow(p.getLocation(), direction, 30, 15);
			a.setShooter(p);
			a.setTicksLived(1100);
			
		}
	}

}