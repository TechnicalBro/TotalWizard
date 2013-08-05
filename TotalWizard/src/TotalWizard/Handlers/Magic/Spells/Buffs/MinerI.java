package TotalWizard.Handlers.Magic.Spells.Buffs;
//Spell Category = Buffs

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.EffectHandlers.ParticleEffects;
import TotalWizard.Handlers.Magic.MagicHandler.SpellType;
import TotalWizard.Handlers.Magic.Spells.Spell;

public class MinerI extends Spell
{

	@Override
	public String getName()
	{
		return "Mining Haste";
	}

	@Override
	public boolean Cast(Player Player)
	{
		ParticleEffects PE = ParticleEffects.LARGE_SMOKE;
		try
		{
			PE.sendToAll(Player.getLocation(), new Random().nextInt(), 10 + new Random().nextInt(11));
			Player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,(int) (240 + TotalWizard.MagicHandler.getBonus(SpellType.Speed, Player.getName())),1));
			return true;
		}
		catch (Exception Ex)
		{
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
		return 35;
	}

	@Override
	public int getCastExp()
	{
		return 21;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Channel arcane mana to increase your mining speed",ChatColor.RED + "Requires level 7 magic, costs 35 mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.INK_SACK, (byte)12);
	}

}