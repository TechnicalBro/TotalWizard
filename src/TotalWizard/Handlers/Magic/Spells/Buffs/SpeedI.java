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

public class SpeedI extends Spell
{

	@Override
	public String getName()
	{
		return "Speed I";
	}

	@Override
	public boolean Cast(Player Player)
	{
		Player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,(int) (120 + TotalWizard.MagicHandler.getBonus(SpellType.Speed, Player.getName())),2));
		ParticleEffects PE = ParticleEffects.BUBBLE;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(15));
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
		return 1;
	}

	@Override
	public int getManaRequirement()
	{
		return 7;
	}

	@Override
	public int getCastExp()
	{
		return 4;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Give yourself the speed of the wind to outrun foes",ChatColor.RED + "Requires level 1 magic, costs 7 mana"};
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK, (byte)12);
	}

}
