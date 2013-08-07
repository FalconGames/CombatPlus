package com.Github.Malatak1.CombatPlus.Spells;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Github.Malatak1.CombatPlus.Spell;
import com.Github.Malatak1.CombatPlus.Util.Vector3D;

public class SpellDaze extends Spell{

	Player p;
	
	public SpellDaze(Player p) {
		super("Daze", "Stun the target with an intense blast of darkness.", new ItemStack(Material.ENDER_PEARL, 1), "Dark", 10, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		final Player observer = p;
	    final int ATTACK_REACH = 20;
		
		Location observerPos = observer.getEyeLocation();
        Vector3D observerDir = new Vector3D(observerPos.getDirection());

        Vector3D observerStart = new Vector3D(observerPos);
        Vector3D observerEnd = observerStart.add(observerDir.multiply(ATTACK_REACH));

        Entity hit = null;

        List<Entity> nearby = p.getNearbyEntities(20, 20, 20);
        
        for (Entity target : nearby) {
            Vector3D targetPos = new Vector3D(target.getLocation());
            Vector3D minimum = targetPos.add(-0.5, 0, -0.5);
            Vector3D maximum = targetPos.add(0.5, 1.67, 0.5);

            if (target != observer && hasIntersection(observerStart, observerEnd, minimum, maximum)) {
                if (hit == null || 
                        hit.getLocation().distanceSquared(observerPos) > 
                        target.getLocation().distanceSquared(observerPos)) {
                    hit = target;
                }
            }
        }

        if (hit != null) {
        	if (hit instanceof Damageable) {
                ((LivingEntity) hit).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 160, 1));
                ((LivingEntity) hit).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 1));
                ((LivingEntity) hit).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 2));
                ((LivingEntity) hit).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 160, 2));
                hit.getWorld().playEffect(hit.getLocation(), Effect.STEP_SOUND, Material.COAL_BLOCK, 5);
        	}
        }
	}
	private boolean hasIntersection(Vector3D p1, Vector3D p2, Vector3D min, Vector3D max) {
        final double epsilon = 0.0001f;
 
        Vector3D d = p2.subtract(p1).multiply(0.5);
        Vector3D e = max.subtract(min).multiply(0.5);
        Vector3D c = p1.add(d).subtract(min.add(max).multiply(0.5));
        Vector3D ad = d.abs();
 
        if (Math.abs(c.x) > e.x + ad.x)
            return false;
        if (Math.abs(c.y) > e.y + ad.y)
            return false;
        if (Math.abs(c.z) > e.z + ad.z)
            return false;
 
        if (Math.abs(d.y * c.z - d.z * c.y) > e.y * ad.z + e.z * ad.y + epsilon)
            return false;
        if (Math.abs(d.z * c.x - d.x * c.z) > e.z * ad.x + e.x * ad.z + epsilon)
            return false;
        if (Math.abs(d.x * c.y - d.y * c.x) > e.x * ad.y + e.y * ad.x + epsilon)
            return false;
 
        return true;
	}
}
