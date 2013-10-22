package TotalWizard.Handlers.Magic.Spells.Damage;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.Magic.MagicHandler;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;
import TotalWizard.TotalWizard;

public class LightningStrikeII extends Spell
{
	
	public LightningStrikeII()
	{
		
	}

	@Override
	public String getName()
	{
		return "Lightning Strike II";
	}

	@Override
	public boolean Cast(Player Player)
	{
		LivingEntity Entity = this.getEntityInSight(Player);
		if (Entity != null)
		{
			Entity.getWorld().strikeLightning(Entity.getLocation());
			for(LivingEntity Ent : this.getEntitiesNearLocation(Entity.getLocation(), 6))
			{
				Ent.setFireTicks(20 + new Random().nextInt(15) + (int) TotalWizard.MagicHandler.getBonus(SpellType.LightningStrike, Player.getName()));
			}
			return true;
		}
		return false;
	}

	@Override
	public int getLevelRequirement()
	{
		return 10;
	}

	@Override
	public int getManaRequirement()
	{
		return 23;
	}

	@Override
	public int getCastExp()
	{
		return 17;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Strike a foe with the raw power of lightning",ChatColor.YELLOW + "setting each enemy in a 6 block radius on fire",ChatColor.RED + "Requires level 10 magic, costs 23 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.NETHER_STAR);
	}

}
