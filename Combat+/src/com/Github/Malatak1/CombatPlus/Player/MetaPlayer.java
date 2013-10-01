package com.Github.Malatak1.CombatPlus.Player;

import java.io.Serializable;

import org.bukkit.entity.Player;

public class MetaPlayer implements Serializable{

	private static final long serialVersionUID = 1765L;

	private Player p;
	private SkillTree st;
	private Class c;
	private Race r;
	
	public MetaPlayer(Player p, SkillTree st, Class c, Race r){
		
		this. p = p;
		this.st = st;
		this.c = c;
		this.r = r;
		
	}
	
}