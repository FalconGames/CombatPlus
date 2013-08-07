package com.Github.Malatak1.CombatPlus.Spells;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.Github.Malatak1.CombatPlus.Spell;
import com.Github.Malatak1.CombatPlus.Util.Vector3D;

public class SpellWaterblast extends Spell{

	Player p;
	
	public SpellWaterblast(Player p) {
		super("Water Blast", "Send all in your path flying with a forceful spray of water.", new ItemStack(Material.POTION, 1), "Water", 10, p);
		this.p = p;
	}

	@Override
	public void spellCast() {
		final Player observer = p;
	    final int ATTACK_REACH = 20; // meters
		
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

        // Get the closest entity and execute code.
        if (hit != null) {
        	if (hit instanceof Damageable) {
                ((Damageable) hit).damage(4);
                Vector vector = new Vector();
                vector.setX(observerPos.getDirection().getX() * 2);
                vector.setZ(observerPos.getDirection().getZ() * 2);
                vector.setY(observerPos.getDirection().getY() * 0);
                vector.setY(observerPos.getDirection().getY() + 0.75);
                
                hit.setVelocity(vector.multiply(2));
                hit.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.WATER, 5);
                hit.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.WATER, 5);
                hit.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK, 5);
                hit.getWorld().playEffect(hit.getLocation(), Effect.STEP_SOUND, Material.WATER, 5);
                hit.getWorld().playEffect(hit.getLocation(), Effect.STEP_SOUND, Material.WATER, 5);
                hit.getWorld().playEffect(hit.getLocation(), Effect.STEP_SOUND, Material.LAPIS_BLOCK, 5);
        	}
        }
        
		try {
			for(Block loc:p.getLineOfSight(null, 100)){
				playFirework(loc.getLocation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Object[] dataStore = new Object[5];
    public void playFirework(Location loc) throws Exception {
    	Random gen = new Random();
    	
        Firework fw = (Firework) loc.getWorld().spawn(loc, Firework.class);
        if(dataStore[0] == null) dataStore[0] = getMethod(loc.getWorld().getClass(), "getHandle");
        if(dataStore[2] == null) dataStore[2] = getMethod(fw.getClass(), "getHandle");
        dataStore[3] = ((Method) dataStore[0]).invoke(loc.getWorld(), (Object[]) null);
        dataStore[4] = ((Method) dataStore[2]).invoke(fw, (Object[]) null);
        if(dataStore[1] == null) dataStore[1] = getMethod(dataStore[3].getClass(), "addParticle");
        ((Method) dataStore[1]).invoke(dataStore[3], new Object[] {"fireworksSpark", loc.getX(),loc.getY(),loc.getZ(),gen.nextGaussian() * 0.05D, -(loc.getZ()* 1.15D) * 0.5D, gen.nextGaussian() * 0.05D});
        fw.remove();
    }
    private Method getMethod(Class<?> cl, String method) {
        for(Method m : cl.getMethods()) if(m.getName().equals(method)) return m;
        return null;
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
