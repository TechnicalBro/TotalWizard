package TotalWizard.Handlers.Magic.Spells.Utility;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class Vanish extends Spell
{

	@Override
	public String getName()
	{
		return "Vanish";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.LARGE_SMOKE;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(20));
			Player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,(int) (60 + TotalWizard.TotalWizard.MagicHandler.getBonus(SpellType.Vanish, Player.getName())),1));
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
		return new String[] {ChatColor.YELLOW + "Stealth yourself and sneak upon foes",ChatColor.RED + "Requires level 5 magic, costs 15 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK, (byte)11);
	}

}
