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

public class AuraOfProtectionMajor extends Spell
{

	@Override
	public String getName()
	{
		return "Aura of Protection II";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.ENCHANTMENT_TABLE;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextFloat(), 10 + new Random().nextInt(10));
			Player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,(int)(360 + TotalWizard.MagicHandler.getBonus(SpellType.Protection, Player.getName())), 2));
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
		return 28;
	}

	@Override
	public int getManaRequirement()
	{
		return 35;
	}

	@Override
	public int getCastExp()
	{
		return 32;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Surround yourself in a shield of mana",ChatColor.YELLOW + "and deaden incoming damage",ChatColor.RED + "Requires level 28 magic, costs 35 mana" };
	}

	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.IRON_CHESTPLATE);
	}

}
