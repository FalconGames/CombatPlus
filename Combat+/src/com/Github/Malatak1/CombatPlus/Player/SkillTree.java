package com.Github.Malatak1.CombatPlus.Player;

public class SkillTree {

	Skill[] skills;
	
	public SkillTree(Skill[] skills){
		
		this.skills = skills;
		
	}
	
	public SkillTree generateSkillTree(){
		
		Skill[] skills = new Skill[5];
		skills[0] = new Skill(Skill.Skills.ATTACK_DAMAGE);
		skills[1] = new Skill(Skill.Skills.DEFENSE);
		skills[2] = new Skill(Skill.Skills.SPEED);
		skills[3] = new Skill(Skill.Skills.ENDURANCE);
		skills[4] = new Skill(Skill.Skills.ENERGY_COLLECTION);
		
		return new SkillTree(skills);
		
	}
	
}
