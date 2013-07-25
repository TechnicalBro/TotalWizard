package TotalWizard.Handlers.Magic.Spells.Damage;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class CombustI extends Spell
{
	
	public CombustI()
	{
		
	}

	@Override
	public String getName()
	{
		return "Combust I";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.LARGE_SMOKE;
		try
		{
			LivingEntity E = this.getEntityInSight(Player);
			if (this.getEntityInSight(Player) != null)
			{
				PE.sendToAll(E.getLocation(), new Random().nextFloat(), 5 + new Random().nextInt(10));
				E.getWorld().createExplosion(E.getLocation().getX(),E.getLocation().getY(),E.getLocation().getZ(), 1.0F, false,false);
				return true;
			}
			return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 1;
	}

	@Override
	public int getManaRequirement()
	{
		return 9;
	}

	@Override
	public int getCastExp()
	{
		return 5;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Unleash the force of TNT onto your foe",ChatColor.RED + "Requires level 1 magic, costs 9 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.BLAZE_POWDER);
	}

}
