package TotalWizard.Handlers.Magic.Spells.Projectile;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class PiercingBarrage extends Spell
{

	@Override
	public String getName()
	{
		return "Piercing Barrage";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.SPELL;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(10));
			for(int I = 0; I < 5; I++)
			{
				Player.launchProjectile(Arrow.class);
			}
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
		return 18;
	}

	@Override
	public int getManaRequirement()
	{
		return 65;
	}

	@Override
	public int getCastExp()
	{
		return 42;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Launch 5 arrows in rapid succession",ChatColor.RED + "Requires level 18 magic, costs 65 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.ARROW);
	}

}
