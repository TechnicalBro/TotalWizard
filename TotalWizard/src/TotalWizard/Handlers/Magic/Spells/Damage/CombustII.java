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

public class CombustII extends Spell
{
	public CombustII()
	{
		
	}

	@Override
	public String getName()
	{
		return "Combust II";
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
				E.getWorld().createExplosion(E.getLocation().getX(),E.getLocation().getY(),E.getLocation().getZ(), 3.5F, false,false);
				PE.sendToAll(E.getLocation(), new Random().nextFloat(), 12 + new Random().nextInt(21));
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
		return 10;
	}

	@Override
	public int getManaRequirement()
	{
		return 26;
	}

	@Override
	public int getCastExp()
	{
		return 18;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Unleash the force of an",ChatColor.YELLOW + "electrified creeper onto your foe",ChatColor.RED + "Requires level 10 magic, costs 26 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.BLAZE_POWDER);
	}

}
