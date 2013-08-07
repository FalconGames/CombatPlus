package com.Github.Malatak1.CombatPlus.Spells;

import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Github.Malatak1.CombatPlus.CombatPlus;
import com.Github.Malatak1.CombatPlus.Spell;
import com.Github.Malatak1.CombatPlus.Util.SpellCastHandler.BlockRemover;

public class SpellStonecarpace extends Spell{

	Player p;
	private HashSet<Block> blocks;
	
	public SpellStonecarpace(Player p) {
		super("Stone Carapace", "Surround yourself in a protective stone shell temporarily.", new ItemStack(Material.FEATHER, 1), "Earth", 20, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		blocks = new HashSet<Block>();
		
		Block feet = p.getLocation().getBlock();
		
		ArrayList<Block> tombBlocks = new ArrayList<Block>();
		
        Block temp = feet.getRelative(1,0,0);
        
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(1,1,0);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(-1,0,0);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(-1,1,0);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(0,0,1);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(0,1,1);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(0,0,-1);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(0,1,-1);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(0,-1,0);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        temp = feet.getRelative(0,2,0);
        if (temp.getType() == Material.AIR) {
                temp.setTypeId(1);
                tombBlocks.add(temp);
        }
        
        PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 4);
        p.addPotionEffect(effect);
        PotionEffect effect2 = new PotionEffect(PotionEffectType.REGENERATION, 120, 1);
        p.addPotionEffect(effect2);
        
        blocks.addAll(tombBlocks);
        CombatPlus.inst().getServer().getScheduler().scheduleSyncDelayedTask(CombatPlus.inst(), new BlockRemover(tombBlocks, 1), 120);
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
