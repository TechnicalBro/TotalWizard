package TotalWizard.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import TotalWizard.TotalWizard;
import TotalWizard.Handlers.Cooldown.Cooldown;
import TotalWizard.Handlers.Magic.Spells.Spell;
import TotalWizard.Handlers.Regions.RegionHandler;

public class PlayerEvents implements Listener
{
	private Cooldown SpellCooldown = new Cooldown(1);
	private Cooldown CombustCooldown = new Cooldown(15);
	private RegionHandler Regios;
	
	public PlayerEvents(TotalWizard Plugin)
	{
		this.Regios = new RegionHandler(Plugin);
		Plugin.getServer().getPluginManager().registerEvents(this, Plugin);
	}
	
	@EventHandler
	public void PlayerInteracted(PlayerInteractEvent Event)
	{
		if (Event.getAction() == Action.RIGHT_CLICK_AIR || Event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Player Player = Event.getPlayer();
			if (Event.getPlayer().getItemInHand() != null)
			{
				if (TotalWizard.MagicHandler.isWand(Player.getItemInHand()))
				{
					if (!SpellCooldown.IsOnCooldown(Player.getName()))
					{
						Spell Spell = TotalWizard.MagicHandler.getSpell(Player.getItemInHand());
						if (Spell != null)
						{
							if (TotalWizard.WorldguardHooked == true && this.Regios.isPlayerInNoPVPRegion(Player))
							{
								Player.sendMessage(ChatColor.RED + "You can't use spells in this area, sorry");
								SpellCooldown.SetOnCooldown(Player.getName());
								Event.setCancelled(true);
								return;
							}
							else
							{
								if ((Spell.getName().contains("Combust") || Spell.getName().contains("Lightning")) && this.CombustCooldown.IsOnCooldown(Player.getName()))
								{
									Event.setCancelled(true);
									return;
								}
								if (TotalWizard.MagicHandler.isPlayerMeetRequirements(Event.getPlayer().getName(), Player.getItemInHand()))
								{
									if (TotalWizard.MagicHandler.hasEnoughMana(Player, Spell))
									{
										if (Spell.Cast(Player) == true)
										{
											Player.setLevel(Player.getLevel() - Spell.getManaRequirement());
											TotalWizard.MagicHandler.AddSpellExp(Player.getName(), Spell);
											if ((Spell.getName().contains("Combust") || Spell.getName().contains("Lightning")))
											{
												this.CombustCooldown.SetOnCooldown(Player.getName());
											}
											else
											{
												SpellCooldown.SetOnCooldown(Player.getName());
											}
										}
									}
									else
									{
										Player.sendMessage(ChatColor.RED + "You don't have enough mana to cast " + Spell.getName());
										SpellCooldown.SetOnCooldown(Player.getName());
										Event.setCancelled(true);
									}
								}
								else
								{
									Player.sendMessage(ChatColor.RED + "You don't meet the required level of " + Spell.getLevelRequirement() + " to cast " + Spell.getName());
									SpellCooldown.SetOnCooldown(Player.getName());
									Event.setCancelled(true);
								}
							}
						}
					}
				}
			}
		}
	}

}
