package TotalWizard.Handlers.Magic.Spells.Summons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import TotalWizard.Handlers.Magic.Spells.Spell;

public class EnderInvasion extends Spell
{

	@Override
	public String getName()
	{
		return "Ender Invasion";
	}

	@Override
	public boolean Cast(Player Player)
	{
		return false;
	}

	@Override
	public int getLevelRequirement()
	{
		return 700;
	}

	@Override
	public int getManaRequirement()
	{
		return 150000;
	}

	@Override
	public int getCastExp()
	{
		return 4;
	}

	@Override
	public String[] getDescription()
	{
		return new String[] {ChatColor.YELLOW + "Summon an Enderdragon under your command",ChatColor.YELLOW + "and desimate anything in your way",ChatColor.RED + "Requires level 700 Magic, costs 150k Mana" };
	}
	
	@Override
	public MaterialData getMaterialData()
	{
		return new MaterialData(Material.DRAGON_EGG);
	}

}
