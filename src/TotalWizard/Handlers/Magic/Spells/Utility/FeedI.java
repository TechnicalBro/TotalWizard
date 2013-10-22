package TotalWizard.Handlers.Magic.Spells.Utility;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class FeedI extends Spell
{

	@Override
	public String getName()
	{
		return "Feed I";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.FIREWORKS_SPARK;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 4 + new Random().nextInt(5));
			Player.setFoodLevel(Player.getFoodLevel() + 10);
			return true;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 3;
	}

	@Override
	public int getManaRequirement()
	{
		return 20;
	}

	@Override
	public int getCastExp()
	{
		return 12;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Restore your hunger by 10 levels",ChatColor.RED + "Requires level 3 magic, costs 20 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK, (byte)11);
	}

}
