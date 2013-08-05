package TotalWizard.Handlers.Magic.Spells;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public abstract class Spell
{
	public abstract String getName();
	public abstract boolean Cast(Player Player);
	public abstract int getLevelRequirement();
	public abstract int getManaRequirement();
	public abstract int getCastExp();
	public abstract String[] getDescription();
	public abstract MaterialData getMaterialData();
	
	public List<LivingEntity> getEntitiesNearLocation(Location Location, int Radius)
	{
		List<LivingEntity> Return = new ArrayList<LivingEntity>();
		for (LivingEntity Entity : Location.getWorld().getLivingEntities())
		{
			if (Entity.getLocation().distance(Location) < Radius)
			{
				Return.add(Entity);
			}
		}
		return Return;
	}
	
	public LivingEntity getEntityInSight(Player Player)
	{
        BlockIterator iterator = new BlockIterator(Player.getWorld(), Player.getLocation().toVector(), Player.getEyeLocation().getDirection(), 0, 50);
        while (iterator.hasNext())
        {
            Block item = iterator.next();
            for (Entity entity : Player.getNearbyEntities(50, 50, 50))
            {
            	if (entity instanceof LivingEntity)
            	{
	                int acc = 2;
	                for (int x = -acc ; x < acc ; x++)
	                {
	                    for (int z = -acc ; z < acc ; z++)
	                    {
	                        for (int y = -acc ; y < acc ; y++)
	                        {
	                            if (entity.getLocation().getBlock().getRelative(x, y, z).equals(item))
	                            {
	                                return ((LivingEntity)entity);
	                            }
	                        }
	                    }
	                }
            	}
            }
        }
        return null;
	}
}
