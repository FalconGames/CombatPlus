package com.Github.Malatak1.CombatPlus.Player;

public class Skill {

	enum Skills{
		
		ATTACK_DAMAGE, SPEED, DEFENSE, ENDURANCE, ENERGY_COLLECTION //Defense = reduced damage, Endurance = increased max mana, Energy collection = mana regeneration rate
		
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
