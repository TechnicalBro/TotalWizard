package TotalWizard.Handlers.Magic.Spells.Damage;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.Magic.MagicHandler;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class LightningStrikeI extends Spell
{
	
	public LightningStrikeI()
	{
		
	}

	@Override
	public String getName()
	{
		return "Lightning Strike I";
	}

	@Override
	public boolean Cast(Player Player)
	{
		LivingEntity Entity = this.getEntityInSight(Player);
		if (Entity != null)
		{
			Entity.getWorld().strikeLightningEffect(Entity.getLocation());
			Entity.setFireTicks(10 + (int) TotalWizard.MagicHandler.getBonus(SpellType.LightningStrike, Player.getName()));
			/*
			for(LivingEntity Ent : this.getEntitiesNearLocation(Entity.getLocation(), 4))
			{
				Ent.setFireTicks(10 + (int) TotalWizard.MagicHandler.getBonus(SpellType.LightningStrike, Player.getName()));
			}
			*/
			return true;
		}
		return false;
	}

	@Override
	public int getLevelRequirement()
	{
		return 5;
	}

	@Override
	public int getManaRequirement()
	{
		return 12;
	}

	@Override
	public int getCastExp()
	{
		return 9;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Strike your foe with lightning, setting them onfire",ChatColor.RED + "Requires level 5 magic, costs 12 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.NETHER_STAR);
	}

}
