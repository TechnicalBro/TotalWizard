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

public class ShickenCombustion extends Spell
{

	@Override
	public String getName()
	{
		return "Chicken Fire";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.LARGE_SMOKE;
		boolean Casted = false;
		for(LivingEntity E : this.getEntitiesNearLocation(Player.getTargetBlock(null, 15).getLocation(), 5))
		{
			if (E.getType() == EntityType.CHICKEN)
			{
				try
				{
					PE.sendToAll(E.getLocation(), new Random().nextFloat(), 5 + new Random().nextInt(11));
					E.setFireTicks(80);
					Casted = true;
				}
				catch (Exception Ex)
				{
					return false;
				}
			}
		}
		return Casted;
	}

	@Override
	public int getLevelRequirement()
	{
		return 5;
	}

	@Override
	public int getManaRequirement()
	{
		return 10;
	}

	@Override
	public int getCastExp()
	{
		return 8;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Set all chickens in a 5 block radius",ChatColor.YELLOW + "on fire for entertainment...",ChatColor.ITALIC + "You sick bastard.",ChatColor.RED + "Requires level 5 magic, costs 10 mana" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.COOKED_CHICKEN);
	}

}
