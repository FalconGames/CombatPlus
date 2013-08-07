package com.Github.Malatak1.CombatPlus.Spells;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Github.Malatak1.CombatPlus.CombatPlus;
import com.Github.Malatak1.CombatPlus.Spell;
import com.Github.Malatak1.CombatPlus.Util.SpellCastHandler.BlockRemover;

public class SpellFlashfreeze extends Spell{

	Player p;
	private HashSet<Block> blocks;
	
	public SpellFlashfreeze(Player p) {
		super("Flash Freeze", "Conjures cold winds to freeze nearby enemies in their tracks.", new ItemStack(Material.SNOW_BALL, 1), "Water", 50, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		blocks = new HashSet<Block>();
		List<Entity> nearby = p.getNearbyEntities(10, 5, 10);
				
		for (int i = 0; i < nearby.size(); i++) {
            ArrayList<Block> tombBlocks = new ArrayList<Block>();
                
            
            if (nearby.get(i) instanceof Damageable) {
                Block feet = nearby.get(i).getLocation().getBlock();
                
                Block temp = feet.getRelative(1,0,0);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(1,1,0);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(-1,0,0);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(-1,1,0);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(0,0,1);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(0,1,1);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(0,0,-1);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(0,1,-1);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(0,-1,0);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
                temp = feet.getRelative(0,2,0);
                if (temp.getType() == Material.AIR) {
                        temp.setTypeId(80);
                        tombBlocks.add(temp);
                }
            }
                
            	nearby.get(i).getWorld().playEffect(nearby.get(i).getLocation(), Effect.STEP_SOUND, Material.ICE, 5);
                
                blocks.addAll(tombBlocks);
                CombatPlus.inst().getServer().getScheduler().scheduleSyncDelayedTask(CombatPlus.inst(), new BlockRemover(tombBlocks, 80), 120);
		}
	}
	public class BlockRemover implements Runnable {

        ArrayList<Block> tomb;
        int id;
        
        public BlockRemover(ArrayList<Block> tomb, int id) {
                this.tomb = tomb;
                this.id = id;
        }
        
        @Override
        public void run() {
                for (Block block : tomb) {
                        if (block.getTypeId() == id) {
                                block.setType(Material.AIR);
                        }
                }
                blocks.removeAll(tomb);
        }
        
    }
}
