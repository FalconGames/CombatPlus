package com.Github.Malatak1.CombatPlus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.Github.Malatak1.CombatPlus.Listeners.EntityDamageByEntityListener;
import com.Github.Malatak1.CombatPlus.Listeners.SneakListener;
import com.Github.Malatak1.CombatPlus.Listeners.SprintListener;
import com.Github.Malatak1.CombatPlus.Listeners.PlayerInteractListener;
import com.Github.Malatak1.CombatPlus.Util.IconMenu;
import com.Github.Malatak1.CombatPlus.Util.SpellSelectHandler;
import com.Github.Malatak1.CombatPlus.Util.IconMenu.OptionClickEvent;
import com.Github.Malatak1.CombatPlus.Player.Class.Classes;
import com.Github.Malatak1.CombatPlus.Player.MetaPlayer;
import com.Github.Malatak1.CombatPlus.Player.Race;
import com.Github.Malatak1.CombatPlus.Player.Skill;
import com.Github.Malatak1.CombatPlus.Player.Race.Races;
import com.Github.Malatak1.CombatPlus.Player.Skill.Skills;
import com.Github.Malatak1.CombatPlus.Player.SkillTree;
import com.Github.Malatak1.CombatPlus.Runnables.Regenerator;

public class CombatPlus extends JavaPlugin {
	
    public HashMap<String, String> spellSelected = new HashMap<>();
    public static IconMenu menu, raceselect, classselect, skilltree;
    private static CombatPlus instance;
    private static Races r;
    private static Classes c;
    private static List<MetaPlayer> MetaPlayers = new ArrayList<MetaPlayer>();
    
    @SuppressWarnings("unchecked")
	@Override
    public void onEnable(){
    	
    	instance = this;
    	
    	getServer().getPluginManager().registerEvents(new SprintListener(), this);
    	getServer().getPluginManager().registerEvents(new SneakListener(), this);
    	getServer().getPluginManager().registerEvents(new PlayerInteractListener(spellSelected), this);
    	getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
    	
    	try {
			FileInputStream fis = new FileInputStream("MetaPlayers.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			MetaPlayers = (List<MetaPlayer>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	menu = new IconMenu("Known Spells", 27, new IconMenu.OptionClickEventHandler() {
            @Override
            public void onOptionClick(IconMenu.OptionClickEvent event) {
                event.setWillClose(true);
            	new SpellSelectHandler(event.getPlayer(), event.getName(), spellSelected);
            }
        }, this)

        .setOption(0, new ItemStack(Material.FIREBALL, 1), "Fireball", "Fires a destructive fireball to decimate your enemies.")
        .setOption(1, new ItemStack(Material.DIAMOND, 1), "Thunderbolt", "Smites the target down with a powerful bolt of lightning.")
        .setOption(2, new ItemStack(Material.SNOW_BALL, 1), "Flash Freeze", "Conjures cold winds to freeze nearby enemies in their tracks.")
    	.setOption(3, new ItemStack(Material.MELON, 1), "Personal Healing", "Rejuvinates fresh wounds for quick and easy healing.")
    	.setOption(4, new ItemStack(Material.SKULL, 1), "Shadow Blast", "Obliterate foes with a blast of destructive dark energy.")
    	.setOption(5, new ItemStack(Material.BLAZE_ROD, 1), "Firebolt", "Shoot a bolt of blazing energy to destroy your target.")
    	.setOption(6, new ItemStack(Material.POTION, 1), "Water Blast", "Send all in your path flying with a forceful spray of water.")
    	.setOption(7, new ItemStack(Material.LAVA_BUCKET, 1), "Cumbustive Burst", "Create a powerful explosion that sends nearby enemies flying.")
    	.setOption(8, new ItemStack(Material.SLIME_BALL, 1), "Poison", "Slowly drain the target's health with a deadly toxin.")
    	.setOption(9, new ItemStack(Material.BLAZE_POWDER, 1), "Fire Blitz", "Assail the enemy with a forceful blitz of five fireballs at once.")
    	.setOption(10, new ItemStack(Material.FEATHER, 1), "Wind Fury", "Blow away everything nearby with a powerful blast of air.")
    	.setOption(11, new ItemStack(Material.STONE, 1), "Stone Carapace", "Surround yourself in a protective stone shell temporarily.")
    	.setOption(12, new ItemStack(Material.ENDER_PEARL, 1), "Daze", "Stun the target with an intense blast of darkness.")
    	.setOption(13, new ItemStack(Material.INK_SACK, 1), "Shadow Step", "Render yourself invisible to all who look at you.")
    	.setOption(14, new ItemStack(Material.GHAST_TEAR, 1), "Arcane Shield", "Surround yourself in a protective magical shield.")
    	.setOption(15, new ItemStack(Material.WEB, 1), "Entangle", "Trap your enemy in the strands of a magical web.")
    	.setOption(16, new ItemStack(Material.ARROW, 1), "Magical Barrage", "Shoot your enemies with a powerful volley of magical darts.");
    	
    	raceselect = new IconMenu("Character Customizer: Pick your race!", 9, new IconMenu.OptionClickEventHandler() {
			
			@Override
			public void onOptionClick(OptionClickEvent event) {
				
				event.setWillClose(true);
				
				if(event.getName().equals("Elf")) r = Races.ELF;
				else if(event.getName().equals("Dwarf")) r = Races.DWARF;
				else if(event.getName().equals("Human")) r = Races.HUMAN;
				else r = Races.HUMAN;
				
				classselect.open(event.getPlayer());
				
			}
		}, this)
    	
    	.setOption(4, new ItemStack(Material.WRITTEN_BOOK, 1), "Elf", "Fast and Wise, the Elf is gifted in magical abilities.")
    	.setOption(5, new ItemStack(Material.DIAMOND_AXE, 1), "Dwarf", "Strongest of all races, the Dwarf excels in combat.")
    	.setOption(6, new ItemStack(Material.WORKBENCH, 1), "Human", "Craftier than others, the Human is a natural survivalist.");
    	
    	classselect = new IconMenu("Character Customizer: Pick your class!", 9, new IconMenu.OptionClickEventHandler() {
			
			@Override
			public void onOptionClick(OptionClickEvent event) {
				
				event.setWillClose(true);
				
				if(event.getName().equals("Archer")) c = Classes.ARCHER;
				else if(event.getName().equals("Warrior")) c = Classes.WARRIOR;
				else if(event.getName().equals("Mage")) c = Classes.MAGE;
				else c = Classes.ADMIN;

				MetaPlayers.add(new MetaPlayer(event.getPlayer(), SkillTree.generateSkillTree(), new com.Github.Malatak1.CombatPlus.Player.Class(c), new Race(r)));
				try {
					FileOutputStream fos = new FileOutputStream("MetaPlayers.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(MetaPlayers);
					oos.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}, this)
    	
    	.setOption(4, new ItemStack(Material.BOW, 1), "Archer", "A skilled bowman.")
    	.setOption(5, new ItemStack(Material.DIAMOND_SWORD, 1), "Warrior", "A strong fighter.")
    	.setOption(6, new ItemStack(Material.BLAZE_ROD, 1), "Mage", "A powerful wizard.")
    	.setOption(9, new ItemStack(Material.AIR, 1));
    	
    	skilltree = new IconMenu("Player Skills", 9, new IconMenu.OptionClickEventHandler() {
			
			@Override
			public void onOptionClick(OptionClickEvent event) {
				
				event.setWillClose(true);
				
				if(event.getName().equals("Speed")) getPlayerMeta(event.getPlayer()).levelUpSkill(Skills.SPEED);
				if(event.getName().equals("Attack Damage")) getPlayerMeta(event.getPlayer()).levelUpSkill(Skills.ATTACK_DAMAGE);
				if(event.getName().equals("Defense")) getPlayerMeta(event.getPlayer()).levelUpSkill(Skills.DEFENSE);
				if(event.getName().equals("Endurance")) getPlayerMeta(event.getPlayer()).levelUpSkill(Skills.ENDURANCE);
				if(event.getName().equals("Energy Collection Rate")) getPlayerMeta(event.getPlayer()).levelUpSkill(Skills.ENERGY_COLLECTION);
				
				if(getPlayerMeta(event.getPlayer()).getSkillPoints() >= 1){
					getPlayerMeta(event.getPlayer()).reduceSkillPoints();
					skilltree.open(event.getPlayer(), "Player Skills: " + getPlayerMeta(event.getPlayer()).getSkillPoints() + " skill points remaining!");
				}

			}
		}, this)
    	
    	.setOption(3, new ItemStack(Material.LEATHER_BOOTS, 1), "Speed", "Run and walk faster.")
    	.setOption(4, new ItemStack(Material.DIAMOND_SWORD, 1), "Attack Damage", "Hit harder.")
    	.setOption(5, new ItemStack(Material.DIAMOND_CHESTPLATE, 1), "Defense", "Reduce damage taken.")
    	.setOption(6, new ItemStack(Material.POTION, 1), "Endurance", "Increase mana and energy.")
    	.setOption(7, new ItemStack(Material.REDSTONE, 1), "Energy Collection Rate", "Regenerate mana more quickly.");
    	
    	Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Regenerator(), 100, 40);
    	
    }
    
    @Override
    public void onDisable() {
    	instance = null;
    }
    
    public static CombatPlus inst() {
    	  return instance;
    }
    
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(cmd.getName().equalsIgnoreCase("spell")) {
    		sender.sendMessage("Selected spell: " + spellSelected.get(sender.getName()));
    		return true;
    	}
    	if(cmd.getName().equalsIgnoreCase("customize")){
    		openCharacterCustomizer((Player)sender);
    		return true;
    	}
    	return false; 
    }
    
    
    public static void openMenu(Player player) {
    	menu.open(player);
    }
    
    public static void openCharacterCustomizer(Player player){
    	raceselect.open(player);
    }
    
    public static MetaPlayer getPlayerMeta(Player p){
		
    	while(true){
    		for(int i = 0; i < MetaPlayers.size(); i++){
    		
    			if(MetaPlayers.get(i).getPlayer().equals(p)) return MetaPlayers.get(i);
    		
    		}
    	
    		openCharacterCustomizer(p);
    	
    	}
    	
    }
    
}