package TotalWizard.Handlers.Magic.Spells.Buffs;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class SpeedII extends Spell
{

	@Override
	public String getName()
	{
		return "Speed II";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.BUBBLE;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 15 + new Random().nextInt(25));
			Player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,(int) (240 + TotalWizard.MagicHandler.getBonus(SpellType.Speed, Player.getName())),2));
			Player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (int) (240 + TotalWizard.MagicHandler.getBonus(SpellType.Speed, Player.getName())),1));
			return true;
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
		return 17;
	}

	@Override
	public int getCastExp()
	{
		return 14;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Give yourself the speed of the wind, and weight of air",ChatColor.YELLOW + "to outrun and outjump your foes",ChatColor.RED + "Requires level 10 magic, costs 17 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK, (byte)12);
	}

}
