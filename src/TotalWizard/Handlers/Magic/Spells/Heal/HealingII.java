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

public class HealingII extends Spell
{
	
	public HealingII() { };

	@Override
	public String getName()
	{
		return "Healing Wave";
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
				for(LivingEntity Entity : this.getEntitiesNearLocation(E.getLocation(), 5))
				{
					if (!Entity.hasMetadata("NPC"))
					{
						double Healing = 15 + (4 * TotalWizard.MagicHandler.getBonus(SpellType.Healing, Player.getName()));
						if ((((Damageable)Entity).getHealth() + Healing) < ((Damageable)Entity).getMaxHealth())
						{
							((Damageable)Entity).setHealth(((Damageable)Entity).getHealth() + Healing);
							for(PotionEffect P : Entity.getActivePotionEffects())
							{
								Entity.removePotionEffect(P.getType());
							}
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
		return 10;
	}

	@Override
	public int getManaRequirement()
	{
		return 18;
	}

	@Override
	public int getCastExp()
	{
		return 14;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Heal any entity within a 5 block radius",ChatColor.YELLOW + "of where you cast for a medium-high amount",ChatColor.YELLOW + "and remove any active potion effects they have",ChatColor.RED + "Requires level 10 magic, costs 18 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK,(byte)1);
	}

}
