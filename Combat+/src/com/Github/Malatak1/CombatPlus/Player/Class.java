package com.Github.Malatak1.CombatPlus.Player;

public class Class {

	enum Classes{
		
		WARRIOR, MAGE, ARCHER;
		
	}
	
	private Classes c;
	
	public Class(Classes c){
		
		this.c = c;
		
	}
	
	public Classes getPlayerClass(){
		
		return c;
		
	}
	
}
