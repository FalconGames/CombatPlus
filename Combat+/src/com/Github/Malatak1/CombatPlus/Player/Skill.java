package com.Github.Malatak1.CombatPlus.Player;

public class Skill {

	public static enum Skills{
		
		ATTACK_DAMAGE, SPEED, DEFENSE, ENDURANCE, ENERGY_COLLECTION
		
	}
	
	private Skills skill;
	private int level;	
	
	public Skill(Skills skill){
		
		this.skill = skill;
		level = 0;
		
	}
	
	public void levelUp(){
		
		level++;
		
	}
	
	public int getLevel(){
		
		return level;
		
	}
	
	public Skills getSkill(){
		
		return skill;
		
	}
	
}
