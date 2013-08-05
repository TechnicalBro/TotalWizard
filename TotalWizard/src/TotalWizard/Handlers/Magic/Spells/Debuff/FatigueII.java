package TotalWizard.Handlers.Magic.Spells.Debuff;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler;
import TotalWizard.*;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class FatigueII extends Spell
{
	
	public FatigueII() { };

	@Override
	public String getName()
	{
		return "Fatigue II";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.SLIME;
		try
		{
			LivingEntity E = this.getEntityInSight(Player);
			if (this.getEntityInSight(Player) != null)
			{
				if (!E.hasMetadata("NPC"))
				{
					PE.sendToAll(E.getLocation(), new Random().nextFloat(), 15 + new Random().nextInt(10));
					E.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, (int) (120 + TotalWizard.MagicHandler.getBonus(SpellType.Fatigue, Player.getName())), 2));
					E.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (int) (120 + TotalWizard.MagicHandler.getBonus(SpellType.Fatigue, Player.getName())), 2));
					E.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) (120 + TotalWizard.MagicHandler.getBonus(SpellType.Fatigue, Player.getName())), 2));
					return true;
				}
				return false;
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
		return 18;
	}

	@Override
	public int getCastExp()
	{
		return 14;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Confuse, slow, and weaken your enemy for ~6 seconds",ChatColor.RED + "Requires level 7 magic, costs 18 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.ROTTEN_FLESH);
	}

}
