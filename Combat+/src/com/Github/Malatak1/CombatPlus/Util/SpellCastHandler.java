package com.Github.Malatak1.CombatPlus.Util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.CombatPlus;
import com.Github.Malatak1.CombatPlus.Spells.SpellArcaneShield;
import com.Github.Malatak1.CombatPlus.Spells.SpellCombustiveburst;
import com.Github.Malatak1.CombatPlus.Spells.SpellDaze;
import com.Github.Malatak1.CombatPlus.Spells.SpellEntangle;
import com.Github.Malatak1.CombatPlus.Spells.SpellFireball;
import com.Github.Malatak1.CombatPlus.Spells.SpellFireblitz;
import com.Github.Malatak1.CombatPlus.Spells.SpellFirebolt;
import com.Github.Malatak1.CombatPlus.Spells.SpellFlashfreeze;
import com.Github.Malatak1.CombatPlus.Spells.SpellHealing;
import com.Github.Malatak1.CombatPlus.Spells.SpellMagicalBarrage;
import com.Github.Malatak1.CombatPlus.Spells.SpellPoison;
import com.Github.Malatak1.CombatPlus.Spells.SpellShadowblast;
import com.Github.Malatak1.CombatPlus.Spells.SpellShadowstep;
import com.Github.Malatak1.CombatPlus.Spells.SpellStonecarpace;
import com.Github.Malatak1.CombatPlus.Spells.SpellThunderbolt;
import com.Github.Malatak1.CombatPlus.Spells.SpellWaterblast;
import com.Github.Malatak1.CombatPlus.Spells.SpellWindfury;

public class SpellCastHandler {
	
    private HashSet<Block> blocks;
    private HashMap<String, String> spellSelected;
    
	public SpellCastHandler(Player player, HashMap<String, String> hashmap) {
		
		this.spellSelected = hashmap;
		
		
		if (spellSelected.get(player.getName()) == "Magical Barrage"){
        	SpellMagicalBarrage s = new SpellMagicalBarrage(player);
        	s.cast();
        }
		if (spellSelected.get(player.getName()) == "Fireball") {
			SpellFireball s = new SpellFireball(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Arcane Shield") {
			SpellArcaneShield s = new SpellArcaneShield(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Personal Healing") {
			SpellHealing s = new SpellHealing(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Firebolt") {
			SpellFirebolt s = new SpellFirebolt(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Fire Blitz") {
			SpellFireblitz s = new SpellFireblitz(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Water Blast") {
            SpellWaterblast s = new SpellWaterblast(player);
            s.cast();
		}
		if (spellSelected.get(player.getName()) == "Wind Fury") {
			SpellWindfury s = new SpellWindfury(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Poison") {
			SpellPoison s = new SpellPoison(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Shadow Blast") {
			SpellShadowblast s = new SpellShadowblast(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Thunderbolt") {
			SpellThunderbolt s = new SpellThunderbolt(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Cumbustive Burst") {
			SpellCombustiveburst s = new SpellCombustiveburst(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Shadow Step") {
            SpellShadowstep s = new SpellShadowstep(player);
            s.cast();
		}
		if (spellSelected.get(player.getName()) == "Entangle") {
			SpellEntangle s = new SpellEntangle(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Daze") {
			SpellDaze s = new SpellDaze(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Stone Carapace") {
			SpellStonecarpace s = new SpellStonecarpace(player);
			s.cast();
		}
		if (spellSelected.get(player.getName()) == "Flash Freeze") {
	        SpellFlashfreeze s = new SpellFlashfreeze(player);
	        s.cast();
		}
	}
}
