package TotalWizard.Handlers.Magic.Spells.Heal;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class HealingI extends Spell
{
	
	public HealingI() { };

	@Override
	public String getName()
	{
		return "Healing Splash";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.HEART;
		try
		{
			LivingEntity E = this.getEntityInSight(Player);
			if (this.getEntityInSight(Player) != null)
			{
				for(LivingEntity Entity : this.getEntitiesNearLocation(E.getLocation(), 3))
				{
					if (!Entity.hasMetadata("NPC"))
					{
						double Healing = 2 * TotalWizard.MagicHandler.getBonus(SpellType.Healing, Player.getName());
						if ((((Damageable)Entity).getHealth() + Healing) < ((Damageable)Entity).getMaxHealth())
						{
							((Damageable)Entity).setHealth(((Damageable)Entity).getHealth() + Healing);
						}
					}
					PE.sendToAll(E.getLocation(), new Random().nextFloat(), 15 + new Random().nextInt(20));
				}
				return true;
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
		return 6;
	}

	@Override
	public int getCastExp()
	{
		return 6;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Heal any entity within a 3 block radius",ChatColor.YELLOW + "of where you cast for a low amount",ChatColor.RED + "Requires level 1 magic, costs 6 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK,(byte)1);
	}

}
