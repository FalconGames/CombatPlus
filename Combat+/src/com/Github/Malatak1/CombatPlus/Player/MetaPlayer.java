package com.Github.Malatak1.CombatPlus.Player;

import java.io.Serializable;

import org.bukkit.entity.Player;

import com.Github.Malatak1.CombatPlus.CombatPlus;

public class MetaPlayer implements Serializable{

	private static final long serialVersionUID = 1765L;

	private Player p;
	private SkillTree st;
	private Class c;
	private Race r;
	private int skillPoints;
	
	public MetaPlayer(Player p, SkillTree st, Class c, Race r){
		
		this.p = p;
		this.st = st;
		this.c = c;
		this.r = r;
		skillPoints = 5;
		CombatPlus.skilltree.open(p);
		
	}

	public int getSkillPoints(){
		
		return skillPoints;
		
	}
	
	public void reduceSkillPoints(){
		
		skillPoints--;
		
	}
	
	public int getSkillLevel(Skill.Skills skill){
		
		return st.getLevel(skill);
		
	}
	
	public void levelUpSkill(Skill.Skills skill){
		
		st.levelUp(skill);
		
	}
	
	public Player getPlayer(){
		
		return p;
		
	}
	
	public Class getPlayerClass(){
		
		return c;
		
	}
	
	public Race getPlayerRace(){
		
		return r;
		
	}
	
}