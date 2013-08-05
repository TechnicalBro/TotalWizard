package TotalWizard.Handlers.Magic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import SkillSystem.Skills;
import SkillSystem.Handlers.SkillHandlers;
import TotalWizard.Handlers.ItemHandlers.*;
import TotalWizard.Handlers.Magic.Spells.*;
import TotalWizard.Handlers.Magic.Spells.Buffs.*;
import TotalWizard.Handlers.Magic.Spells.Damage.*;
import TotalWizard.Handlers.Magic.Spells.Debuff.*;
import TotalWizard.Handlers.Magic.Spells.Heal.*;
import TotalWizard.Handlers.Magic.Spells.Heal.HealingII;
import TotalWizard.Handlers.Magic.Spells.Projectile.*;
import TotalWizard.Handlers.Magic.Spells.Summons.*;
import TotalWizard.Handlers.Magic.Spells.Utility.*;

public class MagicHandler
{
	
	private ItemHandler ItemHandler = new ItemHandler();
	private HashMap<String, Spell> Spells = new HashMap<String, Spell>();
	
	//Spells Registry
	private CombustI CombustI = new CombustI();
	private CombustII CombustII = new CombustII();
	private IgniteI IgniteI = new IgniteI();
	
	private FatigueI FatigueI = new FatigueI();
	private FatigueII FatigueII = new FatigueII();
	
	private HealingI HealingI = new HealingI();
	private HealingII HealingII = new HealingII();
	private HealthBubble HealthBubble = new HealthBubble();
	
	private LightningStrikeI LightningStrikeI = new LightningStrikeI();
	private LightningStrikeII LightningStrikeII = new LightningStrikeII();
	
	private SpeedI SpeedI = new SpeedI();
	private SpeedII SpeedII = new SpeedII();
	
	private MinerI MinerI = new MinerI();
	
	private Vampirism Vampirism = new Vampirism();
	
	private FeedI FeedI = new FeedI();
	
	private PhoenixArrow PhoenixArrow = new PhoenixArrow();
	private PiercingBarrage PiercingBarrage = new PiercingBarrage();
	
	private Blink Blink = new Blink();
	
	private EnderInvasion EnderInvasion = new EnderInvasion();
	
	private Hadouken Hadouken = new Hadouken();
	
	private Vanish Vanish = new Vanish();
	
	private AnimatedDeadMinor AnimatedDeadMinor = new AnimatedDeadMinor();
	
	private ZombieHerder ZombieHerder = new ZombieHerder();
	
	private SlowI SlowI = new SlowI();
	
	private AuraOfProtection AuraOfProtection = new AuraOfProtection();
	
	private ShickenCombustion ShickenCombustion = new ShickenCombustion();
	
	private Squidsplosion Squidsplosion = new Squidsplosion();
	
	public MagicHandler()
	{
		Spells.put(CombustI.getName(), CombustI);
		Spells.put(CombustII.getName(), CombustII);
		Spells.put(AuraOfProtection.getName(), AuraOfProtection);
		Spells.put(ShickenCombustion.getName(), ShickenCombustion);
		Spells.put(Squidsplosion.getName(), Squidsplosion);
		
		Spells.put(FatigueI.getName(), FatigueI);
		Spells.put(FatigueII.getName(),FatigueII);
		Spells.put(SlowI.getName(), SlowI);
		
		Spells.put(HealingI.getName(), HealingI);
		Spells.put(HealingII.getName(), HealingII);
		Spells.put(HealthBubble.getName(), HealthBubble);
		
		Spells.put(LightningStrikeI.getName(), LightningStrikeI);
		Spells.put(LightningStrikeII.getName(), LightningStrikeII);
		
		Spells.put(FeedI.getName(), FeedI);
		
		Spells.put(SpeedI.getName(), SpeedI);
		Spells.put(SpeedII.getName(), SpeedII);
		
		Spells.put(PhoenixArrow.getName(), PhoenixArrow);
		
		Spells.put(Blink.getName(), Blink);
		
		Spells.put(EnderInvasion.getName(), EnderInvasion);
		Spells.put(AnimatedDeadMinor.getName(), AnimatedDeadMinor);
		Spells.put(ZombieHerder.getName(), ZombieHerder);
		
		Spells.put(Hadouken.getName(), Hadouken);
		
		Spells.put(Vanish.getName(), Vanish);
		
		Spells.put(PiercingBarrage.getName(), PiercingBarrage);
		
		Spells.put(IgniteI.getName(), IgniteI);
		
		Spells.put(MinerI.getName(), MinerI);
		
		Spells.put(Vampirism.getName(), Vampirism);
		
	}
	
	public enum SpellType
	{
		LightningStrike,
		Fatigue,
		Combust,
		Healing,
		Speed,
		Feed,
		Teleport,
		Hadouken,
		Vanish,
		Protection,
		Ignite,
		Vampirism
	}
	
	/**
	 * All the current spells
	 * @return A hashmap with the spells name, along with its element (which contains all other data)
	 */
	public HashMap<String, Spell> getSpellList()
	{
		return this.Spells;
	}
	
	/**
	 * Check if the itemstack is a wand
	 * @param Item ItemStack to check
	 * @return true if the material is a Stick, and it contains "Wand" or "wand" in its name, and the lore contains "Spell: ", false otherwise
	 */
	public boolean isWand(ItemStack Item)
	{
		if (Item.getType() == Material.STICK)
		{
			if (ItemHandler.getItemName(Item).contains("Wand") || ItemHandler.getItemName(Item).contains("wand"))
			{
				if (ItemHandler.itemLoreContains(Item, "Spell: "))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Get the spell a wand uses
	 * @param Item
	 * @return The spell of a wand, throws nullpointer if it doesn't have a spell
	 */
	public Spell getSpell(ItemStack Item)
	{
		if (isWand(Item))
		{
			for(String S : ItemHandler.getItemLore(Item))
			{
				if (S.toLowerCase().contains("spell: "))
				{
					String SpellName = StringUtils.substringAfter(S, "Spell: ");
					if (this.Spells.containsKey(SpellName))
					{
						return this.Spells.get(SpellName);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Get the required mana for a wand to be used
	 * @param Item ItemStack to get the mana of
	 * @return The cost of mana for the wand, otherwise throws nullpointer exception
	 */
	public int getWandMana(ItemStack Item)
	{
		if (isWand(Item))
		{
			for(String S : ItemHandler.getItemLore(Item))
			{
				if (S.toLowerCase().contains("costs "))
				{
					String After = StringUtils.substringBetween(S, "Costs ", "mana");
					return Integer.parseInt(After);
				}
			}
		}
		throw new NullPointerException("Item is not a want and/or doesn't require mana");
	}
	
	/**
	 * Get the required level to use this wand
	 * @param Item ItemStack to check requirements of
	 * @return Level required for wand if it's on the items lore, otherwise -1
	 */
	public int getWandLevelRequirement(ItemStack Item)
	{
		if (isWand(Item))
		{
			for(String S : ItemHandler.getItemLore(Item))
			{
				if (S.toLowerCase().contains("requires level "))
				{
					String LevelReq = StringUtils.substringBetween(S, "Requires level ", " magic");
					return Integer.parseInt(LevelReq);
				}
			}
		}
		return -1;
	}
	
	/**
	 * Has the player met the requirements (IE: Level)
	 * @param Player Player to check
	 * @param LevelRequired Level they must meet
	 * @return true if their magic level is above or equal to the level required
	 */
	public boolean isPlayerMeetRequirements(String Player, int LevelRequired)
	{
		 if (Skills.getPlayerHandler(Player).getSkill("Magic").getLevel() >= LevelRequired)
		 {
			 return true;
		 }
		 return false;
	}
	
	/**
	 * 
	 * @param Player Has the player met the requirements (IE: Level)
	 * @param Item The itemstack to check if they've met the requirements of to use
	 * @return true if their magiclevel is above or equal to the level required on the wand
	 */
	public boolean isPlayerMeetRequirements(String Player, ItemStack Item)
	{
		return isPlayerMeetRequirements(Player,getWandLevelRequirement(Item));
	}
	
	/**
	 * Gets the bonus for damage/heals/ticks of a spell
	 * @param Spell SpellType to check
	 * @param Player Player to get the bonuses for
	 * @return double with the bonuses
	 */
	public double getBonus(SpellType Spell, String Player)
	{
		double MagicLevel = Skills.getPlayerHandler(Player).getSkill("Magic").getLevel();
		switch (Spell)
		{
			case LightningStrike:
				return ((int)MagicLevel * 5);
			case Fatigue:
				return ((int)MagicLevel * 4);
			case Combust:
				return ((int)MagicLevel * 5);
			case Healing:
				return ((int)MagicLevel * 1.8);
			case Speed:
				return ((int)MagicLevel * 2);
			case Teleport:
				return ((int)MagicLevel * 1.5);
			case Vanish:
				return ((int)MagicLevel * 2);
			case Protection:
				return ((int)MagicLevel * 3);
			case Ignite:
				return ((int)MagicLevel * 2);
			case Vampirism:
				return ((int)MagicLevel * 2.3);
			default:
				return 0;
		}
	}
	
	/**
	 * Does the player have enough mana to cast this spell?
	 * @param Player Player to check
	 * @param Spell Spell to check
	 * @return true if they do, false otherwise
	 */
	public boolean hasEnoughMana(Player Player, Spell Spell)
	{
		return Player.getLevel() >= Spell.getManaRequirement();
	}
	
	/**
	 * The calculation for a players maximum mana
	 * @param Player Player to check
	 * @return Returns 10 + (Players_MagicLevel * 5) -- Level 40 magic would have 210 Mana
	 */
	public int getMaxMana(String Player)
	{
		double MagicLevel = Skills.getPlayerHandler(Player).getSkill("Magic").getLevel();
		return 10 + ((int)MagicLevel * (5));
	}
	
	/**
	 * Get a players current Mana
	 * @param Player Player to check
	 * @return int of Mana remaining
	 */
	
	public int getMana(Player Player)
	{
		return Player.getLevel();
	}
	
	public void AddSpellExp(String Player, Spell Spell)
	{
		SkillHandlers.HandleMagic(Player, Spell.getCastExp());
	}
}
