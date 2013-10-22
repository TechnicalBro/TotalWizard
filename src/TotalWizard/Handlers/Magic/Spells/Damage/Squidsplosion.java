package TotalWizard.Handlers.Magic.Spells.Damage;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class Squidsplosion extends Spell
{

	@Override
	public String getName()
	{
		return "Squidsplosion";
	}

	@Override
	public boolean Cast(Player Player)
	{
		LivingEntity Target = this.getEntityInSight(Player);
		if (Target != null)
		{
			ParticleEffects PE = ParticleEffects.LARGE_SMOKE;
			for(LivingEntity E : this.getEntitiesNearLocation(Target.getLocation(), 5))
			{
				if (E.getType() == EntityType.SQUID)
				{
					try
					{
						PE.sendToAll(E.getLocation(), new Random().nextFloat(), 6 + new Random().nextInt(8));
						E.getWorld().createExplosion(E.getLocation().getX(),E.getLocation().getY(), E.getLocation().getZ(), 0.5F, false, false);
					}
					catch (Exception Ex)
					{
						return false;
					}
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 5;
	}

	@Override
	public int getManaRequirement()
	{
		return 15;
	}

	@Override
	public int getCastExp()
	{
		return 10;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Unleash an arcane scream at a squid",ChatColor.YELLOW + "and cause it to explode...",ChatColor.RED + "Requires level 5 magic, costs 20 mana" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK);
	}

}
