package TotalWizard.Handlers.Magic.Spells.Summons;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.Magic.Spells.Spell;

public class ZombieHerder extends Spell
{

	@Override
	public String getName()
	{
		return "Zombie Herder";
	}

	@Override
	public boolean Cast(Player Player)
	{
		boolean Targeted = false;
		LivingEntity Target = this.getEntityInSight(Player);
		if (Target != null)
		{
			for(LivingEntity Entity : this.getEntitiesNearLocation(Target.getLocation(), 8))
			{
				if (Entity.getType() == EntityType.ZOMBIE || Entity.getType() == EntityType.PIG_ZOMBIE)
				{
					((Creature)Entity).setTarget(Target);
					Targeted = true;
				}
			}
			return Targeted;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 38;
	}

	@Override
	public int getManaRequirement()
	{
		return 70;
	}

	@Override
	public int getCastExp()
	{
		return 54;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Send all Zombies in an 8 block radius to", ChatColor.YELLOW + "eat the brains and flesh of your target", ChatColor.RED + "Requires level 38 magic, costs 70 mana" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.SKULL_ITEM,(byte)2);
	}
}
