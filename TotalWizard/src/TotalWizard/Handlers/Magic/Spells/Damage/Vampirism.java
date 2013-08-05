package TotalWizard.Handlers.Magic.Spells.Damage;
//Spell Category = Spell Category

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class Vampirism extends Spell
{

	@Override
	public String getName()
	{
		return "Vampirism";
	}

	@Override
	public boolean Cast(Player Player)
	{
		try
		{
			ParticleEffects PE = ParticleEffects.RED_DUST;
			try
			{
				PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(15));
				LivingEntity Target = this.getEntityInSight(Player);
				if (Target != null)
				{
					double Split = TotalWizard.TotalWizard.MagicHandler.getBonus(SpellType.Vampirism, Player.getName()) / 2;
					double Damaged = 10 + ((new Random().nextInt(6) + new Random().nextInt(6))) + (new Random().nextInt((int)Split) + (new Random().nextInt((int)Split)));
					double TargetHealth = ((Damageable)Target).getHealth();
					if (Damaged > TargetHealth)
					{
						Damaged = TargetHealth;
					}
					int Bleed = 15 + new Random().nextInt(11);
					PE.sendToAll(Player.getLocation(), new Random().nextFloat(), Bleed);
					Target.setHealth(TargetHealth - Damaged);
					PE.sendToAll(Target.getLocation(),new Random().nextFloat(), Bleed);
					Damageable PlayerD = ((Damageable)Player);
					if (PlayerD.getHealth() + Damaged > PlayerD.getMaxHealth())
					{
						PlayerD.setHealth(PlayerD.getMaxHealth());
					}
					else
					{
						PlayerD.setHealth(PlayerD.getHealth() + Damaged);
					}
					return true;
				}
				else
				{
					return false;
				}
			}
			catch (Exception Ex)
			{
				return false;
			}
		}
		catch (Exception Ex)
		{
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 35;
	}

	@Override
	public int getManaRequirement()
	{
		return 65;
	}

	@Override
	public int getCastExp()
	{
		return 50;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Leech the well-being of your enemy to better yourself",ChatColor.RED + "Requires level 35 magic, costs 65 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK,(byte)1);
	}

}