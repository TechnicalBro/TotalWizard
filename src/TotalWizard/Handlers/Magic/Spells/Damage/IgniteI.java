package TotalWizard.Handlers.Magic.Spells.Damage;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class IgniteI extends Spell
{

	@Override
	public String getName()
	{
		return "Ignite I";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects Flames = ParticleEffects.FLAME;
		try
		{
			LivingEntity Target = this.getEntityInSight(Player);
			if (Target != null)
			{
				ParticleEffects PE = ParticleEffects.SPELL;
				PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 5 + new Random().nextInt(15));
				Target.setFireTicks((int)(40 + TotalWizard.TotalWizard.MagicHandler.getBonus(SpellType.Ignite, Player.getName())));
				Flames.sendToAll(Target.getLocation(), new Random().nextFloat(), 9 + new Random().nextInt(15));
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception Ex)
		{
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 2;
	}

	@Override
	public int getManaRequirement()
	{
		return 6;
	}

	@Override
	public int getCastExp()
	{
		return 4;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Set your foes ablaze with wholesome arcane force",ChatColor.RED + "Requires level 2 magic, costs 5 mana to cast" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.FIRE);
	}

}
