package TotalWizard.Handlers.Magic.Spells.Projectile;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class PhoenixArrow extends Spell
{

	@Override
	public String getName()
	{
		return "Phoenix Arrow";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.FLAME;
		
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(10));
			Projectile P = Player.launchProjectile(Arrow.class);
			Arrow Arrow = (Arrow)P;
			Arrow.setFireTicks(60);
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
		return new String[] {ChatColor.YELLOW + "Use the element of flame to shoot fiery arrows at foes",ChatColor.RED + "Requires level 4 magic, costs 6 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.ARROW);
	}
	

}
