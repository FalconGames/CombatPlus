package com.Github.Malatak1.CombatPlus.Player;

public class Class {

	public enum Classes{
		
		WARRIOR, MAGE, ARCHER, ADMIN;
		
	}
	
	private Classes c;
	
	public Class(Classes c){
		
		this.c = c;
		
	}
	
	public Classes getPlayerClass(){
		
		return c;
		
	}
	
}
