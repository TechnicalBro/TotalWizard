package TotalWizard.Handlers.Magic.Spells.Heal;
//Spell Category = Heal

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class HealthBubble extends Spell
{

	@Override
	public String getName()
	{
		return "Health Bubble";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.HEART;
		try
		{
			/*
			Self Heals K
			*/
			Damageable Play = (Damageable)Player;
			double PlayerHealth = Play.getHealth();
			double PlayerMaxHealth = Play.getMaxHealth();
			double HealAmount = 2 * TotalWizard.MagicHandler.getBonus(SpellType.Healing, Player.getName());
			if ((PlayerHealth + HealAmount) > PlayerMaxHealth)
			{
				Play.setHealth(PlayerMaxHealth);
			}
			else
			{
				Play.setHealth(PlayerHealth + HealAmount);
			}
			PE.sendToAll(Player.getEyeLocation(), new Random().nextFloat(), 10 + new Random().nextInt(15));
			return true;
		}
		catch (Exception Ex)
		{
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
		return new String[] {ChatColor.YELLOW + "Heal yourself for a minor amount",ChatColor.RED + "Requires level 1 magic, costs 6 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK,(byte)1);
	}

}