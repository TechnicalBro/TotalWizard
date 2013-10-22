package TotalWizard.Handlers.Magic.Spells.Debuff;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class SlowI extends Spell
{

	@Override
	public String getName()
	{
		return "Slowness I";
	}

	@Override
	public boolean Cast(Player Player)
	{
		LivingEntity Target = this.getEntityInSight(Player);
		if (Target != null)
		{
			if (!Target.hasMetadata("NPC"))
			{
				ParticleEffects PE = ParticleEffects.SUSPEND;
				ParticleEffects Cast = ParticleEffects.FLAME;
				try
				{
					Cast.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(15));
					Target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,(int) (100 + TotalWizard.MagicHandler.getBonus(SpellType.Fatigue, Player.getName())),1));
					PE.sendToAll(Target.getLocation(),new Random().nextFloat(), 10 + new Random().nextInt(15));
					return true;
				}
				catch (Exception e)
				{
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public int getLevelRequirement()
	{
		return 1;
	}

	@Override
	public int getManaRequirement()
	{
		return 5;
	}

	@Override
	public int getCastExp()
	{
		return 3;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Weigh the air against your foe",ChatColor.YELLOW + "burden them and make them slow",ChatColor.RED + "Requires level 1 magic, costs 5 mana" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.SPIDER_EYE);
	}

}
