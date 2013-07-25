package TotalWizard.Handlers.Magic.Spells.Buffs;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;
import TotalWizard.TotalWizard;

public class AuraOfProtection extends Spell
{

	@Override
	public String getName()
	{
		return "Aura of Protection";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.ENCHANTMENT_TABLE;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(10));
			Player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,(int)(160 + TotalWizard.MagicHandler.getBonus(SpellType.Protection, Player.getName())), 1));
			return true;
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
			return false;
		}
	}

	@Override
	public int getLevelRequirement()
	{
		return 7;
	}

	@Override
	public int getManaRequirement()
	{
		return 20;
	}

	@Override
	public int getCastExp()
	{
		return 14;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Surround yourself in a shield of mana",ChatColor.YELLOW + "and weaken incoming damage",ChatColor.RED + "Requires level 1 magic, costs 20 mana" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.IRON_CHESTPLATE);
	}

}
