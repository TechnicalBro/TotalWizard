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
import TotalWizard.TotalWizard;
import TotalWizard.Handlers.Magic.MagicHandler;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class FatigueI extends Spell
{
	
	public FatigueI() { }

	@Override
	public String getName()
	{
		return "Fatigue I";
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
					E.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, (int) (40 + TotalWizard.MagicHandler.getBonus(SpellType.Fatigue, Player.getName())), 1));
					E.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) (40 + TotalWizard.MagicHandler.getBonus(SpellType.Fatigue, Player.getName())), 1));
					PE.sendToAll(E.getLocation(), new Random().nextFloat(), 15 + new Random().nextInt(10));
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
		return new String[] {ChatColor.YELLOW + "Confuse and weaken your enemy for ~2 seconds",ChatColor.RED + "Requires level 1 magic, costs 5 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.ROTTEN_FLESH);
	}

}
