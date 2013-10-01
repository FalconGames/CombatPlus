package com.Github.Malatak1.CombatPlus.Player;

public class Race {

	enum Races{
		
		ELF, DWARF, HUMAN;
		
	}
	
	private Races r;
	
	public Race(Races r){
		
		this.r = r;
		
	}
	
	public Races getPlayerRace(){
		
		return r;
		
	}
	
}
