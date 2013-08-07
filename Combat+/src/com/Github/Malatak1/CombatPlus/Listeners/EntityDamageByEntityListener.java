package com.Github.Malatak1.CombatPlus.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.Util.CalculateArmor;

public class EntityDamageByEntityListener implements Listener {
	
	@EventHandler
	public void EntityDamageByEntity(EntityDamageByEntityEvent event) {
		
		Entity damager = event.getDamager();
		Entity damagee = event.getEntity();
		Double damage = event.getDamage();
		
		if (damager instanceof Player) {
			
			//THIS WILL BE FOR WARRIORS ONLY ONE DAY
			if (damager instanceof Player) {
				double chance = Math.random();
				chance *= 100;
				
				Player player = (Player) damager;
				ItemStack inHand = player.getItemInHand();
				String evaluate = inHand.toString();
				int value = 0;
				
				if (evaluate.contains("SWORD")) {
					value = 1;
				}
				if (evaluate.contains("_AXE")) {
					value = 2;
				}
				if (evaluate.contains("PICKAXE")) {
					value = 3;
				}
				if (evaluate.contains("HOE")) {
					value = 4;
				}
				if (evaluate.contains("SPADE")) {
					value = 5;
				}
				
				switch (value) {
				
				case 1:
					if (chance > 95) {
						if (damagee instanceof Damageable) {
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 0));
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 0));
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You have dazed the enemy!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You have been dazed!");
							}
						}
					} 
					else if (chance > 90) {
						if (damagee instanceof Damageable) {
							event.setDamage(damage *= 4);
							
							Vector away = damager.getVelocity();
							Double x = away.getX();
							away.setX(x *= 1.5D);
							Double z = away.getZ();
							away.setZ(z *= 1.5D);
							away.setY(0.6);
							
							damagee.setVelocity(away);
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You land a critical hit!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You take a critical hit!");
							}
						}
					}
					break;
				case 2:
					if (chance > 95) {
						if (damagee instanceof Damageable) {
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 0));
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 0));
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You have dazed the enemy!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You have been dazed!");
							}
						}
					} 
					else if (chance > 90) {
						if (damagee instanceof Damageable) {
							event.setDamage(damage *= 4);
							
							Vector away = damager.getVelocity();
							Double x = away.getX();
							away.setX(x *= 1.5D);
							Double z = away.getZ();
							away.setZ(z *= 1.5D);
							away.setY(0.6);
							
							damagee.setVelocity(away);
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You land a critical hit!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You take a critical hit!");
							}
						}
					}
					break;
				case 3:
					if (chance > 95) {
						if (damagee instanceof Damageable) {
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 0));
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 0));
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You have dazed the enemy!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You have been dazed!");
							}
						}
					} 
					else if (chance > 90) {
						if (damagee instanceof Damageable) {
							event.setDamage(damage *= 4);
							
							Vector away = damager.getVelocity();
							Double x = away.getX();
							away.setX(x *= 1.5D);
							Double z = away.getZ();
							away.setZ(z *= 1.5D);
							away.setY(0.6);
							
							damagee.setVelocity(away);
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You land a critical hit!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You take a critical hit!");
							}
						}
					}
					break;
				case 4:
					if (chance > 95) {
						if (damagee instanceof Damageable) {
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 0));
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 0));
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You have dazed the enemy!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You have been dazed!");
							}
						}
					} 
					else if (chance > 90) {
						if (damagee instanceof Damageable) {
							event.setDamage(damage *= 4);
							
							Vector away = damager.getVelocity();
							Double x = away.getX();
							away.setX(x *= 1.5D);
							Double z = away.getZ();
							away.setZ(z *= 1.5D);
							away.setY(0.6);
							
							damagee.setVelocity(away);
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You land a critical hit!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You take a critical hit!");
							}
						}
					}
					break;
				case 5:
					if (chance > 95) {
						if (damagee instanceof Damageable) {
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 0));
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 0));
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You have dazed the enemy!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You have been dazed!");
							}
						}
					} 
					else if (chance > 90) {
						if (damagee instanceof Damageable) {
							event.setDamage(damage *= 4);
							
							Vector away = damager.getVelocity();
							Double x = away.getX();
							away.setX(x *= 1.5D);
							Double z = away.getZ();
							away.setZ(z *= 1.5D);
							away.setY(0.6);
							
							damagee.setVelocity(away);
							((Player) damager).sendMessage(ChatColor.DARK_RED + "You land a critical hit!");
							if (damagee instanceof Player) {
								damagee.teleport((Entity) new Location(damagee.getLocation().getWorld(), damagee.getLocation().getX(), damagee.getLocation().getY(), damagee.getLocation().getZ(), 0, damagee.getLocation().getPitch()));
								((Player) damagee).sendMessage(ChatColor.DARK_RED + "You take a critical hit!");
							}
						}
					}
					break;
					
				}
			}
			
			//THIS WILL BE FOR ROGUES ONLY ONE DAY
			if (damager.isOnGround() != true && ((Player) damager).isSprinting()) {
				
				Vector down = damager.getVelocity();
				down.setY(-3);
				damager.setFallDistance(-100F);
				damager.setVelocity(down);
				
				Vector away = damager.getVelocity();
				Double x = away.getX();
				away.setX(x *= 1.5D);
				Double z = away.getZ();
				away.setZ(z *= 1.5D);
				away.setY(0.75);
				
				damagee.setVelocity(away);
				
				event.setDamage(damage *= 2);
				
				((Player) damager).sendMessage(ChatColor.DARK_RED + "You use " + ChatColor.ITALIC + "Sprinting Strike");
			}
		}
		
		
		if (damager instanceof Arrow) {
			if (((Arrow) damager).getShooter() instanceof Player) {
				Player player = (Player) ((Arrow) damager).getShooter();
				
				//THIS WILL BE FOR ROGUES ONLY ONE DAY
				if (player instanceof Player) {
					
					Projectile arrow = (Projectile) event.getDamager();
					
					ItemStack bow = new ItemStack(Material.BOW, 1);
					
					if (player.getItemInHand() == bow) {
						double projectile_height = arrow.getLocation().getY();
						double targetY = damagee.getLocation().getY();
						double target_bodyheight = targetY += 1.35;
						if (projectile_height > target_bodyheight){
							event.setDamage(damage *= 2);
							player.sendMessage(ChatColor.DARK_RED + "Boom! Headshot!");
						}
						if (projectile_height < (target_bodyheight -= 1)) {
							event.setDamage(damage *= 0.5);
							((LivingEntity) damagee).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 0));
						}
					}
				}
			}
		}
		
		//THIS WILL BE FOR WARRIORS ONLY ONE DAY
		if (damagee instanceof Player) {
			
			int armorRating = new CalculateArmor((Player) damagee).getArmorPoints();
			if (armorRating > 180) {
				double chance = Math.random();
				chance *= 100;
				if (chance > 90) {
					event.setDamage(0);
					((Player) damagee).sendMessage(ChatColor.DARK_RED + "The enemy's attack bounces off your armor!");
				}	
			}
		}
		
	}
	
}
