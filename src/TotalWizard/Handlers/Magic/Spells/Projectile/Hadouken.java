package TotalWizard.Handlers.Magic.Spells.Projectile;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class Hadouken extends Spell
{

	@Override
	public String getName()
	{
		return "Hadouken";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.FLAME;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(10));
			Projectile P = Player.launchProjectile(LargeFireball.class);
			P.setBounce(false);
			P.setFireTicks(160);
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
		return 40;
	}

	@Override
	public int getManaRequirement()
	{
		return 110;
	}

	@Override
	public int getCastExp()
	{
		return 75;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Launch a large flaming fireball",ChatColor.YELLOW + "At your enemies. HADOUKEN!",ChatColor.RED + "Requires level 40 magic, costs 210 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.FIREBALL);
	}

}
