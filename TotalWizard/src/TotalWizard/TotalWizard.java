package TotalWizard;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import TotalWizard.Events.PlayerEvents;
import TotalWizard.Handlers.Magic.MagicHandler;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;


public class TotalWizard extends JavaPlugin
{
	
	public static MagicHandler MagicHandler;
	public static boolean WorldguardHooked = false;
	public static WorldGuardPlugin WorldGuard;
	
	@Override
	public void onEnable()
	{
		 MagicHandler = new MagicHandler();
		 new PlayerEvents(this);
		 if (getWorldGuard() != null)
		 {
			 Bukkit.getLogger().info("Total Wizard has hooked into worldguard");
			 WorldguardHooked = true;
			 WorldGuard = getWorldGuard();
		 }
	}
	
	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this);
	}
	
	private WorldGuardPlugin getWorldGuard()
	{
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}
}
